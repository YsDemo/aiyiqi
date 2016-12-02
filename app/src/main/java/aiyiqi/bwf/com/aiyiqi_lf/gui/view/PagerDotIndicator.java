package aiyiqi.bwf.com.aiyiqi_lf.gui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import aiyiqi.bwf.com.aiyiqi_lf.R;

/**
 * Created by Administrator on 2016/11/30.
 */

public class PagerDotIndicator {
    private LinearLayout indicator;
    private LayoutInflater inflater;
    private ViewPager viewPager;

    private int normalDotRes;
    private int selectedDotRes;
    public PagerDotIndicator(Context context, ViewPager viewPager, final LinearLayout indicator) {
        inflater = LayoutInflater.from(context);
        this.viewPager = viewPager;
        this.indicator = indicator;
        normalDotRes = R.drawable.jshop_banner_point_inactive;
        selectedDotRes = R.drawable.jshop_banner_point_active;
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < indicator.getChildCount(); i++) {
                    ImageView imager = (ImageView) indicator.getChildAt(i)
                            .findViewById(R.id.home_indicator_image);
                    if(position%indicator.getChildCount() == i){
                        imager.setImageResource(selectedDotRes);
                    }else{
                        imager.setImageResource(normalDotRes);
                    }
                }
            }

        });

    }


    public void setDotNums(int size){
        if(indicator.getChildCount()!=0){
            return;
        }
        for (int i = 0; i <size ; i++) {
            View view = inflater.inflate(R.layout.home_indicator,null);
            ImageView image = (ImageView) view.findViewById(R.id.home_indicator_image);
            if(i == 0){
                image.setImageResource(selectedDotRes);
            }else {
                image.setImageResource(normalDotRes);
            }
            indicator.addView(view);
        }
    }
}
