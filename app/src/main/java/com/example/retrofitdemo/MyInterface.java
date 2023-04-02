package com.example.retrofitdemo;

import com.example.retrofitdemo.Model.Posts.PostsData;
import com.example.retrofitdemo.Model.Users.UsersData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyInterface
{
    @GET("users/")
    Call<List<UsersData>> usersListReponse();

    @GET("posts/")
    Call<List<PostsData>> postsListResponse();
}
