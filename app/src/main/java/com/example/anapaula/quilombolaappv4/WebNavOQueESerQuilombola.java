package com.example.anapaula.quilombolaappv4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebNavOQueESerQuilombola extends Fragment implements IOnBackPressed
{
    private WebView minhaWebNav;

    public WebNavOQueESerQuilombola() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        CreateWebView minhaWebNavOQueESerQuilombola = new CreateWebView();
        View minhaWebNav = minhaWebNavOQueESerQuilombola.CreateWebView(inflater, container, R.layout.fragment_webnavoqueeserquilombola, R.id.WebNavOQueESerQuilombolaId, "file:///android_asset/www/webNavOQueESerQuilombola.html");

        return minhaWebNav;
    }

    @Override
    public boolean onBackPressed()
    {
        if (minhaWebNav.canGoBack())
        {
            minhaWebNav.goBack();
            //action not popBackStack
            return true;
        } else {
            return false;
        }
    }
}