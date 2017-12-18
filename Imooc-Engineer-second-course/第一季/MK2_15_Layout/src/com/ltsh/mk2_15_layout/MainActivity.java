package com.ltsh.mk2_15_layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView title_tv;
	private Button button;
	private ViewStub stub;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		title_tv = (TextView) findViewById(R.id.title);
		title_tv.setText("自定义布局");
		button = (Button) findViewById(R.id.btn);
		stub = (ViewStub) findViewById(R.id.stub);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stub.inflate();
			}
		});

	}

}
