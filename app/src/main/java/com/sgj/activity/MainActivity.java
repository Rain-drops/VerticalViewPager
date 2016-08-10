package com.sgj.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sgj.adapter.PageReaderAdapter;
import com.sgj.model.PageInfo;
import com.sgj.pulltorefresh.PullToRefreshBase;
import com.sgj.utils.ToastUtil;
import com.sgj.verticalviewpager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PageReaderAdapter.OnRefreshListener{

    VerticalViewPager mViewPager;
    PageReaderAdapter mAdapter;
    List<PageInfo> pageInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        init();


    }

    private void init() {

        mAdapter = new PageReaderAdapter(this);
        this.mAdapter.setOnRefreshListener(this);

        mViewPager = (VerticalViewPager) findViewById(R.id.verticalviewpager);
        mViewPager.setAdapter(mAdapter);
        mAdapter.setData(pageInfos);
        this.mAdapter.notifyDataSetChanged();
        this.mViewPager.setCurrentItem(0);
    }

    private void initData(){
        pageInfos = new ArrayList<>();
        PageInfo pageInfo1 = new PageInfo(0x001, "http://m.qyer.com/guide/41/page/v2FzEQx5-D4/");
        PageInfo pageInfo2 = new PageInfo(0x002, "http://m.qyer.com/guide/41/page/CR7tYShkZeA/");
        PageInfo pageInfo3 = new PageInfo(0x003, "http://m.qyer.com/guide/41/page/wTLK_tVWDWQ/");
        PageInfo pageInfo4 = new PageInfo(0x004, "http://m.qyer.com/guide/41/page/9Eb62PaAPhY/");
        PageInfo pageInfo5 = new PageInfo(0x005, "http://m.qyer.com/guide/41/page/Vut0kvOFRYg/");
        pageInfos.add(pageInfo1);
        pageInfos.add(pageInfo2);
        pageInfos.add(pageInfo3);
        pageInfos.add(pageInfo4);
        pageInfos.add(pageInfo5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase paramPullToRefreshBase, int paramInt) {
        //
//        ToastUtil.showToast("onPullDownToRefresh + " + paramInt);
        int sum = mAdapter.getCount();
        if(0 == paramInt){
            this.mViewPager.setCurrentItem(0, true);
            paramPullToRefreshBase.onRefreshComplete();
        }else {
            this.mViewPager.setCurrentItem(paramInt -1, true);
            paramPullToRefreshBase.onRefreshComplete();

        }

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase paramPullToRefreshBase, int paramInt) {
        //
//        ToastUtil.showToast("onPullUpToRefresh + " + paramInt);
        int sum = mAdapter.getCount();
        if(sum == paramInt){
            this.mViewPager.setCurrentItem(sum, true);
            paramPullToRefreshBase.onRefreshComplete();
        }else {
            this.mViewPager.setCurrentItem(paramInt + 1, true);
            paramPullToRefreshBase.onRefreshComplete();

        }

    }
}
