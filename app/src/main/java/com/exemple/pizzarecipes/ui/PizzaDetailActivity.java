package com.exemple.pizzarecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.exemple.pizzarecipes.R;
import com.exemple.pizzarecipes.classes.Produit;
import com.exemple.pizzarecipes.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("PIZZA_ID", -1);
        Produit p = ProduitService.getInstance().findById(id);

        if (p == null) { finish(); return; }

        ImageView img      = findViewById(R.id.imgDetail);
        TextView tvNom     = findViewById(R.id.tvDetailNom);
        TextView tvMeta    = findViewById(R.id.tvDetailMeta);
        TextView tvDesc    = findViewById(R.id.tvDetailDesc);
        TextView tvIngr    = findViewById(R.id.tvDetailIngredients);
        TextView tvEtapes  = findViewById(R.id.tvDetailEtapes);

        img.setImageResource(p.getImageRes());
        tvNom.setText(p.getNom());
        tvMeta.setText(p.getDuree() + " • " + p.getPrix() + " €");
        tvDesc.setText(p.getDescription());
        tvIngr.setText(p.getIngredients());
        tvEtapes.setText(p.getEtapes());
    }
}