package com.example.zy.searchbestpractice.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.example.zy.searchbestpractice.BaseRecyclerAdapter;
import com.example.zy.searchbestpractice.SearchActivity;
import com.example.zy.searchbestpractice.adapter.SearchUserAdapter;
import com.example.zy.searchbestpractice.bean.User;
import com.example.zy.searchbestpractice.bean.base.PageBean;
import com.example.zy.searchbestpractice.bean.base.ResultBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 搜索人界面
 * Created by thanatos
 * on 16/10/24.
 */
public class SearchUserFragment extends BaseRecyclerViewFragment<User>
        implements SearchActivity.SearchAction {

    private String content;

    // fix: 直接点击找人Tab的时候，doSearch调用requestData方法, 异步网络过程中,
    // 生命周期流程调用requestData, 前一次调用使isRefreshing致为false，导致数据重复
    private boolean isRequesting = false;

    public static Fragment instantiate(Context context) {
        return new SearchUserFragment();
    }

    @Override
    protected BaseRecyclerAdapter<User> getRecyclerAdapter() {
        return new SearchUserAdapter(getContext());
    }

    @Override
    protected Type getType() {
        return new TypeToken<ResultBean<PageBean<User>>>() {
        }.getType();
    }

    @Override
    protected void requestData() {
        super.requestData();
        Log.i("thanatosx", "Search User Fragment Request Data, Content: " + content);
        if (TextUtils.isEmpty(content)) {
            mRefreshLayout.setRefreshing(false);
            return;
        }
        if (isRequesting) return;
        isRequesting = true;
        //我注释的
//        String token = isRefreshing ? null : mBean.getNextPageToken();
//        OSChinaApi.search(News.TYPE_FIND_PERSON, content, token, mHandler);
        //我随便加的
        onRequestError();
    }

    @Override
    protected void onRequestFinish() {
        super.onRequestFinish();
        isRequesting = false;
    }

    @Override
    public void onItemClick(int position, long itemId) {
        super.onItemClick(position, itemId);
        User user = mAdapter.getItem(position);
        if (user == null) return;
        //我注释的
//        OtherUserHomeActivity.show(getContext(), user.getId());
    }

    @Override
    public void search(String content) {
        Log.i("thanatosx", "Search User Fragment Do Search, Content: " + content);
        if (this.content != null && this.content.equals(content)) return;
        this.content = content;
        if(mRecyclerView == null)
            return;
        mAdapter.clear();
        mRefreshLayout.setRefreshing(true);
        onRefreshing();
    }

    @Override
    protected boolean isNeedEmptyView() {
        return false;
    }

    @Override
    protected boolean isNeedCache() {
        return false;
    }
}
