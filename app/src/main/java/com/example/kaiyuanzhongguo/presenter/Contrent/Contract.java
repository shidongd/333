package com.example.kaiyuanzhongguo.presenter.Contrent;

import com.example.kaiyuanzhongguo.presenter.BasePresenter;
import com.example.kaiyuanzhongguo.ui.BaseView;

/**
 * Created by 石栋 on 2017/12/25.
 */

public interface Contract {
    interface IPresenter extends BasePresenter{
        void  requestData();

    }
    interface IView extends BaseView<IPresenter>{
                void showData();
    }
}
