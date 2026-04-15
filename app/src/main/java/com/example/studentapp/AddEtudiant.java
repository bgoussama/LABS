package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddEtudiant extends AppCompatActivity implements View.OnClickListener {

    private EditText nom, prenom;
    private Spinner ville;
    private RadioButton m, f;
    private Button add;
    private RequestQueue requestQueue;

    private static final String insertUrl = "http://10.0.2.2/project/ws/add.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        nom    = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        ville  = findViewById(R.id.ville);
        m      = findViewById(R.id.m);
        f      = findViewById(R.id.f);
        add    = findViewById(R.id.add);

        requestQueue = Volley.newRequestQueue(this);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == add) envoyerEtudiant();
    }

    private void envoyerEtudiant() {

        StringRequest request = new StringRequest(Request.Method.POST, insertUrl,
                response -> {
                    Log.d("RESPONSE", response);
                    Toast.makeText(this, "Étudiant ajouté !", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    Log.e("VOLLEY", "Erreur: " + error.toString());
                    Toast.makeText(this, "Erreur connexion", Toast.LENGTH_SHORT).show();
                }) {

            @Override
            protected Map<String, String> getParams() {
                String sexe = m.isChecked() ? "homme" : "femme";

                Map<String, String> params = new HashMap<>();
                params.put("nom", nom.getText().toString());
                params.put("prenom", prenom.getText().toString());
                params.put("ville", ville.getSelectedItem().toString());
                params.put("sexe", sexe);

                return params;
            }
        };

        requestQueue.add(request);
    }
}