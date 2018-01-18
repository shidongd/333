package com.example.kaiyuanzhongguo.ui.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaiyuanzhongguo.R;
import com.recker.flybanner.FlyBanner;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private static final String IMG_ID ="IMG_ID";


    private SmartRefreshLayout srl;
    private FlyBanner banner;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, container, false);
        initView(inflate);
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                srl.finishRefresh(2000);
            }
        });
        srl.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                srl.finishLoadmore(2000);
            }
        });
        initData();
        return inflate;
    }

    private void initData() {
        List<Integer> images = new ArrayList<>();
        images.add(R.mipmap.a);
        images.add(R.mipmap.b);
        images.add(R.mipmap.c);
        images.add(R.mipmap.d);
        banner.setImages(images);



    }


    public static AFragment newInstance(int i) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IMG_ID, i);
        fragment.setArguments(bundle);
        return fragment;
    }


    private void initView(View inflate) {
        srl = (SmartRefreshLayout) inflate.findViewById(R.id.srl);
        banner = (FlyBanner) inflate.findViewById(R.id.banner);
        rv = (RecyclerView) inflate.findViewById(R.id.rv);
    }
}
