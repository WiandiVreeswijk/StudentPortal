package com.example.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebviewActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mWebView = findViewById(R.id.webView);
        Portal portal = getIntent().getParcelableExtra(MainActivity.VIEW_PORTAL);
        mWebView.loadUrl(portal.getUrl());
    }
}
