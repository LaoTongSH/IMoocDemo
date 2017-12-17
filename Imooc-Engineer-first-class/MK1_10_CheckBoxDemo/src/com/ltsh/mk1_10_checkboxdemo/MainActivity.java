package com.ltsh.mk1_10_checkboxdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

	private CheckBox checkBox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		
		checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				
				String text = checkBox.getText().toString();
				Log.i("tag", text+"按钮被点击！！");
				if(isChecked){
					Log.i("tag", text+"选中！");
				}else{
					Log.i("tag", text+"未被选中！");
				}
				
			}
		});
	}


}
