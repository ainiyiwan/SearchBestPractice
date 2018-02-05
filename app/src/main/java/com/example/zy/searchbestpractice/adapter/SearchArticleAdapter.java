package com.example.zy.searchbestpractice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zy.searchbestpractice.BaseRecyclerAdapter;
import com.example.zy.searchbestpractice.R;
import com.example.zy.searchbestpractice.bean.News;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by thanatos on 16/10/24.
 */

public class SearchArticleAdapter extends BaseRecyclerAdapter<News> {

    public SearchArticleAdapter(Context context) {
        this(context, ONLY_FOOTER);
    }

    public SearchArticleAdapter(Context context, int mode) {
        super(context, mode);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_item_search_article, parent, false));
    }

    @Override
    protected void onBindDefaultViewHolder(RecyclerView.ViewHolder h, News item, int position) {
        ViewHolder holder = (ViewHolder) h;
        holder.mViewTitle.setText(item.getTitle());
        holder.mViewContent.setText(item.getBody());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mViewTitle;
        @BindView(R.id.tv_content)
        TextView mViewContent;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
