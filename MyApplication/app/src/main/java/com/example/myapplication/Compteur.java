package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Compteur extends AppCompatActivity {

    TextView t;

    public final String KEY_COMPTEUR = "MyNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_compteur_horizontal);

        }
        else {
            setContentView(R.layout.activity_compteur);
        }

        t = (TextView)findViewById(R.id.textViewcompteur);
        t.setText("0");

        if (savedInstanceState!=null){
            int v = savedInstanceState.getInt(KEY_COMPTEUR);
            t.setText(String.valueOf(v));
        }
    }


    public void decremente(View v)
    {
        int number = Integer.parseInt(t.getText().toString());
        number--;
        t.setText(String.valueOf(number));
    }
    public void incremente(View v)
    {
        int number = Integer.parseInt(t.getText().toString());
        number++;
        t.setText(String.valueOf(number));

    }

    public void quit(View v)
    {
        this.finish();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COMPTEUR,Integer.parseInt(t.getText().toString()));
    }
}