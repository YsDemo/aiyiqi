package aiyiqi.bwf.com.aiyiqi_lf.util;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/11/29.
 */

public abstract class HttpStringCallback<T> extends StringCallback {
    private Class<T> tclass;
    public HttpStringCallback() {
//      转换类
        tclass = (Class<T>) ((ParameterizedType)getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(String response, int id) {
        if(TextUtils.isEmpty(response))
            onFailed("数据解析异常");
        if(response.startsWith("[")){
            List<T> tList = JSON.parseArray(response,tclass);
            if(tList == null) onFailed("数据解析异常");
            onSuccess(null,tList);
        }else {
            T t = JSON.parseObject(response, tclass);
            if(t == null) onFailed("数据解析异常");
            onSuccess(t,null);
        }
    }
    //    请求成功
    public abstract void onSuccess(T t, List<T> tList);
    //    请求失败
    public abstract void onFailed(String errMsg);
}
