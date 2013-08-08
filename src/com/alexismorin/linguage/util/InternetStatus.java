package com.alexismorin.linguage.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;                                                                                                         

public class InternetStatus {
    private static InternetStatus instance = new InternetStatus();
    static Context context;
    ConnectivityManager connectivityManger;
    NetworkInfo wifiInfo, mobileInfo;
    boolean connected = false;
    
    public static InternetStatus getInstance(Context ctx){
        context = ctx;
        return instance;
    }
    
    public boolean isOnline(Context con){
        try {
            connectivityManger = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManger.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            //Log.v("Connectivity", "has internet.");
            return connected;
        } catch (Exception e) {
            //Log.v("Connectivity", e.toString());
        }
        
        return connected;
    }
}
