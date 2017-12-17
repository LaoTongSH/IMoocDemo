package com.ltsh.mk1_06_buttondemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	/*
	 * 
	 *  Button---可以设置文本内容一个按钮
	 *  ImageButton---不可以设置文本内容，background以及src添加一个image。
	 *  
	 */

	private Button loginButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton =(Button)findViewById(R.id.button1);
		
		loginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 在本方法中监听Button点击事件。
				Toast.makeText(MainActivity.this, " 按钮 被点击了！ ", Toast.LENGTH_LONG).show();
			}
		});
		
		loginButton.setOnClickListener(listener)	;
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.i("tag","匿名类复杂写法实现的监听事件被触发了 ！");
		}
	};
}
