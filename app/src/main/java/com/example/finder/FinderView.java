package com.example.finder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FinderView extends AppCompatActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finder_view);

        final WebView webView = findViewById(R.id.webView);
        final EditText urlET = findViewById(R.id.urlET);
        final ImageView homeBtn = findViewById(R.id.homeIcon);

        url=getIntent().getStringExtra("url");

        final String urlData = url.substring(0,4);

        if (!urlData.contains("www.")){
            url = "www.google.com/search?q="+url;
        }
        urlET.setText(url);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view,url,favicon);
                urlET.setText(url);
            }

            @Override
            public void onPageFinished(WebView view,String url){
                super.onPageFinished(view,url);
            }
        });

        urlET.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if (urlET.getImeActionId()== EditorInfo.IME_ACTION_SEARCH){
                    final String urlTxt = urlET.getText().toString();

                    if (!urlTxt.isEmpty()){
                        final String urlData = urlTxt.substring(0,2);

                        if (!urlData.contains("www.")){
                            url = "www.google.com/search?q="+url;
                        }
                        else {
                            url = urlTxt;
                        }

                    }
                }
                return false;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}