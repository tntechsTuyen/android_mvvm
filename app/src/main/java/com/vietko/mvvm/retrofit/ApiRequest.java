package com.vietko.mvvm.retrofit;

import android.database.Observable;

import com.vietko.mvvm.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("test/user.json")
    Call<List<User>> getUser();
}
