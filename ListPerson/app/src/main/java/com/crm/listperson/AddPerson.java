package com.crm.listperson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
    }

    public void validate(View view)
    {
        View v = view;

        Intent ancienneIntention = getIntent();

        EditText name = (EditText) findViewById((R.id.editTextName));
        EditText surname = (EditText) findViewById((R.id.editTextSurname));

        ancienneIntention.putExtra("name", name.getText().toString());
        ancienneIntention.putExtra("surname",surname.getText().toString());

        setResult(Activity.RESULT_OK,ancienneIntention);

        this.finish();
    }
}