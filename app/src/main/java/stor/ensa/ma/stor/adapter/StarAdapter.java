package stor.ensa.ma.stor.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;
import stor.ensa.ma.stor.R;
import stor.ensa.ma.stor.beans.Star;
import stor.ensa.ma.stor.service.StarService;
import java.util.ArrayList;
import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder>
        implements Filterable {

    private List<Star> stars;
    private List<Star> starsFilter;
    private Context context;
    private NewFilter mfilter;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.stars = stars;
        this.starsFilter = new ArrayList<>(stars);
        this.mfilter = new NewFilter(this);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.star_item, parent, false);
        return new StarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder,
                                 int position) {
        Star currentStar = starsFilter.get(position);

        // Charger image avec Glide
        Glide.with(context)
                .asBitmap()
                .load(currentStar.getImg())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.img);

        holder.name.setText(currentStar.getName().toUpperCase());
        holder.stars.setRating(currentStar.getStar());
        holder.idss.setText(String.valueOf(currentStar.getId()));

        // Clic → popup modifier la note
        holder.itemView.setOnClickListener(view -> {

            View popup = LayoutInflater.from(context)
                    .inflate(R.layout.star_edit_item, null, false);

            final ImageView popupImg  = popup.findViewById(R.id.img);
            final RatingBar popupBar  = popup.findViewById(R.id.ratingBar);
            final TextView  popupIdss = popup.findViewById(R.id.idss);

            // Charger l'image dans le popup via Glide
            Glide.with(context)
                    .load(currentStar.getImg())
                    .apply(new RequestOptions().override(100, 100))
                    .into(popupImg);

            // Remplir les valeurs actuelles
            popupBar.setRating(currentStar.getStar());
            popupIdss.setText(String.valueOf(currentStar.getId()));

            new AlertDialog.Builder(context)
                    .setTitle("Notez : " + currentStar.getName())
                    .setMessage("Donner une note entre 1 et 5 :")
                    .setView(popup)
                    .setPositiveButton("Valider", (dialog, which) -> {
                        float newRating = popupBar.getRating();
                        int starId = Integer.parseInt(
                                popupIdss.getText().toString());
                        Star star = StarService.getInstance()
                                .findById(starId);
                        if (star != null) {
                            star.setStar(newRating);
                            StarService.getInstance().update(star);
                            notifyItemChanged(position);
                        }
                    })
                    .setNegativeButton("Annuler", null)
                    .create()
                    .show();
        });
    }

    @Override
    public int getItemCount() { return starsFilter.size(); }

    @Override
    public Filter getFilter() { return mfilter; }

    public class StarViewHolder extends RecyclerView.ViewHolder {
        TextView idss, name;
        CircleImageView img;
        RatingBar stars;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            idss  = itemView.findViewById(R.id.ids);
            img   = itemView.findViewById(R.id.img);
            name  = itemView.findViewById(R.id.name);
            stars = itemView.findViewById(R.id.stars);
        }
    }

    public class NewFilter extends Filter {
        public RecyclerView.Adapter mAdapter;

        public NewFilter(RecyclerView.Adapter mAdapter) {
            this.mAdapter = mAdapter;
        }

        @Override
        protected FilterResults performFiltering(
                CharSequence charSequence) {
            List<Star> filtered = new ArrayList<>();
            if (charSequence == null ||
                    charSequence.length() == 0) {
                filtered.addAll(stars);
            } else {
                String filterPattern = charSequence.toString()
                        .toLowerCase().trim();
                for (Star p : stars) {
                    if (p.getName().toLowerCase()
                            .startsWith(filterPattern)) {
                        filtered.add(p);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filtered;
            results.count  = filtered.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence,
                                      FilterResults filterResults) {
            starsFilter = (List<Star>) filterResults.values;
            mAdapter.notifyDataSetChanged();
        }
    }
}