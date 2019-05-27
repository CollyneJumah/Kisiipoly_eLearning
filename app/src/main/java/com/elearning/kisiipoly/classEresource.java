package com.elearning.kisii_national_polytechnic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class classEresource extends Fragment {
    private WebView mWebView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_portal, container, false);

        Toast.makeText(getContext(), "Welcome to Kisiipoly Online learning Resources", Toast.LENGTH_LONG).show();
        View v = inflater.inflate(R.layout.fragment_eresource, container, false);
        mWebView = (WebView) v.findViewById(R.id.webViewEresource);
        mWebView.loadUrl("http://kisiipoly.ac.ke/eResources");
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
        return v;
    }
}
