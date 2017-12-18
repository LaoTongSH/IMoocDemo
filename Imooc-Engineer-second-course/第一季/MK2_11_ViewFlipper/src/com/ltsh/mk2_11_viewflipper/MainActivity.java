package com.ltsh.mk2_11_viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private ViewFlipper flipper;
	private int [] resID = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
	private float startX;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		flipper = (ViewFlipper) findViewById(R.id.flipper);
		//��̬���뷽ʽΪViewFlipper������View
		for(int i=0;i<resID.length;i++){
			flipper.addView(getImageView(resID[i]));
		}
		//����flipper ���������Զ����š�
//		flipper.setInAnimation(this, R.anim.left_in);
//		flipper.setOutAnimation(this, R.anim.left_out);
//		flipper.setFlipInterval(3000);
//		flipper.startFlipping();
	}
	
	private ImageView getImageView(int resId){
		ImageView image = new ImageView(this);
//		image.setImageResource(resId);
		image.setBackgroundResource(resId);
		return image;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction()){
		//��ָ���£�
		case MotionEvent.ACTION_DOWN:{
			startX = event.getX();
			break;		
		}		
		//��ָ������
		case MotionEvent.ACTION_MOVE:{
			//���һ�������ǰһҳͼƬ��
			if(event.getX()-startX>100){
				flipper.setInAnimation(this, R.anim.left_in);
				flipper.setOutAnimation(this, R.anim.left_out);
				flipper.showPrevious();
			}
			//���󻬶�������һҳͼƬ��
			if(startX-event.getX()>100){
				flipper.setInAnimation(this, R.anim.right_in);
				flipper.setOutAnimation(this, R.anim.right_out);
				flipper.showNext();	
			}
			break;					
		}
		//��ָ̧��
		case MotionEvent.ACTION_UP:{
			break;			
		}	
		
		}		
		return super.onTouchEvent(event);
	}
}
