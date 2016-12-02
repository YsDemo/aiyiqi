package aiyiqi.bwf.com.aiyiqi_lf.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import aiyiqi.bwf.com.aiyiqi_lf.R;
import aiyiqi.bwf.com.aiyiqi_lf.entity.ResponseHomeArticleDatas;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/1.
 */

public class HomeArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<ResponseHomeArticleDatas.DataBean> dataBeen;
    private LayoutInflater inflater;

    private final int TYPE_ARTICLE = 1;
    private final int TYPE_POSTS = 3;
    private final int TYPE_NOMOER = -1;

    private int state;

    public HomeArticleAdapter(Context context) {
        this.dataBeen = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }


    public void addDatas(List<ResponseHomeArticleDatas.DataBean> dataBeen) {
        this.dataBeen.addAll(dataBeen);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataBeen.get(position).getType() == TYPE_ARTICLE) {
            return TYPE_ARTICLE;
        } else if (dataBeen.get(position).getType() == TYPE_POSTS) {
            return TYPE_POSTS;
        }
        return TYPE_NOMOER;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ARTICLE) {
            return new ArticleViewHolder(inflater.inflate(R.layout.home_item_article, null));
        } else {
            return new PostsViewHolder(inflater.inflate(R.layout.home_item_posts, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        ArticleViewHolder articleViewHolder;
        PostsViewHolder postsViewHolder;
        switch (itemViewType) {
            case TYPE_ARTICLE:
                articleViewHolder = (ArticleViewHolder) holder;
                articleViewHolder.homeArticleTextviewTitle.setText(dataBeen.get(position).getTitle());
                articleViewHolder.homeArticleTextviewPublishedtime.setText(dataBeen.get(position).getDateline());
                articleViewHolder.homeArticleImageviewTitle.setImageURI(dataBeen.get(position).getPath());
                articleViewHolder.homeArticleTextviewComment.setText(dataBeen.get(position).getReplies());
                articleViewHolder.homeArticleTextviewBrowse.setText(dataBeen.get(position).getViews());
                break;
            case TYPE_POSTS:
                postsViewHolder = (PostsViewHolder) holder;
                postsViewHolder.homePostsSimpleDraweeViewUserPhoto.setImageURI(dataBeen.get(position).getAvtUrl());
                postsViewHolder.homePostsTextviewUserName.setText(dataBeen.get(position).getAuthor());
                postsViewHolder.homePostsTextviewPublishedtime.setText(dataBeen.get(position).getDateline());
                postsViewHolder.homePostsSimpleDraweeViewTitle.setImageURI(dataBeen.get(position).getPath());
                postsViewHolder.homePostsTextviewTitle.setText(dataBeen.get(position).getTitle());
                postsViewHolder.homePostsTextviewComment.setText(dataBeen.get(position).getReplies());
                postsViewHolder.homePostsTextviewBrowse.setText(dataBeen.get(position).getLike_num()+"");
                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_article_textview_title)
        TextView homeArticleTextviewTitle;
        @BindView(R.id.home_article_imageview_title)
        SimpleDraweeView homeArticleImageviewTitle;
        @BindView(R.id.home_article_textview_publishedtime)
        TextView homeArticleTextviewPublishedtime;
        @BindView(R.id.home_article_textview_browse)
        TextView homeArticleTextviewBrowse;
        @BindView(R.id.home_article_textview_comment)
        TextView homeArticleTextviewComment;

        public ArticleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view_temp)
        View viewTemp;
        @BindView(R.id.home_posts_SimpleDraweeView_user_photo)
        SimpleDraweeView homePostsSimpleDraweeViewUserPhoto;
        @BindView(R.id.home_posts_textview_user_name)
        TextView homePostsTextviewUserName;
        @BindView(R.id.home_posts_textview_publishedtime)
        TextView homePostsTextviewPublishedtime;
        @BindView(R.id.home_posts_imageview_user_attention)
        ImageView homePostsImageviewUserAttention;
        @BindView(R.id.home_posts_textview_attention)
        TextView homePostsTextviewAttention;
        @BindView(R.id.home_posts_imageview_form)
        TextView homePostsImageviewForm;
        @BindView(R.id.home_posts_textview_browse)
        TextView homePostsTextviewBrowse;
        @BindView(R.id.home_posts_textview_comment)
        TextView homePostsTextviewComment;
        @BindView(R.id.home_posts_textview_title)
        TextView homePostsTextviewTitle;
        @BindView(R.id.home_posts_SimpleDraweeView_title)
        SimpleDraweeView homePostsSimpleDraweeViewTitle;

        public PostsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
