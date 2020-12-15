package com.pramod.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private ArrayList<CarsModel>carsModels;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView = findViewById(R.id.text);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




        photo();
    }



    public void photo(){
        Call<List<CarsModel>> call = RetrofitClient.getInstance().getApi().getPhoto();

        call.enqueue(new Callback<List<CarsModel>>() {

            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {

                carsModels= new ArrayList<CarsModel>(response.body());
                imageAdapter=new ImageAdapter(carsModels, MainActivity.this);
                recyclerView.setAdapter(imageAdapter);

            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();

            }
        });
    }
}