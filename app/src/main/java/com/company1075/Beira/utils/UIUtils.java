package com.company1075.Beira.utils;

import android.content.Context;
import android.widget.Toast;

import com.company1075.Beira.app.BeiraApplication;

public class UIUtils {
    private static Toast mToast;

    public static Context getContext() {
        return BeiraApplication.getContext();
    }

    public static Toast showTip(String str) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), str, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(str);
        }
        mToast.show();
        return mToast;
    }
}
