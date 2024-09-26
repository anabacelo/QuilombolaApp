package com.example.anapaula.quilombolaappv4;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;

public class WebViewClientOverride extends WebViewClient {

@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
    Uri uri = request.getUrl();

    // Check if the URL is from your local assets folder
    if (uri.toString().startsWith("file:///android_asset/")) {
        // Handle the local file link in the WebView itself
        view.loadUrl(uri.toString());
        return true; // Indicates WebView should handle it
    }

    // For any other links, use external browser
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    view.getContext().startActivity(intent);
    return true;
}

// Deprecated method for older Android versions
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