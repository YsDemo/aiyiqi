package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;

/**
 * Created by Administrator on 2016/11/29.
 */

public interface HomeViewPagerView {
    void showVPSuccess(List<ResponseHomeVPDatas.DataBean> dataBeen);
    void showVPFailed();
}
