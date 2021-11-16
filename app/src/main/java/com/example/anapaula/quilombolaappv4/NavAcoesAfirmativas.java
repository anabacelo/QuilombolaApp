package com.example.anapaula.quilombolaappv4;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
/**
 * A simple {@link Fragment} subclass.
 */
public class NavAcoesAfirmativas extends Fragment implements IOnBackPressed{
    private WebView mWebView;
    public NavAcoesAfirmativas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web, container, false);

        mWebView = (WebView) view.findViewById(R.id.webViewMain);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Stop local links and redirects from opening in browser instead of WebView
        mWebView.setWebViewClient(new WebViewClientOverride());

        if(CheckInternetConnection.simpleServerCheck()){
            mWebView.loadUrl("http://app-quilombola.epizy.com/acoesafirmativas.html");
        }
        else {
            mWebView.loadUrl("file:///android_asset/www/acoesafirmativas.html");
        }
        //return inflater.inflate(R.layout.fragment_nav1, container, false);
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
