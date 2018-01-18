package com.example.kaiyuanzhongguo.ui.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kaiyuanzhongguo.R;
import com.example.kaiyuanzhongguo.ui.Fragment.AFragment;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private ArrayList<Fragment> list;
    private TabLayout tl;
    private ArrayList<String> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(AFragment.newInstance(0));
        list.add(AFragment.newInstance(1));
        list.add(AFragment.newInstance(2));
        list.add(AFragment.newInstance(3));
        list.add(AFragment.newInstance(4));

        MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
        mAdapter.setFragments(list);
        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(mAdapter.getCount());
        vp.setAdapter(mAdapter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("头条");
        tl.getTabAt(1).setText("校园");
        tl.getTabAt(2).setText("就业");
        tl.getTabAt(3).setText("活动");

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tl = (TabLayout) findViewById(R.id.tl);
    }

    private class MyAdapter extends FragmentPagerAdapter {

         List<Fragment> mFragments;

        public void setFragments(List<Fragment> list) {


            if(list ==null){

                mFragments = new ArrayList<>();
            }
            else
                mFragments = list;
        }


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

    }
}
