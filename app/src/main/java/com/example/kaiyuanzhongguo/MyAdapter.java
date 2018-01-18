package com.example.kaiyuanzhongguo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 石栋 on 2017/12/25.
 */

class MyAdapter extends PagerAdapter{
    private List<ImageView> listdata;

        public MyAdapter(List<ImageView> listdata) {
            this.listdata = listdata;
        }
    //返回滑动的页数
        @Override
        public int getCount() {
            return listdata.size();
        }
    //
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

    //填充每一页的内容
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(listdata.get(position));
            return listdata.get(position);
        }
    //销毁页卡
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
    //        super.destroyItem(container, position, object);
            container.removeView(listdata.get(position));
        }
}
