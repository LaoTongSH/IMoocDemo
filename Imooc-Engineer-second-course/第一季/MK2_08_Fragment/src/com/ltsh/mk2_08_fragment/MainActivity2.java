package com.ltsh.mk2_08_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends Activity {
	
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);		
		Button button=(Button) findViewById(R.id.button);
		tv=(TextView) findViewById(R.id.text);
		button.setText("�ı�");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tv.setText("TextView�ı���");
				tv.setTextSize(40);
			}
		});
	}
}
