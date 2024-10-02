package com.example.anapaula.quilombolaappv4.utils;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.anapaula.quilombolaappv4.GlobalApplication;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CheckRemoteServer extends AsyncTask<Void, Void, String>
{
    InputStream is = null;
    String json = "Fail";

    @Override
    protected String doInBackground(Void... params) {
        try {
            URL strUrl = new URL("http://app-quilombola.epizy.com/favicon.ico");
            //Here I have taken one android small icon from server, you can put your own icon on server and access your URL, otherwise icon may removed from another server.

            URLConnection connection = strUrl.openConnection();
            connection.setDoOutput(true);
            is =  connection.getInputStream();
            json = "Sucesso";

        } catch (Exception e) {
            e.printStackTrace();
            json = "Falha";
        }
        return json;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null)
        {
            if(result.equals("Falha")) // Internet Not Active
            {
                Toast.makeText(GlobalApplication.getAppContext(), "Servidor inacessível", Toast.LENGTH_LONG).show();
            }
            else // Internet Active + results
            {
                Toast.makeText(GlobalApplication.getAppContext(), result + " ao acessar o Servidor", Toast.LENGTH_LONG).show();
            }
        }
        else // Internet Not Active
        {
            Toast.makeText(GlobalApplication.getAppContext(), "Servidor inacessível", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPreExecute() { //Validating Internet
        Toast.makeText(GlobalApplication.getAppBaseContext(),"Acessando Internet",Toast.LENGTH_LONG).show();
        super.onPreExecute();
    }
}