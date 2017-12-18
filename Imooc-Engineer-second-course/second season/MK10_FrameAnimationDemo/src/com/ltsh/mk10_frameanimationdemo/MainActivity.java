package com.ltsh.mk10_frameanimationdemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{

	AnimationDrawable anim_draw;
//	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView anim_iv = (ImageView)findViewById(R.id.iv_anim);
		
		//用 xml布局文件方法，把  fram_list.xml 设置到 ImageView上了。
//		anim_iv.setBackgroundResource(R.drawable.fram_list);				
//		anim_draw = (AnimationDrawable)anim_iv.getBackground();
//		anim_draw.start();
//		anim_draw.stop();
		
		//用代码方法实现动画，添加
		anim_draw = new AnimationDrawable();
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f01), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f02), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f03), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f04), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f05), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f06), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f07), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f08), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f09), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f10), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f11), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f12), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f13), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f14), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f15), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f16), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f17), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f18), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f19), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f20), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f21), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f22), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f23), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f24), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f25), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f26), 60);
		anim_draw.addFrame(getResources().getDrawable(R.drawable.fat_po_f27), 60);
		
		anim_draw.setOneShot(false);
		
		anim_iv.setBackground(anim_draw);
		
		findViewById(R.id.btn_start).setOnClickListener(this);
		findViewById(R.id.btn_stop).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_start:
			 anim_draw.start();
			break;
		case R.id.btn_stop:
			anim_draw.stop();
			break;
		default:
			break;
		}
	}
}
