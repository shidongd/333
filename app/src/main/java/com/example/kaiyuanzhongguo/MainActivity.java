package com.example.kaiyuanzhongguo;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kaiyuanzhongguo.ui.Activity.Main2Activity;

import java.util.ArrayList;

import static android.R.interpolator.linear;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private int[] resimg = {R.mipmap.a, R.mipmap.b, R.mipmap.c,R.mipmap.d};
    private ArrayList<ImageView> listdata;
    private LinearLayout linear;
    private ArrayList<ImageView> dotlist;
    private Button enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
        initListener();
    }

    private void initListener() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < 4; i++) {
                    if ((position % 4) == i) {
                        ((View) dotlist.get(i)).setBackgroundResource(R.drawable.shapeselect);
                    } else {
                        ((View) dotlist.get(i)).setBackgroundResource(R.drawable.shapenormal);

                    }
                }
                if (position == listdata.size() - 1) {
                    linear.setVisibility(View.INVISIBLE);
                    enterBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void initAdapter() {
        MyAdapter myAdapter = new MyAdapter(listdata);
        vp.setAdapter(myAdapter);
        vp.setCurrentItem(0);
    }

    private void initData() {
        listdata = new ArrayList<ImageView>();

        for (int i = 0; i < resimg.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resimg[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            listdata.add(imageView);
        }


        //        圆点的数据
        dotlist = new ArrayList<ImageView>();
        for (int j = 0; j < resimg.length; j++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            layoutParams.height = 18;
            layoutParams.width = 18;
            if (j == 0) {
                imageView.setBackgroundResource(R.drawable.shapeselect);
            } else {
                imageView.setBackgroundResource(R.drawable.shapenormal);
            }
            linear.addView(imageView, layoutParams);
            dotlist.add(imageView);

        }
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        linear = (LinearLayout) findViewById(R.id.linear);
        enterBtn = (Button) findViewById(R.id.btn_enter);

    }


}

