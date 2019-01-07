package com.example.sunrin_08.myapplication12;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    @GET("files/{files}")
    Call<List<Item>> repoContributons(
        @Path("files") String files
    );

    public static final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://precs.ivyro.net/").addConverterFactory(GsonConverterFactory.create()).build();


}
