package com.example.professor.intentsnativas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TADSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tads);

        TextView texto = findViewById(R.id.txtTexto);
        TextView txtScheme = findViewById(R.id.txtScheme);
        TextView txtHost = findViewById(R.id.txtHost);
        TextView txtPath = findViewById(R.id.txtPath);

        Intent intent = getIntent();

        if (intent.getAction().equals(Intent.ACTION_VIEW)){
            Uri uri = intent.getData();

            texto.setText("Intent: " + uri.toString());
            txtScheme.setText("Scheme: " + uri.getScheme());
            txtHost.setText("Host: " + uri.getHost());
            txtPath.setText("Path: " + uri.getPath());

        }
    }
}
