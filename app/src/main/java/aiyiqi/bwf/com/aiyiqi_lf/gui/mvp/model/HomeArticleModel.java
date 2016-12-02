package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;

/**
 * Created by Administrator on 2016/11/30.
 */

public interface HomeArticleModel {

//    void loadNextPageDatas(int pager,int type,String id,NextCallback callback,String url);
    void loadDatas(int page, int type, String id, final Callback callback);
//    public interface NextCallback{
//        void loadNextSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen);
//        void loadNextFailed();
//    }

    public interface Callback{
        void loadSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen);
        void loadFailed();
    }
}
