package com.ltsh.ym_01_actionbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		switch(item.getItemId()){
		case R.id.menu_settings:
			Toast.makeText(this, "点击了 设置按钮 ！", Toast.LENGTH_SHORT).show();  
	      break; 
		case R.id.menu_load:
			Toast.makeText(this, "点击了 读 取 按钮 ！", Toast.LENGTH_SHORT).show();  
	      break;
		case R.id.action_delete :
			Toast.makeText(this, "点击了 隐藏按钮 ！", Toast.LENGTH_SHORT).show();  
	      break; 
		case R.id.action_compose :
			Toast.makeText(this, "点击了 隐藏按钮 ！", Toast.LENGTH_SHORT).show();  
	      break; 

		}
		return true;
	}

//	/**
//	 * A placeholder fragment containing a simple view.
//	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//			return rootView;
//		}
//	}

}
