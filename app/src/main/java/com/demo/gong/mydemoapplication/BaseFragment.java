package com.demo.gong.mydemoapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private View inflaterView;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (inflaterView == null) {
            inflaterView = inflater.inflate(R.layout.fragment_base, container, false);
        }

        //butterknife在Activity中不需要做解绑操作，在Fragment 中必须在onDestroyView()中做解绑操作。
        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
        unbinder = ButterKnife.bind(this, inflaterView);

        return inflaterView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //butterknife解绑
        unbinder.unbind();
    }
}
