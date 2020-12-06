package com.example.myparkingtask.home;

import com.example.myparkingtask.model.Items;

import java.util.ArrayList;

public class MainViewPresenter {
    interface View{

        /**
         * show progressbar
         */
        void showProgess();

        /**
         * hide progressBar
         */
        void hideProgess();

        void setData(ArrayList<Items> items);
    }
    interface Presenter{
        void getList(String search);
    }
}
