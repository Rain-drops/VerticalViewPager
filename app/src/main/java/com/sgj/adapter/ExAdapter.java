package com.sgj.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.sgj.listener.OnItemViewClickListener;
import com.sgj.verticalviewpager.PagerAdapter;

import java.util.List;

/**
 * Created by John on 2016/8/8.
 */
public abstract class ExAdapter<T> extends PagerAdapter {

    List<T> mDatas;
    private OnItemViewClickListener mOnItemViewClickLisn;

    public ExAdapter() {
    }

    public ExAdapter(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    protected abstract View getItem(ViewGroup paramViewGroup, int paramInt);

    public T getItem(int position){
        return null == mDatas ? null : mDatas.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View localView = getItem(container, position);
        container.addView(localView);
        return localView;
    }

    public boolean isEmpty(){
        return getCount() == 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    protected void callbackItemViewClick(int paramInt, View paramView){
        if(null == mOnItemViewClickLisn){
            return;
        }
        mOnItemViewClickLisn.onItemViewClick(paramInt, paramView);
    }

    public void setData(List<T> paramList)
    {
        this.mDatas = paramList;
    }

    public void setOnItemViewClickListener(OnItemViewClickListener paramOnItemViewClickListener)
    {
        this.mOnItemViewClickLisn = paramOnItemViewClickListener;
    }
}
