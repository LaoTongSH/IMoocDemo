//本例是：慕课网   “Android中的消息提示、菜单与动画 “  第三章例题

package com.ltsh.toastdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initEvent();
	}
	
	//初始化点击事件方法
	private void initEvent(){
		findViewById(R.id.toast_btn1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast1();
			}
		});
		
		findViewById(R.id.toast_btn2).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast2();
			}
		});

		findViewById(R.id.toast_btn3).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast3();
			}
		});

		findViewById(R.id.toast_btn4).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showToast4();
			}
		});
	}
	
	//显示默认的Toast
	private void showToast1(){
//		Toast toast = Toast.makeText(this, "这是一个默认的Toast !", Toast.LENGTH_LONG);
		Toast toast = Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG);		
		toast.show();
	}

	//改变显示位置的Toast
	private void showToast2(){
		Toast toast = Toast.makeText(this, "改变显示位置的Toast !", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, -150, -200);
		toast.show();
	}

	//显示带有图片的Toast
	private void showToast3(){
		Toast toast = Toast.makeText(this, "显示带图片的Toast !", Toast.LENGTH_LONG);
		LinearLayout toast_layout = (LinearLayout)toast.getView();
		ImageView mImageView = new ImageView(this);
		mImageView.setImageResource(R.drawable.laotong_r);
		toast_layout.addView(mImageView,0);  //第二个参数改变文字和图片之间的位置。
		toast.show();
	}

	//完全自定义的Toast
	private void showToast4(){
		LayoutInflater inflater = LayoutInflater.from(this);
		View toast_view = inflater.inflate(R.layout.layout_toast, null);
		Toast toast = new Toast(this);
		toast.setView(toast_view);
		toast.show();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
