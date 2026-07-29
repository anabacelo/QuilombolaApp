package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.utils.CheckInternetConnection;
import com.example.anapaula.quilombolaappv4.utils.IOnBackPressed;
import com.example.anapaula.quilombolaappv4.utils.WebViewClientOverride;

public class NavUnidadesSaudeOdontologia extends Fragment implements IOnBackPressed {

    private WebView mWebView;

    public NavUnidadesSaudeOdontologia() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web, container, false);

        mWebView = view.findViewById(R.id.webViewMain);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClientOverride());

        if (CheckInternetConnection.simpleServerCheck()) {
            mWebView.loadUrl("http://app-quilombola.epizy.com/unidadessaudeodontologia.html");
        } else {
            mWebView.loadUrl("file:///android_asset/www/unidadessaudeodontologia.html");
        }

        return view;
    }

    @Override
    public boolean onBackPressed() {

        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }

        return false;
    }
}
