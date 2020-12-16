package com.pramod.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SilderAdapter silderAdapter;
    private ArrayList<CarsModel> carsModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.test);


        photo();


    }


    public void photo(){
        Call<List<CarsModel>> call = RetrofitClient.getInstance().getApi().getPhoto();

        call.enqueue(new Callback<List<CarsModel>>() {

            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {

                carsModels= new ArrayList<CarsModel>(response.body());
                silderAdapter=new SilderAdapter(carsModels, MainActivity.this);
                viewPager.setAdapter(silderAdapter);

            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();

            }
        });
    }
}