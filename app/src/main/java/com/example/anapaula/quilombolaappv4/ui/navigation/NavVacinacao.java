package com.example.anapaula.quilombolaappv4.ui.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.anapaula.quilombolaappv4.R;
import com.example.anapaula.quilombolaappv4.utils.IOnBackPressed;
import com.example.anapaula.quilombolaappv4.utils.WebViewClientOverride;

public class NavVacinacao extends Fragment implements IOnBackPressed {

    private WebView mWebView;
    public NavVacinacao() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewMain);

        WebSettings webSettings = mWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);

        // Força o ajuste do conteudo a largura da tela
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        mWebView.setWebViewClient(new WebViewClientOverride());

        mWebView.loadUrl("file:///android_asset/www/vacinacaoquilombola.html");

        return view;
    }
    @Override
    public boolean onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            return false;
        }
    }
}
