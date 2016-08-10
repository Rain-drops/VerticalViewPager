package com.sgj.utils;

import com.sgj.BaseApplication;

/**
 * Created by John on 2016/8/8.
 */
public class DeviceUtil {
    public static int getScreenHeight()
    {
        return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth()
    {
        return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }
}
