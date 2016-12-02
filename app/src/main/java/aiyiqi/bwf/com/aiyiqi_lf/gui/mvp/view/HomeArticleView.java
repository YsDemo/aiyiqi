package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface HomeArticleView {
    void showSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen);
    void showFailed();
}
