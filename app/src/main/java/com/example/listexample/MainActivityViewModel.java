package com.example.listexample;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private Model theModel;
    User user;
    List<String> help = new ArrayList<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        theModel = new Model();
    }

    public void setHelp(List<String> help) {
        this.help = help;
        theModel.simulateLoadData(help);
    }


    public int getContactsCount() {
        Log.d("ModelSize: ", theModel.getContactsCount()+ "");
        return theModel.getContactsCount();
    }

    public String getContact(int index) {
        return theModel.getContact(index);
    }
}
