package com.example.anapaula.quilombolaappv4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavNoticias extends Fragment implements IOnBackPressed{

    private WebView mWebView;

    public NavNoticias() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navnoticias, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewNoticias);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new WebViewClientOverride());

        // Load remote site
        mWebView.loadUrl("http://app-quilombola.epizy.com/noticias.html");
        //mWebView.loadUrl("http://www.html5rocks.com/");
        //mWebView.loadUrl("file:///android_asset/www/noticias.html");
        return view;
    }

    @Override
    public boolean onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            //action not popBackStack
            return true;
        } else {
            return false;
        }
    }

}
