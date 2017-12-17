package com.ltsh.mk1_21_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	Button btn_0;		//0���ְ�ť
	Button btn_1;		//1���ְ�ť
	Button btn_2;		//2���ְ�ť
	Button btn_3;		//3���ְ�ť
	Button btn_4;		//4���ְ�ť
	Button btn_5;		//5���ְ�ť
	Button btn_6;		//6���ְ�ť
	Button btn_7;		//7���ְ�ť
	Button btn_8;		//8���ְ�ť
	Button btn_9;		//9���ְ�ť
	Button btn_point;		//С�������ְ�ť
	Button btn_clear;		//�����ť
	Button btn_del;			//ɾ����ť
	Button btn_divide;		//������ť
	Button btn_multiply;	//�˷���ť
	Button btn_less;			//������ť
	Button btn_add;			//�ӷ���ť
	Button btn_equal;		//�ȺŰ�ť
	EditText et_input;		//��ʾ��
	boolean clear_flag;		//��ձ�ʶ
	boolean operation_flag=false;	//�����ʶ
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//���³�ʼ����ť����ʾ��
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
		
		//��Ӱ�ť����¼���
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

		String str = et_input.getText().toString();		//ȡ����ʾ������
//		String str = et_input.getTag().toString();		//ȡ����ʾ������
		
		/**
		 *  �ж����ּ���С��������º�Ĵ���ֱ�ӰѸü�ֵ�͵���ʾ��
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
			
		//�ĸ������������жϺʹ���
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

		//�����ť�������
		case R.id.btn_clear:
			clear_flag =false;
			str = "";
			et_input.setText("");
			break;

		//ɾ����ť�������
		case R.id.btn_del:
			if(clear_flag){
				clear_flag =false;
				str = "";
				et_input.setText("");
			}else if(str!=null&&!str.equals("")){
				et_input.setText(str.substring(0, str.length()-1));
			}
			break;
		//�ȺŰ�ť�ĵ������	
		case R.id.btn_equal:
			getResult();
			break;
		}
	}
	
	/**
	 * �ȺŰ�ť���º��������������̡�
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
		
		String s1 = exp.substring(0,exp.indexOf(" "));		//��һ�����ݣ���һ���ո���ߵ��ַ���.
		String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);	//������������ո�֮����ַ���
		String s2 = exp.substring(exp.indexOf(" ")+3);	//�ڶ������ݣ���2���ո���ұߵ��ַ�����
		
		//�������ݶ���Ϊ�մ���
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if(op.equals("��")){
				resul = d1+d2;
			}else if(op.equals("��")){
				resul = d1-d2;
			}else if(op.equals("��")){
				resul = d1*d2;
			}else if(op.equals("��")){
				if(d2==0){
					resul = 0;
				}else{
				resul = d1/d2;
			    }
			}
			if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("��")){
				int r=(int)resul;
				et_input.setText(r+"");
			}else{
				et_input.setText(resul+"");				
			}
			//��һ�����ݲ�Ϊ�գ��ڶ�������Ϊ�գ������㣬ֱ�Ӹ������
		}else if(!s1.equals("")&&s2.equals("")){
			et_input.setText(exp);	
			
			//��һ������Ϊ�գ��ڶ������ݲ�Ϊ�գ���Ҫ���㣡
		}else if(s1.equals("")&&!s2.equals("")){
			
			double d2 = Double.parseDouble(s2);
			if(op.equals("��")){
				resul = 0+d2;
			}else if(op.equals("��")){
				resul = 0-d2;
			}else if(op.equals("��")){
				resul = 0;
			}else if(op.equals("��")){
				resul = 0;
			}
			if(!s2.contains(".")){
				int r=(int)resul;
				et_input.setText(r+"");
			}else{
				et_input.setText(resul+"");				
			}
			//�������ݶ�Ϊ�գ����Ϊ�գ�
		}else{
			et_input.setText("");						
		}
		
	}
}
