package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    List<String> help = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = RetrofitClient.getRetrofitIstance().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getUserInformation("l5p8XVRmz6ApeTVeeUwK");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> risposta = response.body();
                    for (User user : risposta) {
                        help.add(user.getUid() + " " + user.getExperience());
                        Log.d("MainActivity", "onResponse: " + help.toString() + " " + user.getUid() + " " + user.getExperience());
                    }

                    // Dopo che la chiamata API è completata, crea il ViewModel e imposta la lista di aiuto
                    viewModel = new ViewModelProvider(MainActivity.this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MainActivityViewModel.class);
                    viewModel.setHelp(help);

                    ContactsAdapter adapter = new ContactsAdapter(MainActivity.this, viewModel, i -> {
                        Log.d("CapiamoMeglio", "(Activity) Hai cliccato sull'elemento con posizione: " + i);
                    });

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }

}
