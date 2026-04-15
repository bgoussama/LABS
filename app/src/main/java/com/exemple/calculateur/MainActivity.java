package com.exemple.calculateur;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nomInput, adresseInput, surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultBase, resultSupplementaire, resultTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison XML <-> Java
        nomInput = findViewById(R.id.input_nom);
        adresseInput = findViewById(R.id.input_adresse);
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        
        resultBase = findViewById(R.id.result_base);
        resultSupplementaire = findViewById(R.id.result_supplementaire);
        resultTotal = findViewById(R.id.result_total);

        // Écouteur du bouton "Calculer"
        findViewById(R.id.button_calcul).setOnClickListener(v -> calculer());
    }

    private void calculer() {
        try {
            // Lecture des valeurs saisies
            String surfaceStr = surfaceInput.getText().toString();
            String piecesStr = piecesInput.getText().toString();

            if (surfaceStr.isEmpty() || piecesStr.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            double surface = Double.parseDouble(surfaceStr);
            int pieces = Integer.parseInt(piecesStr);
            boolean piscine = piscineCheckbox.isChecked();

            // Calcul des impôts
            double impotBase = surface * 2;
            double supplement = (pieces * 50) + (piscine ? 100 : 0);
            double total = impotBase + supplement;

            // Affichage des résultats
            resultBase.setText("Impôt de base : " + impotBase);
            resultSupplementaire.setText("impôt supplémentaire : " + supplement);
            resultTotal.setText("impôt Total : " + total);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erreur de saisie", Toast.LENGTH_SHORT).show();
        }
    }
}
