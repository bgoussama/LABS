package com.exemple.pizzarecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.exemple.pizzarecipes.R;
import com.exemple.pizzarecipes.adapter.PizzaAdapter;
import com.exemple.pizzarecipes.classes.Produit;
import com.exemple.pizzarecipes.service.ProduitService;
import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        List<Produit> pizzas = ProduitService.getInstance().findAll();

        PizzaAdapter adapter = new PizzaAdapter(this, pizzas);
        ListView lv = findViewById(R.id.lvPizzas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Produit selected = pizzas.get(position);
            Intent intent = new Intent(this, PizzaDetailActivity.class);
            intent.putExtra("PIZZA_ID", selected.getId());
            startActivity(intent);
        });
    }
}