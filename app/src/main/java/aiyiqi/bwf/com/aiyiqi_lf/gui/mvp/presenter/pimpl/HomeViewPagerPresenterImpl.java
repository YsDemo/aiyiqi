package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.pimpl;

import android.util.Log;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.HomeViewPagerModel;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.mimpl.HomeViewPagerModelImpl;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view.HomeViewPagerView;

/**
 * Created by Administrator on 2016/11/29.
 */

public class HomeViewPagerPresenterImpl implements aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.HomeViewPagerPresenter {
    private HomeViewPagerModel model;
    private HomeViewPagerView view;

    public HomeViewPagerPresenterImpl(HomeViewPagerView view) {
        model = new HomeViewPagerModelImpl();
        this.view = view;
    }

    @Override
    public void loadDatas() {
        model.loadDatas(new HomeViewPagerModel.Callback() {
            @Override
            public void loadSuccess(List<ResponseHomeVPDatas.DataBean> dataBeen) {
                Log.d("HomeViewPagerPresenterI", "dataBeen.size():" + dataBeen.size());
                view.showVPSuccess(dataBeen);
            }

            @Override
            public void loadFailed(){
                view.showVPFailed();
            }
        });
    }
}
