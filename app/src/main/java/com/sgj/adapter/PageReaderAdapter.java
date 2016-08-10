package com.sgj.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.sgj.activity.R;
import com.sgj.model.PageInfo;
import com.sgj.pulltorefresh.PullToRefreshBase;
import com.sgj.pulltorefresh.PullToRefreshWebView;
import com.sgj.utils.DensityUtil;
import com.sgj.utils.ToastUtil;

import java.util.List;

/**
 * Created by John on 2016/8/8.
 */
public class PageReaderAdapter extends ExAdapter {

    private Context mContext;
    private OnRefreshListener mOnRefreshListener;
    private View.OnTouchListener mTouchListener;

    public PageReaderAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected View getItem(ViewGroup paramViewGroup, final int paramInt) {

        PageInfo localPageInfo;
        localPageInfo = (PageInfo) getItem(paramInt);
        PullToRefreshBase.Mode localMode;
        localMode = PullToRefreshBase.Mode.BOTH;
        PullToRefreshWebView localPullToRefreshWebView = new PullToRefreshWebView(mContext, localMode, true, false);

        if (paramInt != 0)
        {
            localPullToRefreshWebView.getheaderLayout().setPullLabel("上一篇");
            localPullToRefreshWebView.getheaderLayout().setLastUpdatedLabel(localPageInfo.getName());
            localPullToRefreshWebView.getheaderLayout().setReleaseLabel("上一篇");
            localPullToRefreshWebView.getheaderLayout().setRefreshingLabel("");
        }
        if (paramInt != -1 + getCount())
        {
            localPullToRefreshWebView.getfooterLayout().setPullLabel("下一篇");
            localPullToRefreshWebView.getfooterLayout().setLastUpdatedLabel(localPageInfo.getName());
            localPullToRefreshWebView.getfooterLayout().setReleaseLabel("下一篇");
            localPullToRefreshWebView.getfooterLayout().setRefreshingLabel("");
        }


        localPullToRefreshWebView.setTag("verticalViewPager" + paramInt);
        localPullToRefreshWebView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<WebView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase refreshView) {
                if (PageReaderAdapter.this.mOnRefreshListener == null)
                    return;
                PageReaderAdapter.this.mOnRefreshListener.onPullDownToRefresh(refreshView, paramInt);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase refreshView) {
                if (PageReaderAdapter.this.mOnRefreshListener == null)
                    return;
                PageReaderAdapter.this.mOnRefreshListener.onPullUpToRefresh(refreshView, paramInt);
            }
        });
        WebView localWebView = (WebView)localPullToRefreshWebView.getRefreshableView();
        localWebView.setId(R.id.webview);
        View localView = onInflateLayout(localWebView, localPullToRefreshWebView, paramInt);
        localWebView.setOnTouchListener(this.mTouchListener);
        localWebView.loadUrl(localPageInfo.getUrl());
        return localView;
    }

    protected View onInflateLayout(WebView paramWebView, PullToRefreshBase paramPullToRefreshBase, int paramInt)
    {
        FrameLayout localFrameLayout = new FrameLayout(mContext);
        ProgressBar localProgressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleSmall);
        localProgressBar.setBackgroundColor(-1);
        localProgressBar.setIndeterminate(false);
        localProgressBar.setMax(100);
        localProgressBar.setProgressDrawable(this.mContext.getResources().getDrawable(R.drawable.layer_webview_progress_bar));
        setBrowserWebViewAttr(localFrameLayout, paramPullToRefreshBase, paramWebView, localProgressBar, paramInt);
        localFrameLayout.addView(paramPullToRefreshBase, new FrameLayout.LayoutParams(-1, -1));
        localFrameLayout.addView(localProgressBar, new FrameLayout.LayoutParams(-1, 2 * DensityUtil.dip2px(1.0F)));
        return localFrameLayout;
    }

    @SuppressLint({"JavascriptInterface"})
    private void setBrowserWebViewAttr(FrameLayout paramFrameLayout, PullToRefreshBase paramPullToRefreshBase, WebView paramWebView, ProgressBar paramProgressBar, int paramInt)
    {
        WebSettings localWebSettings = paramWebView.getSettings();
        if (Build.VERSION.SDK_INT >= 21)
            localWebSettings.setMixedContentMode(0);
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setUserAgentString(paramWebView.getSettings().getUserAgentString() + " Rong/2.0");
        localWebSettings.setPluginState(WebSettings.PluginState.ON);
        localWebSettings.setLoadWithOverviewMode(true);
        localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        localWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        localWebSettings.setUserAgentString(localWebSettings.getUserAgentString());

        paramWebView.setWebChromeClient(new WebChromeClient() {

        });
        paramWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });
    }

    public OnRefreshListener getOnRefreshListener() {
        return mOnRefreshListener;
    }

    public void setOnRefreshListener(OnRefreshListener mOnRefreshListener) {
        this.mOnRefreshListener = mOnRefreshListener;
    }

    public static abstract interface OnRefreshListener
    {
        public abstract void onPullDownToRefresh(PullToRefreshBase paramPullToRefreshBase, int paramInt);

        public abstract void onPullUpToRefresh(PullToRefreshBase paramPullToRefreshBase, int paramInt);
    }
}
