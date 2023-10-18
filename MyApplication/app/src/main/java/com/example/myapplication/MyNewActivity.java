package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyNewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_new);
    }


    @Override
    protected void onStart()
    {
        super.onStart();
    }

    public void sayHello(View v)
    {
        Toast.makeText(this, "Bonjour", Toast.LENGTH_LONG).show();
    }
}