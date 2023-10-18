package com.crm.listperson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListPersonActivity extends AppCompatActivity {
    ListView listView;
    ListPerson _lp = new ListPerson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_person);

        listView = findViewById(R.id.listViewAllPerson);
        Person firstPerson = new Person("Duke", "Nukem");
        Person secondPerson = new Person("Cat", "Astrophe", this.getResources().getDrawableForDensity(R.drawable.cat, DisplayMetrics.DENSITY_XHIGH));
        Person thirdPerson = new Person("Nain", "Suportable");

        _lp.addPerson(firstPerson);
        _lp.addPerson(secondPerson);
        _lp.addPerson(thirdPerson);

        listView.setAdapter(new PersonArrayAdaptater(this, _lp));

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listview_person,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        // Get extra info about lise item that was long-pressed
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        // Perform action according to selected item from context menu

            if(item.getItemId() == R.id.copie)
            {
                Toast.makeText(getApplicationContext(), "copie: ID" + menuInfo.id + ", position" + menuInfo.position, Toast.LENGTH_SHORT).show();
                PersonArrayAdaptater paa = (PersonArrayAdaptater) listView.getAdapter();
                Person pACopier = paa.getItem(menuInfo.position);
                paa.add(pACopier);
                paa.notifyDataSetChanged();
                return true;
            }
            else if (item.getItemId() == R.id.delete)
            {
                Toast.makeText(getApplicationContext(), "Delete: ID" + menuInfo.id + ", position" + menuInfo.position, Toast.LENGTH_SHORT).show();
                PersonArrayAdaptater paa = (PersonArrayAdaptater) listView.getAdapter();
                Person pASupprimer = paa.getItem(menuInfo.position);
                paa.remove(pASupprimer);
                paa.notifyDataSetChanged();
                return true;
            }
            return false;
    }

    public void addNewPerson(View view)
    {
        Intent intent = new Intent(this, com.crm.listperson.AddPerson.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //if requestCode et resultCode

        String name = data.getStringExtra("name");
        String surname = data.getStringExtra("surname");

        Person newPerson = new Person(name,surname);

        _lp.addPerson(newPerson);
        listView.setAdapter(new PersonArrayAdaptater(this, _lp));
    }
}