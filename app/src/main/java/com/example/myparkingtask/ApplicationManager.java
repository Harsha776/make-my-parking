package com.example.myparkingtask;

import com.example.myparkingtask.dagger.AppComponent;
import com.example.myparkingtask.dagger.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class ApplicationManager extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()/*.application(this)*/.build();
//        appComponent.inject(this);
        return appComponent;
    }
}
