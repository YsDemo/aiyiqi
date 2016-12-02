package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.mimpl;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.HomeViewPagerModel;
import aiyiqi.bwf.com.aiyiqi_lf.util.Apis;
import aiyiqi.bwf.com.aiyiqi_lf.util.HttpStringCallback;

/**
 * Created by Administrator on 2016/11/29.
 */

public class HomeViewPagerModelImpl implements HomeViewPagerModel {

    public void loadDatas(final Callback callback) {
        String url = Apis.HOME_VIEWPAGER_URL;
        OkHttpUtils.get().url(url)
        .addParams("action","getownerinfo")
        .addParams("cityId","2")
        .build()
        .execute(new HttpStringCallback<ResponseHomeVPDatas>() {

            @Override
            public void onSuccess(ResponseHomeVPDatas responseHomeVPDatas,
                                  List<ResponseHomeVPDatas> responseHomeVPDatases) {
                List<ResponseHomeVPDatas.DataBean> datas = responseHomeVPDatas.getData();
                if(datas != null)
                callback.loadSuccess(datas);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.loadFailed();
            }
        });
    }
}
