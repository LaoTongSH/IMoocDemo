package com.ltsh.optionmenudemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		MenuItem item = menu.add(1, 100, 1, "菜单一");
		item.setTitle("动态修改菜单项的Title ！");
		item.setIcon(R.drawable.ic_launcher);		//注意！！！ 当api >=11时，不再显示 图标！
		menu.add(1, 200, 1, "菜单二");
		menu.add(1, 300, 1, "菜单三");
		menu.add(1, 400, 1, "菜单四");
		menu.add(1, 500, 1, "菜单五");
		menu.add(1, 600, 1, "菜单六");
		menu.add(1, 700, 1, "菜单七");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		//用xml菜单布局文件判断点击。
//		case R.id.action_menu_item1:
//			Toast.makeText(MainActivity.this, "点击了菜单一", Toast.LENGTH_SHORT).show();
//			break;
//		case R.id.action_menu_item2:
//			Toast.makeText(MainActivity.this, "点击了菜单二", Toast.LENGTH_SHORT).show();			
//			break;
		//用动态代码添加菜单项点击的判断：
		case 100:
			Toast.makeText(MainActivity.this, "点击了菜单一", Toast.LENGTH_SHORT).show();
			break;			
		case 200:
			Toast.makeText(MainActivity.this, "点击了菜单二", Toast.LENGTH_SHORT).show();
			break;			
		case 300:
			Toast.makeText(MainActivity.this, "点击了菜单三", Toast.LENGTH_SHORT).show();
			break;			
		case 400:
			Toast.makeText(MainActivity.this, "点击了菜单四", Toast.LENGTH_SHORT).show();
			break;			
		case 500:
			Toast.makeText(MainActivity.this, "点击了菜单五", Toast.LENGTH_SHORT).show();
			break;			
		case 600:
			Toast.makeText(MainActivity.this, "点击了菜单六", Toast.LENGTH_SHORT).show();
			break;			
		case 700:
//			Toast.makeText(MainActivity.this, "点击了菜单七", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(MainActivity.this,SecondActivity.class);
			item.setIntent(intent);
			break;			
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
