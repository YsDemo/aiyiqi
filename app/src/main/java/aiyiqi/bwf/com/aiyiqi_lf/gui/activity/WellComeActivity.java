package aiyiqi.bwf.com.aiyiqi_lf.gui.activity;

import android.content.Intent;

import aiyiqi.bwf.com.aiyiqi_lf.R;

/**
 * Created by Administrator on 2016/12/2.
 */

public class WellComeActivity extends BaseActivity {

    @Override
    protected void initDatas() {

    }

    @Override
    protected void initView() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(isExitByUser) return;
                else gotoHome();
                
            }

            
        }.start();
    }

    private void gotoHome() {
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }

    @Override
    public int getContentView() {
        return R.layout.wellcome_activity;
    }

    boolean isExitByUser;

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isExitByUser = true;
    }
}
