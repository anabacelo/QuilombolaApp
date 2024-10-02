package com.example.anapaula.quilombolaappv4.utils;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;

public class WebViewClientOverride extends WebViewClient {

@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    Uri uri = request.getUrl();

    if (uri.toString().startsWith("file:///android_asset/")) {
        view.loadUrl(uri.toString());
        return true;
    }

    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    view.getContext().startActivity(intent);
    return true;
}

@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.startsWith("file:///android_asset/")) {
        view.loadUrl(url);
        return true;
    }
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    view.getContext().startActivity(intent);
    return true;
}
}