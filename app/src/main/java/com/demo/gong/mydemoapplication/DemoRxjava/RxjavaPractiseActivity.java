package com.demo.gong.mydemoapplication.DemoRxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;

public class RxjavaPractiseActivity extends BaseActivity {

    private final String TAG = "RxjavaPractiseActivity";
    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btn1)
    Button btn1;

    private Observable<Button> observable;
    private Observer<Button> observer;

    @OnClick({R.id.btn0,R.id.btn1})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn0 :
                observable.subscribe(observer);
                break;
            case R.id.btn1 :

                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_practise);

        final List<Button> btns = new ArrayList<>();
        btns.add(btn0);
        btns.add(btn1);

        observable = Observable.fromArray(btns).create(new ObservableOnSubscribe<Button>() {

            @Override
            public void subscribe(ObservableEmitter<Button> emitter) throws Exception {

                emitter.onNext(btn0);
                emitter.onNext(btn1);

                emitter.onComplete();
            }
        });




        observer = new Observer<Button>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Button button) {
                switch (button.getId()) {
                    case R.id.btn0 :
                        Toast.makeText(RxjavaPractiseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn1 :
                        Toast.makeText(RxjavaPractiseActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);

    }
}
