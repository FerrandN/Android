package com.crm.listperson;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonArrayAdaptater extends ArrayAdapter<Person> {

    private ListPerson listPersons;
    public PersonArrayAdaptater(Context context, ListPerson persons)
    {
        super(context, R.layout.person, persons.getArrayListPerson());
        listPersons=persons;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View v = view;
        if(v == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.person, null);
        }

        Person personFromItem = (Person) listPersons.getPerson(i);
        if (personFromItem != null)
        {
            TextView surnameView = (TextView) v.findViewById(R.id.surname);
            TextView nameView = (TextView) v.findViewById(R.id.name);
            ImageView profilePic = (ImageView) v.findViewById(R.id.profileImage);

            if(surnameView != null)
            {
                surnameView.setText("Surname: " + personFromItem.getSurname());
            }
            if(nameView != null)
            {
                nameView.setText("Name: " + personFromItem.getName());
            }
            if(profilePic != null)
            {
                if(personFromItem.getPhoto() != null)
                {
                    profilePic.setImageDrawable(personFromItem.getPhoto());
                }
                else
                {
                    profilePic.setImageDrawable((v.getResources().getDrawableForDensity(R.drawable.absent, DisplayMetrics.DENSITY_XHIGH)));
                }
            }
        }
        return v;
    }

}
