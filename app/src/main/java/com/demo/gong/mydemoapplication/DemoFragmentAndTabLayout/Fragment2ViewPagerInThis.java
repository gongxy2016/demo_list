package com.demo.gong.mydemoapplication.DemoFragmentAndTabLayout;


import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.gong.mydemoapplication.BaseFragment;
import com.demo.gong.mydemoapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2ViewPagerInThis extends BaseFragment {

    @BindView(R.id.vp_fragment2)
    ViewPager vp;
    @BindView(R.id.tv_fragment2)
    TextView tv;

    private Context context;
    private View inflateView;
    private List<Integer> imageIds;
//    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//            inflateView = inflater.inflate(R.layout.fragment_fragment2, container, false);

        inflateView = setInflaterView(inflater,container,R.layout.fragment_fragment2);

        //butterknife在Activity中不需要做解绑操作，在Fragment 中必须在onDestroyView()中做解绑操作。
        //返回一个Unbinder值（进行解绑），注意这里的this不能使用getActivity()
//        unbinder = ButterKnife.bind(this, inflateView);

        initView();
        addData();
        return inflateView;
    }

    private void addData() {
        imageIds = new ArrayList<>();
        imageIds.add(R.mipmap.ic_launcher);
        imageIds.add(R.mipmap.ic_launcher_round);
        imageIds.add(R.mipmap.image0);

        vp.setAdapter(new Fragment2ViewPagerAdapter(new OnFragmet2VPChangeListener() {
/*            @Override
            public void onItemChangeShowTextListener(int position) {
                tv.setText(position+"");
            }*/

            @Override
            public void onItemClickListener(int position) {

                if (tv.getVisibility() == View.VISIBLE){
                    tv.setVisibility(View.INVISIBLE);
                }else {
                    tv.setVisibility(View.VISIBLE);
                }
            }
        }));

        vp.setCurrentItem(0);

    }

    private void initView() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv.setText(position+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class Fragment2ViewPagerAdapter extends PagerAdapter {

        private OnFragmet2VPChangeListener onFragmet2VPChangeListener;

        public Fragment2ViewPagerAdapter(OnFragmet2VPChangeListener onFragmet2VPChangeListener) {
            this.onFragmet2VPChangeListener = onFragmet2VPChangeListener;
        }

        @Override
        public int getCount() {
            return imageIds.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView imageView = new ImageView(context);
            Glide.with(context).load(imageIds.get(position)).fitCenter().diskCacheStrategy(DiskCacheStrategy.RESULT).into(imageView);

            container.addView(imageView);

//            onFragmet2VPChangeListener.onItemChangeShowTextListener(position);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFragmet2VPChangeListener.onItemClickListener(position);
                }
            });

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //butterknife解绑
//        unbinder.unbind();
    }
}
