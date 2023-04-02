package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.retrofitdemo.Model.Posts.PostsData;
import com.example.retrofitdemo.Model.Users.Address;
import com.example.retrofitdemo.Model.Users.Company;
import com.example.retrofitdemo.Model.Users.Geo;
import com.example.retrofitdemo.Model.Users.UsersData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String api = "https://jsonplaceholder.typicode.com";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt);
        RetrofitApicalling();
    }

    private void RetrofitApicalling() {

        RetroAPI_Class.MyAPICalling().postsListResponse().enqueue(new Callback<List<PostsData>>() {
            @Override
            public void onResponse(Call<List<PostsData>> call, Response<List<PostsData>> response)
            {
                // get log to check response is comming or not?
                Log.d("aaa", "onResponse: "+response.body());
                // make or build a retrofit object
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                // create an object of interface (implementation of methods to get request to end points)
                MyInterface myInterface=retrofit.create(MyInterface.class);
                //An invocation of a Retrofit method that sends a request to a webserver and returns a response.
                List<PostsData> list=response.body();
                for (int i=0;i<list.size();i++)
                {
                    Log.d("bbb", "onResponse: "+list.get(i).getBody());
                    Log.d("aaa", "onResponse: "+list.get(i).getTitle());
                    textView.append("\n "+list.get(i).getTitle());
                }

            }

            @Override
            public void onFailure(Call<List<PostsData>> call, Throwable t) {

            }
        });

        RetroAPI_Class.MyAPICalling().usersListReponse().enqueue(new Callback<List<UsersData>>() {
            @Override
            public void onResponse(Call<List<UsersData>> call, Response<List<UsersData>> response) {
                Integer id;
                String name;
                String username;
                String email;
                Address address;
                String phone;
                String website;
                Company company;
                Geo geo;
                // get log to check response is comming or not?
                Log.d("aaa", "onResponse: "+response.body());
                // make or build a retrofit object
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                // create an object of interface (implementation of methods to get request to end points)
                MyInterface myInterface=retrofit.create(MyInterface.class);
                //An invocation of a Retrofit method that sends a request to a webserver and returns a response.
                List<UsersData> list = response.body();
                for (int i=0;i<list.size();i++)
                {
                    Log.d("bbb", "onResponse: "+list.get(i).getEmail());
                    Log.d("aaa", "onResponse: "+list.get(i).getAddress());
                    textView.append(""+list.get(i).getCompany().getName());
                }

            }

            @Override
            public void onFailure(Call<List<UsersData>> call, Throwable t) {

            }
        });

    }
}

/*

 @Override
            public void onResponse(Call<List<PostsData>> call, Response<List<PostsData>> response)
            {
                // get log to check response is comming or not?
                Log.d("aaa", "onResponse: "+response.body());
                // make or build a retrofit object
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(api)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                // create an object of interface (implementation of methods to get request to end points)
                MyInterface myInterface=retrofit.create(MyInterface.class);
                //An invocation of a Retrofit method that sends a request to a webserver and returns a response.
                Call<List<PostsData>> listCall=myInterface.postsListResponse();

                listCall.enqueue(new Callback<List<PostsData>>() {
             }
        RetroAPI_Class.MyAPICalling().usersListReponse().enqueue(new Callback<List<UsersData>>() {
            Integer id;
            String name;
            String username;
            String email;
            Address address;
            String phone;
            String website;
            Company company;
            Geo geo;

            @Override
            public void onResponse(Call<List<UsersData>> call, Response<List<UsersData>> response) {
                List<UsersData> list = response.body();
                for (int i=0;i<list.size();i++)
                {
                    Log.d("aaa", "onResponse: "+list.get(i).getEmail());
                    Log.d("aaa", "onResponse: "+list.get(i).getAddress().getGeo().getLat());

                }

            }

            @Override
            public void onFailure(Call<List<UsersData>> call, Throwable t) {

            }
        });
    }
 */