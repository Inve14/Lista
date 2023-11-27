package com.example.listexample;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<String> contacts;
    //bisogna creare una lista di Player con caratteristiche "nome_player" e "punteggio_player" --> bisogna creare la classe Player

    public Model() {
        contacts = new ArrayList<>();
    }

    public void simulateLoadData(List<String> help) {
        /*
        for (String s : help) {
            contacts.add(s);
            Log.d("contactsContacts: ", s);
        }*/
        for (int i=0; i<100; i++) {
            contacts.add("contatto " + i);
        }
        Log.d("contacts: ", contacts.toString());
        /*
        contacts.add(uid + " " + experience);
        Log.d("contacts: ", contacts.toString());*/
    }

    public int getContactsCount() {
        return contacts.size();
    }

    public String getContact(int index) {
        return contacts.get(index);
    }
}
