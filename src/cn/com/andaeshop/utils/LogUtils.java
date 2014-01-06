package cn.com.andaeshop.utils;

import android.util.Log;

public class LogUtils {
    private static final String TAG = "Herny";

    public static void LogD(String classAndfuntionString, String logString) {
        Log.d(TAG, classAndfuntionString + " logString=" + logString);
    }

    public static void LogE(String classAndfuntionString, String logString) {
        Log.e(TAG, classAndfuntionString + " logString=" + logString);
    }
}
