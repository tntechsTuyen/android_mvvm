package com.vietko.mvvm.retrofit;

import com.vietko.mvvm.data.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("test/user.json")
    Call<User> getUser();
}
