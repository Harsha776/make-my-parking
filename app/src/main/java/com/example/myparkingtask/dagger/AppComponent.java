package com.example.myparkingtask.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ActivityBindingModule.class,AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    /*void inject(ApplicationManager application);*/

    @Override
    void inject(DaggerApplication instance);

    /*@Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }*/
}
