package com.demo.gong.mydemoapplication.DemoFragmentAndTabLayout;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.gong.mydemoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment1","onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("Fragment1","onCreateView()");
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Fragment1","onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment1","onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Fragment1","onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment1","onPause()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("Fragment1","onSaveInstanceState()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Fragment1","onDetach()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Fragment1","onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Fragment1","onDestroyView()");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("Fragment1","onAttach()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment1","onDestroy()");
    }
}
