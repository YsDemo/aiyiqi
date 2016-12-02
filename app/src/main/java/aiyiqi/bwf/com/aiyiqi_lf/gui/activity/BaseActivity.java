package aiyiqi.bwf.com.aiyiqi_lf.gui.activity;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/11/29.
 */

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//      去标题栏
        getWindow().addFlags(Window.FEATURE_NO_TITLE);
//      竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initDatas();
    }

    //     初始化View
    protected abstract void initDatas();
//     初始化数据
    protected abstract void initView();
//     获得资源ID
    public abstract int getContentView();
    /**
     * 不用强转的findviewbyid
     */
    public <T extends View> T findViewByIdNoCast(int id) {
        return (T) super.findViewById(id);
    }
    /**
     * dip转像素
     */
    public  int dip2px(float dpValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    /**
     * 像素转dip
     */
    public  int px2dip(float pxValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }
    /**
     * 判断是否有网络
     */
    public boolean isNetWork() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager != null
                && connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    /**
     * 获取状态栏高度
     */
    public int getStatusHeight() {
        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int n = rect.top;
        if (n != 0) {
            return n;
        }
        try {
            final Class<?> forName = Class.forName("com.android.internal.R$dimen");
            n = getResources().getDimensionPixelSize(Integer.parseInt(forName.getField("status_bar_height").get(forName.newInstance()).toString()));
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
        }catch (InstantiationException ex3) {
            ex3.printStackTrace();
        }catch (NumberFormatException ex4) {
            ex4.printStackTrace();
        }catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
        }catch (SecurityException ex6) {
            ex6.printStackTrace();
        }catch (NoSuchFieldException ex7) {
            ex7.printStackTrace();
        }
        return n;
    }
    protected void setFullScreen(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
