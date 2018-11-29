package com.demo.gong.mydemoapplication.DemoNetActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestNetWorkActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSendRequest;
    private TextView tvResponse;
    private Button btnWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_net_work);

        btnSendRequest = (Button) findViewById(R.id.btn_send_request);
        tvResponse = (TextView) findViewById(R.id.tv_response);
        btnWebview = (Button)findViewById(R.id.btn_webview);

        btnSendRequest.setOnClickListener(this);
        btnWebview.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_send_request :
                sendRequestWithOkHttp();
                break;
            case R.id.btn_webview :
                startActivity(new Intent(this,TestWebViewActivity.class));
                break;
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.99vv2.com")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                    Log.i("TestNetWorkActivity", "TestNetWorkActivity.sendRequestWithOkHttp.showResponse:" + responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://www.99vv2.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream is = connection.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(is));
                    StringBuffer sb = new StringBuffer();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    showResponse(sb.toString());
                    Log.i("TestNetWorkActivity", "TestNetWorkActivity.sendRequestWithHttpURLConnection.showResponse:" + sb.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }

                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResponse.setText(response);
            }
        });
    }
}
