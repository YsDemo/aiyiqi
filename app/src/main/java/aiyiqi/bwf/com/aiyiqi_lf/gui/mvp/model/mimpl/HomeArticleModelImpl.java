package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.mimpl;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.HomeArticleModel;
import aiyiqi.bwf.com.aiyiqi_lf.util.Apis;
import aiyiqi.bwf.com.aiyiqi_lf.util.HttpStringCallback;

/**
 * Created by Administrator on 2016/11/30.
 */

public class HomeArticleModelImpl implements HomeArticleModel {
//    @Override
//    public void loadNextPageDatas(int page, int type, String id, final NextCallback callback,String url) {
////        String nextUrl = Apis.Home_ARTICLE_NEXTPAGE_URL;
//        OkHttpUtils.get().url(url)
//                .addParams("pageSize","10")
//                .addParams("page",page+"")
//                .addParams("type",type+"")
//                .addParams("id",id)
//                .build()
//                .execute(new HttpStringCallback<ResponseHomeArticleDatas>() {
//                    @Override
//                    public void onSuccess(ResponseHomeArticleDatas articleDatas, List<ResponseHomeArticleDatas> dataBeen) {
//                        List<ResponseHomeArticleDatas.DataBean> datas = articleDatas.getData();
//                        if(datas != null) callback.loadNextSuccess(datas);
//                    }
//
//                    @Override
//                    public void onFailed(String errMsg) {
//                        callback.loadNextFailed();
//                    }
//                });
//    }


    @Override
    public void loadDatas(int page, int type, String id, final Callback callback) {
        String url = Apis.Home_ARTICLE_URL;
        OkHttpUtils.get().url(url)
                .addParams("pageSize","10")
                .addParams("page",page+"")
                .addParams("type",type+"")
                .addParams("id",id)
                .build()
                .execute(new HttpStringCallback<ResponseHomeArticleDatas>() {
                    @Override
                    public void onSuccess(ResponseHomeArticleDatas articleDatas, List<ResponseHomeArticleDatas> dataBeen) {
                        List<ResponseHomeArticleDatas.DataBean> datas = articleDatas.getData();
                        if(datas != null) callback.loadSuccess(datas);
                    }

                    @Override
                    public void onFailed(String errMsg) {
                        callback.loadFailed();
                    }
                });
    }



}
