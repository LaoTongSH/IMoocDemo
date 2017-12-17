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
		 *  第一步：声明控件对象和需要匹配的数据数组。
		 *  第二步：初始化控件。 
		 *  第三步：声明一个适配器对象并初始化。 
		 *  第四步：将适配器和控件绑定。
		 */
		acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, res);
		acTextView.setAdapter(adapter);

		/**
		 * 第一步：声明控件对象和需要匹配的数据数组。 
		 * 第二步：初始化控件。 
		 * 第三步：声明一个适配器对象并初始化。 
		 * 第四步：将适配器和控件绑定。
		 * 第五步：设置分隔符。
		 */

		macTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		macTextView.setAdapter(adapter);
		//设置以逗号为分隔符结束的符号。
		macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	}
}
