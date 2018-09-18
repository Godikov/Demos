package com.example.administrator.demos.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import com.example.administrator.demos.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    //通知
    public void sendNotification(View view) {
        Notification notification = new Notification();
        notification.icon = R.mipmap.ic_launcher;
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notification.tickerText = "tickerText";
        notification.when = System.currentTimeMillis();
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.contentIntent = pendingIntent;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,notification);
    }

    //自定义布局通知
    public void sendMyNotification(View view) {
        Notification notification = new Notification();
        notification.icon = R.mipmap.ic_launcher;
        notification.tickerText = "hello world";
        notification.when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.layout_notification);
        remoteViews.setTextViewText(R.id.tv_title,"通知栏标题");
        remoteViews.setTextViewText(R.id.tv_content,"通知栏内容");
        remoteViews.setImageViewResource(R.id.iv,R.mipmap.ic_launcher_round);
        PendingIntent remoteViewsPendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.iv,remoteViewsPendingIntent);
        notification.contentView = remoteViews;
        notification.contentIntent = pendingIntent;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,notification);
    }
}
