package com.example.anapaula.quilombolaappv4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CheckInternetConnection {
    public static void checkInternetAvailibility()
    {
        if(isInternetAvailable())
        {
            new CheckRemoteServer().execute();
        }
        else { // Internet Not Connected
            Toast.makeText(GlobalApplication.getAppContext(), "Internet não conectada", Toast.LENGTH_LONG).show();
        }
    }

    public static boolean isInternetAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) GlobalApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            Log.e("isInternetAvailable:",e.toString());
            return false;
        }
    }

    public static boolean simpleServerCheck(){
        return false;
//        try {
//            ConnectivityManager connectivityManager = (ConnectivityManager) GlobalApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//            if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
//                try {
//                    URL strUrl = new URL("http://app-quilombola.epizy.com/favicon.ico");
//                    URLConnection connection = strUrl.openConnection();
//                    connection.setDoOutput(true);
//                    return true;
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                    return false;
//                }
//            }
//            return false;
//        } catch (Exception e) {
//            Log.e("isInternetAvailable:",e.toString());
//            return false;
//        }
    }
}
