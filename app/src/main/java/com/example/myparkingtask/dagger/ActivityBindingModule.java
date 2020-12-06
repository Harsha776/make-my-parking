package com.example.myparkingtask.dagger;

import com.example.myparkingtask.home.MainActivity;
import com.example.myparkingtask.home.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity provideSplashActivity();
}
