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
        for (int i=0; i<help.size(); i++){
            contacts.add(help.get(i));
            Log.d("AiutamiHelp: ", help.get(i));
        }
        /*
        for (String s : help) {
            contacts.add(s);
            Log.d("contactsContacts: ", s);
        }*/
        for (int i=0; i<contacts.size(); i++){
            Log.d("AiutamiContacts: ", contacts.get(i));
        }
        Log.d("contactsSize: ", contacts.size() + "");
        /*
        contacts.add(uid + " " + experience);
        Log.d("contacts: ", contacts.toString());*/
    }

    public int getContactsCount() {
        Log.d("contactsSize: ", String.valueOf(contacts.size()));
        return contacts.size();
    }

    public String getContact(int index) {
        return contacts.get(index);
    }
}
