package com.ltsh.mk2_08_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener{

	private RadioGroup group;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bottom);
		group = (RadioGroup) findViewById(R.id.radiogroup);
		group.setOnCheckedChangeListener(this);
		
	}


	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		switch (checkedId) {
		case R.id.first: {
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);
			break;

		}
		case R.id.second: {
            MyFragment2 fragment2=new MyFragment2();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            /**
             * containerViewId：布局的Id
             * fragment：传进来Fragment的对象。
             */
            beginTransaction.add(R.id.frame, fragment2);
            beginTransaction.addToBackStack(null);
            beginTransaction.commit();
			break;
		}
		case R.id.thrid: {



			break;
		}
		case R.id.fourth: {


			break;
		 }
		}
		
	}
	
	
	
	

}
