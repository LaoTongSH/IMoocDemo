package com.ltsh.mk1_21_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button btn_0;		//0数字按钮
	Button btn_1;		//1数字按钮
	Button btn_2;		//2数字按钮
	Button btn_3;		//3数字按钮
	Button btn_4;		//4数字按钮
	Button btn_5;		//5数字按钮
	Button btn_6;		//6数字按钮
	Button btn_7;		//7数字按钮
	Button btn_8;		//8数字按钮
	Button btn_9;		//9数字按钮
	Button btn_point;		//小数点数字按钮
	Button btn_clear;		//清除按钮
	Button btn_del;			//删除按钮
	Button btn_divide;		//除法按钮
	Button btn_multiply;	//乘法按钮
	Button btn_less;			//减法按钮
	Button btn_add;			//加法按钮
	Button btn_equal;		//等号按钮
	EditText et_input;		//显示屏
	boolean clear_flag;		//清空标识
	boolean operation_flag=false;	//运算标识
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//以下初始化按钮和显示屏
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_multiply = (Button) findViewById(R.id.btn_multiply);
		btn_less = (Button) findViewById(R.id.btn_less);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		
		et_input = (EditText) findViewById(R.id.et_input);
		
		//添加按钮点击事件。
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		
		btn_point.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_less.setOnClickListener(this);
		btn_add.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		String str = et_input.getText().toString();		//取出显示屏内容
//		String str = et_input.getTag().toString();		//取出显示屏内容
		
		/**
		 *  判断数字键，小数点键按下后的处理：直接把该键值送到显示屏
		 */
		switch (v.getId()) {
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			if(clear_flag){
				clear_flag =false;
				str = "";
				et_input.setText("");
			}
			
			et_input.setText(str+((Button)v).getText());
			break;
			
		//四个运算键点击的判断和处理
		case R.id.btn_add:
		case R.id.btn_less:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if(!operation_flag){
			if(clear_flag){
				clear_flag =false;
				str = "";
				et_input.setText("");
			}
			operation_flag=true;
			et_input.setText(str+" "+((Button)v).getText()+" ");
		    }
			break;

		//清除按钮点击处理
		case R.id.btn_clear:
			clear_flag =false;
			str = "";
			et_input.setText("");
			break;

		//删除按钮点击处理
		case R.id.btn_del:
			if(clear_flag){
				clear_flag =false;
				str = "";
				et_input.setText("");
			}else if(str!=null&&!str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		//等号按钮的点击处理！	
		case R.id.btn_equal:
			getResult();
			break;
		}
	}
	
	/**
	 * 等号按钮按下后的运算结果处理过程。
	 */
	private void getResult(){ operation_flag=false;
		String exp = et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		
		if(clear_flag){
			clear_flag = false;
			return;
		}
		
		clear_flag = true;
		double resul = 0;
		
		String s1 = exp.substring(0,exp.indexOf(" "));		//第一组数据：第一个空格左边的字符串.
		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);	//运算符：二个空格之间的字符。
		String s2 = exp.substring(exp.indexOf(" ")+3);	//第二组数据：第2个空格符右边的字符串。
		
		//二组数据都不为空处理：
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if(op.equals("＋")){
				resul = d1+d2;
			}else if(op.equals("－")){
				resul = d1-d2;
			}else if(op.equals("×")){
				resul = d1*d2;
			}else if(op.equals("÷")){
				if(d2==0){
					resul = 0;
				}else{
				resul = d1/d2;
			    }
			}
			if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
				int r=(int)resul;
				et_input.setText(r+"");
			}else{
				et_input.setText(resul+"");				
			}
			//第一组数据不为空，第二组数据为空：不运算，直接给结果。
		}else if(!s1.equals("")&&s2.equals("")){
			et_input.setText(exp);	
			
			//第一组数据为空，第二组数据不为空：需要运算！
		}else if(s1.equals("")&&!s2.equals("")){
			
			double d2 = Double.parseDouble(s2);
			if(op.equals("＋")){
				resul = 0+d2;
			}else if(op.equals("－")){
				resul = 0-d2;
			}else if(op.equals("×")){
				resul = 0;
			}else if(op.equals("÷")){
				resul = 0;
			}
			if(!s2.contains(".")){
				int r=(int)resul;
				et_input.setText(r+"");
			}else{
				et_input.setText(resul+"");				
			}
			//二组数据都为空，结果为空！
		}else{
			et_input.setText("");						
		}
		
	}
}
