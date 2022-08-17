package com.vietko.mvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vietko.mvvm.data.model.User;
import com.vietko.mvvm.retrofit.ApiRequest;
import com.vietko.mvvm.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static final String TAG = UserRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public UserRepository(){
        apiRequest = RetrofitRequest.instance().create(ApiRequest.class);
    }
    
    public LiveData<User> getData(){
        final MutableLiveData<User> data = new MutableLiveData<>();
        apiRequest.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse response:: " + response);
                if (response.body() != null) {
                    data.setValue(response.body());
                    Log.d(TAG, "articles total result:: " + response.body());
                    Log.d(TAG, "size:: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
