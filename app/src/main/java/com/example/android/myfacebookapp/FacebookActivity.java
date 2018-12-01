package com.example.android.myfacebookapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        OkHttpClient client = new OkHttpClient();
        String url = "https://www.google.com";
        final TextView textview = findViewById(R.id.textview);

        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse = response.body().string();
                FacebookActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textview.setText(myResponse);
                    }
                });
            }
        });
    }
}
