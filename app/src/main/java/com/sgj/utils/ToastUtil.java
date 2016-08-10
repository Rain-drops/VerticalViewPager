package com.sgj.utils;

import android.widget.Toast;

import com.sgj.BaseApplication;

/**
 * Created by John on 2016/8/8.
 */
public class ToastUtil {
    private static Toast mToast;

    private static void initToast()
    {
        if (mToast != null)
            return;
        mToast = Toast.makeText(BaseApplication.getContext(), "", Toast.LENGTH_SHORT);
    }

    public static void release()
    {
        mToast = null;
    }

    public static void showToast(int paramInt)
    {
        try
        {
            initToast();
            mToast.setText(paramInt);
            mToast.show();
            return;
        }
        catch (Throwable localThrowable)
        {
            if (LogMgr.isDebug());
            localThrowable.printStackTrace();
        }
    }

    public static void showToast(int paramInt, Object[] paramArrayOfObject)
    {
        showToast(BaseApplication.getContext().getResources().getString(paramInt, paramArrayOfObject));
    }

    public static void showToast(String paramString)
    {
        try
        {
            initToast();
            mToast.setText(paramString);
            mToast.show();
            return;
        }
        catch (Throwable localThrowable)
        {
            if (LogMgr.isDebug());
            localThrowable.printStackTrace();
        }
    }
}
