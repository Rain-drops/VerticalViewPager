package com.sgj.utils;

import com.sgj.BaseApplication;

/**
 * Created by John on 2016/8/8.
 */
public class DensityUtil {
    public static int dip2px(float paramFloat)
    {
        return (int)(0.5F + paramFloat * getDensity());
    }

    public static float getDensity()
    {
        return BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }

    public static int getDensityDpi()
    {
        return BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static int px2dip(float paramFloat)
    {
        return (int)(0.5F + paramFloat / getDensity());
    }
}
