package com.ltsh.topbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Topbar topbar = (Topbar)findViewById(R.id.topbar);
		
		topbar.setOnTopbarClickListener(new Topbar.topbarClickListener() {
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Log.i("Topbar", "LTSH RIGHT");
				Toast.makeText(MainActivity.this,"LTSH RIGHT" , Toast.LENGTH_LONG).show();
			}
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
				Log.i("Topbar", "LTSH LEFT");
				Toast.makeText(MainActivity.this,"LTSH LEFT" , Toast.LENGTH_LONG).show();
			}
		});
		
		//动态控制Topbar；不显示LEFT Button
		topbar.setLeftIsvisable(false);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
