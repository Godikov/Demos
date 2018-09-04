package com.example.administrator.demos.util;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/6/1.
 */

public class ScreenUtil {

    /**
     *  获取屏幕宽度
     * */
    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        LogUtil.e("getScreenWidth",width+"");
        return width;
    }

    /**
     *  获取屏幕高度
     * */
    public static int getScreenHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        LogUtil.e("getScreenHeight",height+"");
        return height;
    }

    /**
     * dp转换成px
     */
    public static int dp2px(Context context, float dpValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    /**
     * px转换成dp
     */
    public static int px2dp(Context context, float pxValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    public static int getStatusBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * sp转换成px
     */
    public static int sp2px(Context context, float spValue){
        float fontScale=context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue*fontScale+0.5f);
    }
    /**
     * px转换成sp
     */
    public static int px2sp(Context context, float pxValue){
        float fontScale=context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue/fontScale+0.5f);
    }

    /**
     *  首页瀑布流ImageView高度获取
     * */
    public static int getImgWidth(Context context){
        int screen_width = getScreenWidth(context);
        int extra_width = ScreenUtil.dp2px(context,30);
        int half_width = (screen_width - extra_width)/2;
        return half_width;
    }

}
