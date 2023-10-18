package com.crm.listperson;

import java.util.ArrayList;
import java.util.List;

public class ListPerson {
    private ArrayList<Person> persons;

    ListPerson()
    {
        persons = new ArrayList<Person>();
    }

    ListPerson(ArrayList<Person> arrayPersons)
    {
        this.persons = arrayPersons;
    }

    public ArrayList<Person> getArrayListPerson()
    {
        return persons;
    }

    public void addPerson(Person person)
    {
        persons.add(person);
    }

    public void deletePerson(Person person)
    {
        persons.remove(person);
    }

    public Person getPerson(int i)
    {
        return persons.get(i);
    }
}
