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

        ApiInterface apiInterface = RetrofitClient.getRetrofitIstance().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getUserInformation("l5p8XVRmz6ApeTVeeUwK");


        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> risposta = response.body();
                    for (User user : risposta) {
                        //theModel.simulateLoadData(user.getUid(), user.getExperience());
                        help.add(user.getUid() + " " + user.getExperience());
                        Log.d("MainActivity", "onResponse: " + help.toString() + " " + user.getUid() + " " + user.getExperience());
                    }
                }
                Log.d("contactsHelp: ", help.toString());
                theModel.simulateLoadData(help);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }

    public int getContactsCount() {
        Log.d("ModelSize: ", theModel.getContactsCount()+ "");
        return theModel.getContactsCount();
    }

    public String getContact(int index) {
        return theModel.getContact(index);
    }
}
