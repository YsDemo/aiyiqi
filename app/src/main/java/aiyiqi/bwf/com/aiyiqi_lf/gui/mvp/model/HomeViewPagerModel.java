package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface HomeViewPagerModel {

    void loadDatas(Callback callback);
    public interface Callback{
        void loadSuccess(List<ResponseHomeVPDatas.DataBean> dataBeen);
        void loadFailed();
    }
}
