package aiyiqi.bwf.com.aiyiqi_lf.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.R;
import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;
import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeVPDatas;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.BudgetActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.CityActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.CompanyActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.DesignActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.MaterialsActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.RenderingActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.SchoolActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.activity.SelfHelpActivity;
import aiyiqi.bwf.com.aiyiqi_lf.gui.adapter.HomeArticleAdapter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.adapter.HomeViewPagerAdapter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.HomeArticlePresenter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.HomeViewPagerPresenter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.pimpl.HomeArticlePresenterImpl;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.pimpl.HomeViewPagerPresenterImpl;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view.HomeArticleView;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view.HomeViewPagerView;
import aiyiqi.bwf.com.aiyiqi_lf.gui.view.PagerDotIndicator;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/28.
 */

public class HomeFragment extends BaseFragment implements HomeViewPagerView, HomeArticleView {
    //    @BindView(R.id.main_recyclerView)
    @BindView(R.id.linearlayout_feature_package_new)
    LinearLayout linearlayoutFeaturePackageNew;
    @BindView(R.id.linearlayout_feature_activity)
    LinearLayout linearlayoutFeatureActivity;
    @BindView(R.id.linearlayout_feature_school)
    LinearLayout linearlayoutFeatureSchool;
    @BindView(R.id.linearlayout_feature_my_budget)
    LinearLayout linearlayoutFeatureMyBudget;
    @BindView(R.id.linearlayout_feature_category)
    LinearLayout linearlayoutFeatureCategory;
    @BindView(R.id.linearlayout_feature_renderings_new)
    LinearLayout linearlayoutFeatureRenderingsNew;
    @BindView(R.id.linearlayout_feature_self_order)
    LinearLayout linearlayoutFeatureSelfOrder;
    @BindView(R.id.linearlayout_feature_design_measure)
    LinearLayout linearlayoutFeatureDesignMeasure;
    @BindView(R.id.main_recyclerView)
    RecyclerView mainRecyclerView;
    //  ViewPager
    private HomeViewPagerPresenter viewPagerPresenter;
    private HomeViewPagerAdapter viewPagerAdapter;
    private ViewPager homeViewPager;

    // 指示器
    private PagerDotIndicator indicator;
    private LinearLayout homeIndicator;

    //  下面的RecyclerView


    private HomeArticlePresenter articlePresenter;
    private HomeArticleAdapter articleAdapter;
    private LinearLayoutManager layoutManager;

    private List<ResponseHomeArticleDatas.DataBean> datas;

    private int page;
    private int type;
    private String id;
    private String nextUrl;
    private int count = 1;

    public HomeFragment() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        ViewPager
        homeViewPager = (ViewPager) getView().findViewById(R.id.main_viewpager);
        viewPagerPresenter = new HomeViewPagerPresenterImpl(this);
        viewPagerPresenter.loadDatas();
//        指示器
        homeIndicator = (LinearLayout) getView().findViewById(R.id.home_vp_ll);
        indicator = new PagerDotIndicator(getActivity(), homeViewPager, homeIndicator);
//        ImageButton  八个键


//      下面的view
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Log.d("HomeFragment", "mainRecyclerView:" + mainRecyclerView);
        mainRecyclerView.setLayoutManager(layoutManager);
        articleAdapter = new HomeArticleAdapter(getActivity());
        mainRecyclerView.setAdapter(articleAdapter);
        articlePresenter = new HomeArticlePresenterImpl(this);
        setInitDatas();


    }

    private void setInitDatas() {
        datas = new ArrayList<>();
        if (count == 1) {
            this.page = 1;
            this.id = 1218226 + "";
            this.type = 3;
            count++;
        } else {
            this.page = count;
            this.id = datas.get(datas.size() - 1).getId();
            this.type = datas.get(datas.size() - 1).getType();
            count++;
        }
        articlePresenter.loadDatas(page, type, id);
    }


    @Override
    protected int getContextViewResId() {
        return R.layout.home_fragment;
    }


    @Override
    public void showVPSuccess(List<ResponseHomeVPDatas.DataBean> dataBeen) {
//        ViewPager
        viewPagerAdapter = new HomeViewPagerAdapter(getActivity());
        viewPagerAdapter.setDatas(dataBeen);
        homeViewPager.setAdapter(viewPagerAdapter);
//        指示器
        indicator.setDotNums(dataBeen.size());
    }

    @Override
    public void showVPFailed() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void showSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen) {
        if (dataBeen != null) this.datas = dataBeen;
        articleAdapter.addDatas(datas);
    }

    @Override
    public void showFailed() {

    }

    @OnClick({R.id.linearlayout_feature_package_new, R.id.linearlayout_feature_activity, R.id.linearlayout_feature_school, R.id.linearlayout_feature_my_budget, R.id.linearlayout_feature_category, R.id.linearlayout_feature_renderings_new, R.id.linearlayout_feature_self_order, R.id.linearlayout_feature_design_measure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearlayout_feature_package_new:
                startActivity(new Intent(getActivity(), CompanyActivity.class));
                break;
            case R.id.linearlayout_feature_activity:
                startActivity(new Intent(getActivity(), CityActivity.class));
                break;
            case R.id.linearlayout_feature_school:
                startActivity(new Intent(getActivity(), SchoolActivity.class));
                break;
            case R.id.linearlayout_feature_my_budget:
                startActivity(new Intent(getActivity(), BudgetActivity.class));
                break;
            case R.id.linearlayout_feature_category:
                startActivity(new Intent(getActivity(), MaterialsActivity.class));
                break;
            case R.id.linearlayout_feature_renderings_new:
                startActivity(new Intent(getActivity(), RenderingActivity.class));
                break;
            case R.id.linearlayout_feature_self_order:
                startActivity(new Intent(getActivity(), SelfHelpActivity.class));
                break;
            case R.id.linearlayout_feature_design_measure:
                startActivity(new Intent(getActivity(), DesignActivity.class));
                break;
        }
    }
}
