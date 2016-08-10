package com.sgj;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;

import com.sgj.utils.ToastUtil;

import java.io.File;

/**
 * Created by John on 2016/8/8.
 */
public class BaseApplication extends Application {
    private static Context mContext = null;
    private static boolean mHomeKeyPressed;

    public static File getAppCacheDir()
    {
        return mContext.getCacheDir();
    }

    public static File getAppCacheSubDir(String paramString)
    {
        File localFile = new File(getAppCacheDir(), paramString);
        if (!localFile.exists())
            localFile.mkdirs();
        return localFile;
    }

    public static Context getContext()
    {
        return mContext;
    }

    public static ContentResolver getExContentResolver()
    {
        return mContext.getContentResolver();
    }

    public static Resources getExResources()
    {
        return mContext.getResources();
    }

    public static boolean isHomeKeyPressed()
    {
        return mHomeKeyPressed;
    }

    public static void releaseStaticResource()
    {
        ToastUtil.release();
    }

    public static void setHomeKeyPressed(boolean paramBoolean)
    {
        mHomeKeyPressed = paramBoolean;
    }

    public void onCreate()
    {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
