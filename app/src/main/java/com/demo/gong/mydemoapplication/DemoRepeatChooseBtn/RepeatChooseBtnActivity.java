package com.demo.gong.mydemoapplication.DemoRepeatChooseBtn;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.demo.gong.mydemoapplication.BaseActivity;
import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class RepeatChooseBtnActivity extends BaseActivity {

    @BindView(R.id.linearLayout_product_type)
    LinearLayout linearLayoutProductType;

    private List<Search> products;
    private MultiSelectPopupWindows productsMultiSelectPopupWindows;

    @OnClick(R.id.linearLayout_product_type)
    public void onViewClick() {
        productsMultiSelectPopupWindows = new MultiSelectPopupWindows(this, linearLayoutProductType, 70, products);
        productsMultiSelectPopupWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                for (int i = 0; i < products.size(); i++) {
                    Log.i("RepeatChooseBtnActivity","products" + i + ":" + products.get(i).isChecked());
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_choose_btn);

        getData();
    }


    private void getData() {
        products = new ArrayList<>();
        products.add(new Search("日用百货", false, "0"));
        products.add(new Search("电子电器", false, "1"));
        products.add(new Search("服装鞋子", false, "2"));
        products.add(new Search("生鲜水果", false, "3"));
        products.add(new Search("食品零售", false, "4"));
        products.add(new Search("手工艺品", false, "5"));
        products.add(new Search("珠宝玉石", false, "6"));
    }
}
