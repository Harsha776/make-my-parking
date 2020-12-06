package com.example.myparkingtask.home;

import android.app.Activity;

import com.example.myparkingtask.dagger.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainActivityModule {
    @Binds
    @ActivityScoped
    abstract Activity getActivity(MainActivity activity);

    @Binds
    @ActivityScoped
    abstract MainViewPresenter.View getView(MainActivity activity);

    @Binds
    @ActivityScoped
    abstract MainViewPresenter.Presenter getPresenter(
            Presenter presenter);
}
