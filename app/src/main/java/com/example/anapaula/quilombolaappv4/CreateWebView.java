package com.example.anapaula.quilombolaappv4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class CreateWebView
{
    public CreateWebView()
    {
        //
    }

    public CreateWebView(LayoutInflater inflater, ViewGroup container, Integer fragmento, Integer idItemLayout, String address)
    {
//
    }

    public View CreateWebView(LayoutInflater inflater, ViewGroup container, Integer fragmento, Integer idItemLayout, String address)
    {
        View view = inflater.inflate(fragmento, container, false);

        WebView mWebView = (WebView) view.findViewById(idItemLayout);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClientOverride());


        // Load remote site
        //mWebView.loadUrl("http://app-quilombola.epizy.com/noticias.html");
        //mWebView.loadUrl("http://www.html5rocks.com/");
        mWebView.loadUrl(address);

        return view;
    }

}