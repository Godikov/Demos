package com.example.administrator.demos.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.administrator.demos.R;

/**
 * Created by Administrator on 2018/9/18.
 */

public class MyTableWidget extends AppWidgetProvider {

    public static final String TAG = "MyTableWidget";
    public static final String CLICK_ACTION = "com.example.administrator.demos.action.CLICK";

    public MyTableWidget(){
        super();
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);
        //广播内置方法，用于分发具体的事件给其他方法。
        if(intent.getAction().equals(CLICK_ACTION)){
            Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap srcbBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test_img);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    for(int i = 0;i<37;i++){
                        float degree = (i * 10) % 360;
                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.table_widget);
                        remoteViews.setImageViewBitmap(R.id.iv,rotateBitmap(context,srcbBitmap,degree));
                        Intent clickIntent = new Intent();
                        clickIntent.setAction(CLICK_ACTION);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,clickIntent,0);
                        remoteViews.setOnClickPendingIntent(R.id.iv,pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context,MyTableWidget.class),remoteViews);
                        SystemClock.sleep(30);
                    }
                }
            }).start();
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //小部件被添加或每次小部件更新时都会调用一次，更新时机由updatePeriodMillis指定。
        final int counter = appWidgetIds.length;
        for(int i = 0;i<counter;i++){
            int appWidgetId = appWidgetIds[i];
            onWidgetUpdate(context,appWidgetManager,appWidgetId);
        }
    }

    /**
     *  桌面小部件更新
     * */
    private void onWidgetUpdate(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.table_widget);
        Intent clickIntent = new Intent();
        clickIntent.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,clickIntent,0);
        remoteViews.setOnClickPendingIntent(R.id.iv,pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId,remoteViews);
    }

    private Bitmap rotateBitmap(Context context,Bitmap srcbBitmap,float degree){
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmpBitmap = Bitmap.createBitmap(srcbBitmap,0,0,srcbBitmap.getWidth(),srcbBitmap.getHeight(),matrix,true);
        return tmpBitmap;
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        //当窗口小部件第一次添加到桌面时调用，可添加多次但只会调用一次。
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        //每删除一次桌面小部件就调用一次。
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        //最后一个该类型的桌面小部件被删除时调用。
    }
}
