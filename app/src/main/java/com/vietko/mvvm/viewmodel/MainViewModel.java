package com.vietko.mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vietko.mvvm.data.model.User;
import com.vietko.mvvm.repository.UserRepository;

public class MainViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<User> userRepositoryLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.userRepository = new UserRepository();
        this.userRepositoryLiveData = this.userRepository.getData();
    }

    public LiveData<User> getUserRepositoryLiveData(){
        return this.userRepositoryLiveData;
    }
}
