package com.exemple.pizzarecipes.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.exemple.pizzarecipes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Rediriger directement vers SplashActivity
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}