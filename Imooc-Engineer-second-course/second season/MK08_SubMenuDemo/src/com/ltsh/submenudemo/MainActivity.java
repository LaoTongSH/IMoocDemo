//�����ǣ�Ľ����   ��Android�е���Ϣ��ʾ���˵��붯�� ��  �ڰ�������

package com.ltsh.submenudemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
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
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu) ;
//		SubMenu file = menu.addSubMenu("�ļ�");
//		SubMenu edit = menu.addSubMenu("�༭");	
//		file.setHeaderTitle("�ļ�����");
//		file.setHeaderIcon(R.drawable.ic_launcher);
//		file.add(1,1,1,"�½�");
//		file.add(1,2,1,"��");
//		file.add(1,3,1,"����");
//		
//		edit.setHeaderTitle("�༭����");
//		edit.setHeaderIcon(R.drawable.ic_launcher);
//		edit.add(2,1,1,"����");
//		edit.add(2,2,1,"ճ��");
//		edit.add(2,3,1,"����");
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
//		if(item.getGroupId() == 1){
//			switch (item.getItemId()) {
//			case 1:
//				Toast.makeText(MainActivity.this, "������½� !", Toast.LENGTH_SHORT).show();
//				break;
//			case 2:
//				Toast.makeText(MainActivity.this, "����˴� !", Toast.LENGTH_SHORT).show();
//				break;
//			case 3:
//				Toast.makeText(MainActivity.this, "����˱��� ��", Toast.LENGTH_SHORT).show();
//				break;
//			default:
//				break;
//			}
//		}else if(item.getGroupId() == 2){
//			switch (item.getItemId()) {
//			case 1:
//				Toast.makeText(MainActivity.this, "����˸��� !", Toast.LENGTH_SHORT).show();
//				break;
//			case 2:
//				Toast.makeText(MainActivity.this, "�����ճ�� !", Toast.LENGTH_SHORT).show();
//				break;
//			case 3:
//				Toast.makeText(MainActivity.this, "����˼��� ��", Toast.LENGTH_SHORT).show();
//				break;
//			default:
//				break;
//			}
//		}
		switch (item.getItemId()) {
		case R.id.new_file:
			Toast.makeText(MainActivity.this, "������½� !", Toast.LENGTH_SHORT).show();
			break;
		case R.id.open_file:
			Toast.makeText(MainActivity.this, "����˴� !", Toast.LENGTH_SHORT).show();
			break;
		case R.id.save_file:
			Toast.makeText(MainActivity.this, "����˱��� ��", Toast.LENGTH_SHORT).show();
			break;		
		case R.id.c_edit:
			Toast.makeText(MainActivity.this, "����˸��� !", Toast.LENGTH_SHORT).show();
			break;
		case R.id.v_edit:
			Toast.makeText(MainActivity.this, "�����ճ�� !", Toast.LENGTH_SHORT).show();
			break;
		case R.id.x_edit:
			Toast.makeText(MainActivity.this, "����˼��� ��", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}		
		return super.onOptionsItemSelected(item);
	}
}