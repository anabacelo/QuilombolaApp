package com.example.anapaula.quilombolaappv4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePage extends Fragment implements IOnBackPressed{

    private WebView mWebView;

    public HomePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page_web, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewHomePage);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new WebViewClientOverride());

        // Load remote site
        //mWebView.loadUrl("http://app-quilombola.epizy.com/noticias.html");
        //mWebView.loadUrl("http://www.html5rocks.com/");
        mWebView.loadUrl("file:///android_asset/www/home.html");
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
