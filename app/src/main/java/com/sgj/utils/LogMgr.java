package com.sgj.utils;

import android.util.Log;

/**
 * Created by John on 2016/8/8.
 */
public class LogMgr {
    private static boolean mIsDebug;
    private static String mMainTag = "ExLogMgr";

    static
    {
        mIsDebug = true;
    }

    public static void d(String paramString)
    {
        d(mMainTag, paramString);
    }

    public static void d(String paramString1, String paramString2)
    {
        if (!mIsDebug)
            return;
        Log.d(paramString1, paramString2);
    }

    public static void e(String paramString)
    {
        e(mMainTag, paramString);
    }

    public static void e(String paramString1, String paramString2)
    {
        if (!mIsDebug)
            return;
        Log.e(paramString1, paramString2);
    }

    public static String getMainTag()
    {
        return mMainTag;
    }

    public static void i(String paramString)
    {
        i(mMainTag, paramString);
    }

    public static void i(String paramString1, String paramString2)
    {
        if (!mIsDebug)
            return;
        Log.i(paramString1, paramString2);
    }

    public static boolean isDebug()
    {
        return mIsDebug;
    }

    public static void setMainTag(String paramString)
    {
        mMainTag = paramString;
    }

    public static void turnOff()
    {
        mIsDebug = false;
    }

    public static void turnOn()
    {
        mIsDebug = true;
    }

    public static void v(String paramString)
    {
        v(mMainTag, paramString);
    }

    public static void v(String paramString1, String paramString2)
    {
        if (!mIsDebug)
            return;
        Log.v(paramString1, paramString2);
    }

    public static void w(String paramString)
    {
        w(mMainTag, paramString);
    }

    public static void w(String paramString1, String paramString2)
    {
        if (!mIsDebug)
            return;
        Log.w(paramString1, paramString2);
    }
}
