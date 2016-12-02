package aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.pimpl;

import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.HomeArticleModel;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.model.mimpl.HomeArticleModelImpl;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.presenter.HomeArticlePresenter;
import aiyiqi.bwf.com.aiyiqi_lf.gui.mvp.view.HomeArticleView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class HomeArticlePresenterImpl implements HomeArticlePresenter, HomeArticleModel.Callback {
    private HomeArticleView articleView;
    private HomeArticleModel articleModel;
    private int page;
    private int type;
    private String id;
    private String nextUrl;
    public HomeArticlePresenterImpl(HomeArticleView articleView) {
        this.articleView = articleView;
        articleModel = new HomeArticleModelImpl();
        this.page = page;
        this.type = type;
        this.id = id;

    }

    @Override
    public void loadDatas(int page,int type,String id) {
        articleModel.loadDatas(page,type,id,this);
//        articleModel.loadNextPageDatas(page,type,id,this,nextUrl);
    }


    @Override
    public void loadSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen) {
        articleView.showSuccess(dataBeen);
    }

    @Override
    public void loadFailed() {
        articleView.showFailed();
    }

//    @Override
//    public void loadNextSuccess(List<ResponseHomeArticleDatas.DataBean> dataBeen) {
//
//    }
//
//    @Override
//    public void loadNextFailed() {
//
//    }
}
