package com.demo.gong.mydemoapplication.DemoNetActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;

public class TestNetWorkActivity extends BaseActivity {

    @BindView(R.id.btn_send_request)
    Button btnSendRequest;
    @BindView(R.id.tv_response)
    TextView tvResponse;
    @BindView(R.id.btn_webview)
    Button btnWebview;

    @OnClick({R.id.btn_send_request,R.id.btn_webview})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_request :
                sendRequestWithOkHttp();
                break;
            case R.id.btn_webview :
                startActivity(new Intent(this,TestWebViewActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_net_work);

    }

    private void sendRequestWithOkHttp() {
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.baidu.com")
                            .build();
                    Call call = client.newCall(request);
                    Response response = call.execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                    parseXMLWithPull(responseData);
//                    Log.i("TestNetWorkActivity", "TestNetWorkActivity.sendRequestWithOkHttp.showResponse:" + responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void parseXMLWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();

            String title = "";
            String description = "";
            String keywords = "";
            String generator = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT :
                        Log.i("TestNetWorkActivity","start_document");
                        break;
                    //开始解析某个节点
                    case XmlPullParser.START_TAG :
                        Log.i("TestNetWorkActivity","XmlPullParser.START_TAG");
                        if ("title".equals(name)) {
                            title = xmlPullParser.nextText();
                            Log.i("\nTestNetWorkActivity","title:"+title);
                        }else if ("description".equals(name)) {
                            description = xmlPullParser.nextText();
                            Log.i("\nTestNetWorkActivity","description:"+description);
                        }else if ("keywords".equals(name)) {
                            keywords = xmlPullParser.nextText();
                            Log.i("\nTestNetWorkActivity","keywords:"+keywords);
                        }else if ("generator".equals(name)) {
                            generator = xmlPullParser.nextText();
                            Log.i("\nTestNetWorkActivity","generator:"+generator);
                        }
                        break;
                    case XmlPullParser.END_TAG :
                        Log.i("\nTestNetWorkActivity","end_tag");
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
