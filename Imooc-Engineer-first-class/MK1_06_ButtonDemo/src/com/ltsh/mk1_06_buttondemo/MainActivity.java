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
	 *  Button---���������ı�����һ����ť
	 *  ImageButton---�����������ı����ݣ�background�Լ�src���һ��image��
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
				// �ڱ������м���Button����¼���
				Toast.makeText(MainActivity.this, " ��ť ������ˣ� ", Toast.LENGTH_LONG).show();
			}
		});
		
		loginButton.setOnClickListener(listener)	;
	}
	
	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Log.i("tag","�����ิ��д��ʵ�ֵļ����¼��������� ��");
		}
	};
}
