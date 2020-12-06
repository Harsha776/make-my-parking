package com.example.myparkingtask.utlility;

import android.content.Context;

public class Utility {
    /*returns if screen has tablet screen configuation*/
    public static boolean isTablet(Context context) {
        boolean result = false;
        if (context.getResources().getConfiguration().smallestScreenWidthDp >= 600) {
            result = true;
        }
        return result;
    }
}
