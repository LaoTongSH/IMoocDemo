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
		MenuItem item = menu.add(1, 100, 1, "�˵�һ");
		item.setTitle("��̬�޸Ĳ˵����Title ��");
		item.setIcon(R.drawable.ic_launcher);		//ע�⣡���� ��api >=11ʱ��������ʾ ͼ�꣡
		menu.add(1, 200, 1, "�˵���");
		menu.add(1, 300, 1, "�˵���");
		menu.add(1, 400, 1, "�˵���");
		menu.add(1, 500, 1, "�˵���");
		menu.add(1, 600, 1, "�˵���");
		menu.add(1, 700, 1, "�˵���");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		//��xml�˵������ļ��жϵ����
//		case R.id.action_menu_item1:
//			Toast.makeText(MainActivity.this, "����˲˵�һ", Toast.LENGTH_SHORT).show();
//			break;
//		case R.id.action_menu_item2:
//			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();			
//			break;
		//�ö�̬������Ӳ˵��������жϣ�
		case 100:
			Toast.makeText(MainActivity.this, "����˲˵�һ", Toast.LENGTH_SHORT).show();
			break;			
		case 200:
			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			break;			
		case 300:
			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			break;			
		case 400:
			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			break;			
		case 500:
			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			break;			
		case 600:
			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			break;			
		case 700:
//			Toast.makeText(MainActivity.this, "����˲˵���", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(MainActivity.this,SecondActivity.class);
			item.setIntent(intent);
			break;			
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
