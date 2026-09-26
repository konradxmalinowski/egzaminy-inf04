package com.example.mobilna;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.editTextNumber);
        nrPraniaTextView = findViewById(R.id.nrPrania);
        odkurzaczStatus1 = findViewById(R.id.odkurzaczStatus1);
        wlaczButton = findViewById(R.id.wlaczButton);
    }

    private EditText editText;
    private TextView nrPraniaTextView;
    private TextView odkurzaczStatus1;
    private Button wlaczButton;

    @SuppressLint("SetTextI18n")
    public void onClickZatwierdz(View view) {
        int numer = Integer.parseInt(editText.getText().toString());

        if (numer >= 1 && numer <= 12) {
            nrPraniaTextView.setText("Numer prania: " + numer);
        }
    }

    public void onClickWlacz(View view) {
        if (wlaczButton.getText().toString().equals("Włącz")) {
            odkurzaczStatus1.setText("Odkurzacz włączony");
            wlaczButton.setText("Wyłącz");
        } else {
            odkurzaczStatus1.setText("Odkurzacz wyłączony");
            wlaczButton.setText("Włącz");
        }

    }
}