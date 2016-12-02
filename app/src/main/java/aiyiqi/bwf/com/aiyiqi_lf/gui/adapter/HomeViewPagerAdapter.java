package aiyiqi.bwf.com.aiyiqi_lf.gui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.R;
import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;

/**
 * Created by Administrator on 2016/11/29.
 */

public class HomeViewPagerAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private List<ResponseHomeVPDatas.DataBean> datas;
    private List<View> views;

    public HomeViewPagerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    private void initView() {
        views = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            View view = inflater.inflate(R.layout.home_viewpage_image,null);
            views.add(view);
        }

    }

    public void setDatas(List<ResponseHomeVPDatas.DataBean> datas){
        if(this.datas == null)
            this.datas = new ArrayList<>();
        this.datas = datas;
        notifyDataSetChanged();
        initView();
    }
//    public void addDatas(List<ResponseHomeVPDatas.DataBean> datas){
//        if(this.datas == null)
//            this.datas = new ArrayList<>();
//        this.datas.addAll(datas);
//        Log.d("HomeViewPagerAdapter", "this.datas.size():" + this.datas.size());
//        notifyDataSetChanged();
//    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position%views.size());

        SimpleDraweeView image =
                (SimpleDraweeView) view.findViewById(R.id.home_viewpager_image);
        image.setImageURI(datas.get(position%datas.size()).getImagesrc());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position%views.size()));
    }
}
