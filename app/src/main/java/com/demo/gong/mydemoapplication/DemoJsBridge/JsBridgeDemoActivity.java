package com.demo.gong.mydemoapplication.DemoJsBridge;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;

import butterknife.BindView;

public class JsBridgeDemoActivity extends BaseActivity {

    @BindView(R.id.et_jsbridge)
    EditText et;
    @BindView(R.id.btn_jsbridge)
    Button btn;
    @BindView(R.id.bridge_webview)
    BridgeWebView webview;

    private final String TAG = "JsBridgeDemoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_bridge_demo);

        webview.setDefaultHandler(new DefaultHandler());
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl("file:///android_asset/test.html");
        //注册监听方法当js中调用callHandler方法时会调用此方法（handlerName必须和js中相同）
        webview.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG,"js返回 : "+data);
                //显示js传递给Android的消息
                Toast.makeText(JsBridgeDemoActivity.this, "js返回:" + data, Toast.LENGTH_LONG).show();
                //Android返回给JS的消息
                function.onCallBack("我是js调用Android返回数据：" + et.getText().toString());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用js中的方法(必须和js中的handlerName相同)
                webview.callHandler("functionInJs", "Android调用js66", new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        Log.i(TAG,"onCallBack : "+data);
                        Toast.makeText(JsBridgeDemoActivity.this, data, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
