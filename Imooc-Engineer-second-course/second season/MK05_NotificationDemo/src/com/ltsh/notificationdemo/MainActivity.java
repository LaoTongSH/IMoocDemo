//本例是 慕课网 “Android中的消息提示、菜单与动画” 第5章例题

package com.ltsh.notificationdemo;

import com.ltsh.notificationdemo.MainActivity;
import com.ltsh.notificationdemo.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


@SuppressLint("NewApi")
public class MainActivity extends Activity implements OnClickListener{
	NotificationManager manager;		//通知控制类
	int notification_ID;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		findViewById(R.id.btn_send).setOnClickListener(this);
		findViewById(R.id.btn_cancle).setOnClickListener(this);
	}

	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_send:
			sendNotification();			
			break;
		case R.id.btn_cancle:
			manager.cancel(notification_ID);			
			break;

		default:
			break;
		}
		
	}
	
	/**
	 * 构造notification并发送到通知栏
	 */
	private void sendNotification(){
		Intent intent = new Intent(this,MainActivity.class);
		PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
		
		Builder builder = new Notification.Builder(this);			//声明对象且实例化。
		builder.setSmallIcon(R.drawable.ic_launcher);				//设置图标
		builder.setTicker("推送消息");										//手机状态栏的提示；
		builder.setWhen(System.currentTimeMillis());				//设置时间
		builder.setContentTitle("通知栏通知");							//设置标题
		builder.setContentText("我来自NotificationDemo");		//设置通知内容
		builder.setContentIntent(pintent);								//点击后的意图
//		builder.setDefaults(Notification.DEFAULT_SOUND);		//设置提示声音
//		builder.setDefaults(Notification.DEFAULT_LIGHTS);		//设置指示灯
//		builder.setDefaults(Notification.DEFAULT_VIBRATE);	//设置震动
		builder.setDefaults(Notification.DEFAULT_ALL);			//设置震动
		Notification notification = builder.build();					//4.1以上
		//builder.getNotification();
		manager.notify(notification_ID, notification);
	}
	
	
	
	
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
