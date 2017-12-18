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
		//�Զ���������
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "������ʼ�� ��", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����ز��� ��", Toast.LENGTH_SHORT).show();				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "���������� ��", Toast.LENGTH_SHORT).show();				
			}
		});
		
	}
	//�����Ǵ��뷽��ʵ�ֶ���
	//��ȡ���䶯��
	private Animation getAlpha(){
		AlphaAnimation anim = new AlphaAnimation(1, 0);
		anim.setDuration(5000);	//ʱ��
		anim.setRepeatCount(2);	//�����ز�������
		anim.setFillAfter(true);	//���ֶ�������״̬
		return anim;
	}
	
	//��ȡ�ƶ�����
	private Animation getTranslate(){
		TranslateAnimation anim = new TranslateAnimation(0, 100, 0, 100);
		anim.setDuration(2000);	//ʱ��
		anim.setFillAfter(true);	//���ֶ�������״̬
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//������
		return anim;
	}	
	
	//��ȡ���Ŷ���
	private Animation getScale(){
		ScaleAnimation anim = new ScaleAnimation(1, 0.5f, 1, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		anim.setDuration(2000);	//ʱ��
		anim.setFillAfter(true);	//���ֶ�������״̬
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//������
		return anim;
	}
	
	//��ȡ��ת����
	private Animation getRotate(){
		RotateAnimation anim = new RotateAnimation(0, 270, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		anim.setDuration(2000);	//ʱ��
		anim.setFillAfter(true);	//���ֶ�������״̬
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//������
		return anim;
	}	
	
	//��ȡ�ۺ϶���
	private Animation getSet(){
		AnimationSet anim = new AnimationSet(false);
		anim.setDuration(2000);	//ʱ��
		anim.setFillAfter(true);	//���ֶ�������״̬
		//1.���� Alpha ����
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(2000);	//ʱ��
		alpha.setFillAfter(false);	//�ָ�������ʼ״̬
		//2.���� Rotate ����		
		RotateAnimation rotate = new RotateAnimation(0, 270, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(2000);	//ʱ��
		rotate.setFillAfter(true);	//���ֶ�������״̬
		rotate.setStartOffset(2000);		//�ӳ�
		
		anim.addAnimation(alpha);	//�Ѷ��������ӵ�һ��
		anim.addAnimation(rotate);
		
		anim.setInterpolator(this,android.R.anim.accelerate_interpolator);	//������
		return anim;
	}	
	
}
