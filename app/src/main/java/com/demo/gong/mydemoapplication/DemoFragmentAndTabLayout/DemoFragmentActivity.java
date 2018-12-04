package com.demo.gong.mydemoapplication.DemoFragmentAndTabLayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DemoFragmentActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private String[] title = {"fragment1","fragment2","fragment3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life_cycle);

        init();
    }

    private void init() {
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(title[0]));
        tabLayout.addTab(tabLayout.newTab().setText(title[1]));
        tabLayout.addTab(tabLayout.newTab().setText(title[2]));

        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2ViewPagerInThis());
        fragmentList.add(new Fragment3());

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        //viewpager适配器
        MyViewPagerAdapter mViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), fragmentList, title);
        viewPager.setAdapter(mViewPagerAdapter);
        //tablayout与fragment关联
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragmentList;
        private String[] title;

        public MyViewPagerAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] title) {
            super(fm);
            this.fragmentList = fragmentList;
            this.title = title;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
