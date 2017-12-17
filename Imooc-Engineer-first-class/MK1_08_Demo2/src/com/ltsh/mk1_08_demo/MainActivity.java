package com.ltsh.mk1_08_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {

	private AutoCompleteTextView acTextView;
	private String[] res = { "beijing1", "beijing2", "beijing3", "beijing4" ,"shanghai1","shanghai2","shanghai3"};
	
	private MultiAutoCompleteTextView macTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/**
		 *  ��һ���������ؼ��������Ҫƥ����������顣
		 *  �ڶ�������ʼ���ؼ��� 
		 *  ������������һ�����������󲢳�ʼ���� 
		 *  ���Ĳ������������Ϳؼ��󶨡�
		 */
		acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, res);
		acTextView.setAdapter(adapter);

		/**
		 * ��һ���������ؼ��������Ҫƥ����������顣 
		 * �ڶ�������ʼ���ؼ��� 
		 * ������������һ�����������󲢳�ʼ���� 
		 * ���Ĳ������������Ϳؼ��󶨡�
		 * ���岽�����÷ָ�����
		 */

		macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		macTextView.setAdapter(adapter);
		//�����Զ���Ϊ�ָ��������ķ��š�
		macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
