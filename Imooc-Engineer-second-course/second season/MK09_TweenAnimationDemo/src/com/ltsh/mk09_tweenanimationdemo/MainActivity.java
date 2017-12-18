package com.ltsh.mk09_tweenanimationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_alpha).setOnClickListener(this);
		findViewById(R.id.btn_translate).setOnClickListener(this);
		findViewById(R.id.btn_scale).setOnClickListener(this);
		findViewById(R.id.btn_rotate).setOnClickListener(this);
		findViewById(R.id.btn_set).setOnClickListener(this);
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
		ImageView iv = (ImageView)findViewById(R.id.iv_anim);
		Animation anim = null;
		switch (v.getId()){
		case R.id.btn_alpha:
//			anim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
			anim = getAlpha();
			break;
		case R.id.btn_translate:
//			anim = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
			anim = getTranslate();
			break;		
		case R.id.btn_scale:
//			anim = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
			anim = getScale();
			break;		
		case R.id.btn_rotate:
//			anim = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
			anim = getRotate();
			break;		
		case R.id.btn_set:
//			anim = AnimationUtils.loadAnimation(this, R.anim.anim_set);
			anim = getSet();
			break;		
		default:
			break;
		}
		iv.startAnimation(anim);
		//对动画监听。
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "动画开始了 ！", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "动画重播了 ！", Toast.LENGTH_SHORT).show();				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "动画结束了 ！", Toast.LENGTH_SHORT).show();				
			}
		});
		
	}
	//下面是代码方法实现动画
	//获取渐变动画
	private Animation getAlpha(){
		AlphaAnimation anim = new AlphaAnimation(1, 0);
		anim.setDuration(5000);	//时间
		anim.setRepeatCount(2);	//设置重播次数。
		anim.setFillAfter(true);	//保持动画结束状态
		return anim;
	}
	
	//获取移动动画
	private Animation getTranslate(){
		TranslateAnimation anim = new TranslateAnimation(0, 100, 0, 100);
		anim.setDuration(2000);	//时间
		anim.setFillAfter(true);	//保持动画结束状态
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//加速器
		return anim;
	}	
	
	//获取缩放动画
	private Animation getScale(){
		ScaleAnimation anim = new ScaleAnimation(1, 0.5f, 1, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		anim.setDuration(2000);	//时间
		anim.setFillAfter(true);	//保持动画结束状态
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//加速器
		return anim;
	}
	
	//获取旋转动画
	private Animation getRotate(){
		RotateAnimation anim = new RotateAnimation(0, 270, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		anim.setDuration(2000);	//时间
		anim.setFillAfter(true);	//保持动画结束状态
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//加速器
		return anim;
	}	
	
	//获取综合动画
	private Animation getSet(){
		AnimationSet anim = new AnimationSet(false);
		anim.setDuration(2000);	//时间
		anim.setFillAfter(true);	//保持动画结束状态
		//1.增加 Alpha 动画
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(2000);	//时间
		alpha.setFillAfter(false);	//恢复动画开始状态
		//2.增加 Rotate 动画		
		RotateAnimation rotate = new RotateAnimation(0, 270, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(2000);	//时间
		rotate.setFillAfter(true);	//保持动画结束状态
		rotate.setStartOffset(2000);		//延迟
		
		anim.addAnimation(alpha);	//把二个动画加到一起。
		anim.addAnimation(rotate);
		
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//加速器
		return anim;
	}	
	
}
