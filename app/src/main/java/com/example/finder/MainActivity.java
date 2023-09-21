package com.example.finder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText urLET = findViewById(R.id.urLET);

        final LinearLayout instaBtn = findViewById(R.id.instaBtn);
        final LinearLayout fbBtn = findViewById(R.id.fbBtn);
        final LinearLayout linkBtn = findViewById(R.id.linkBtn);
        final LinearLayout teleBtn = findViewById(R.id.teleBtn);
        final LinearLayout utubeBtn = findViewById(R.id.utubeBtn);
        final LinearLayout twitBtn = findViewById(R.id.twitBtn);

        urLET.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if (urLET.getImeActionId()== EditorInfo.IME_ACTION_SEARCH){
                    final String urlTxt = urLET.getText().toString();

                    if (!urlTxt.isEmpty()){

                        urLET.setText("");
                        Intent intent = new Intent(MainActivity.this, FinderView.class);
                        intent.putExtra("url",urlTxt);

                        startActivity(intent);
                    }
                }
                return false;
            }
        });

                instaBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this, FinderView.class);
                        intent.putExtra("url","www.instagram.com");

                        startActivity(intent);
                    }
                });

        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FinderView.class);
                intent.putExtra("url","www.facebook.com");

                startActivity(intent);
            }
        });

        linkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FinderView.class);
                intent.putExtra("url","www.linkedin.com");

                startActivity(intent);
            }
        });

        teleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FinderView.class);
                intent.putExtra("url","www.telegram.com");

                startActivity(intent);
            }
        });

        utubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FinderView.class);
                intent.putExtra("url","www.youtube.com");

                startActivity(intent);
            }
        });

        twitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, FinderView.class);
                intent.putExtra("url","www.twitter.com");

                startActivity(intent);

            }
        });
        
    }
}