package com.ltsh.topbar;

import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Topbar extends RelativeLayout {
	
	private Button leftButton,rightButton;
	private TextView tvTitile;
	
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;
	
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;
	
	private float titleTextSize;
	private int titleTextColor;
	private String tvTitleText;

	private LayoutParams leftParams,rightParams,titleParams;
	
	private topbarClickListener listener;
	
	public interface topbarClickListener{
		public void leftClick();
		public void rightClick();
	}
	
	public void setOnTopbarClickListener(topbarClickListener listener){
		this.listener = listener;
	}
	
	@SuppressLint("NewApi")
	public Topbar(final Context context, AttributeSet attrs) {
		super(context, attrs);
		
		TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);
		
		//从TypedArray类中取出自定义控件的属性,并赋值给控件变量。
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = ta.getString(R.styleable.Topbar_leftText);
		
		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);
		
		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		tvTitleText = ta.getString(R.styleable.Topbar_titleText);
		//使用完上述变量后回收。
		ta.recycle();

		//初始化三个控件对象。把原有的控件组合，形成一个新的控件Topbar。
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitile =new TextView(context);
		
		//把属性设置给控件。
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
    	leftButton.setText(leftText);
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
 		rightButton.setText(rightText);	
		
		tvTitile.setTextColor(titleTextColor);
		tvTitile.setTextSize(titleTextSize);
		tvTitile.setText(tvTitleText);
		tvTitile.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFFF59563);		//FFF59563

		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		addView(leftButton, leftParams);
		
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightButton, rightParams);

		titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(tvTitile, titleParams);
		
		leftButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Toast.makeText(context, "LTSH LEFT", Toast.LENGTH_LONG).show();
				listener.leftClick();
			}
		});
		
		rightButton.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
//				Toast.makeText(context, "LTSH RIGHT", Toast.LENGTH_LONG).show();
				listener.rightClick();
			}
		});
	}
	//动态控制Topbar；不显示LEFT Button
	public void setLeftIsvisable(boolean flag){
		if (flag){
			leftButton.setVisibility(View.VISIBLE);
		}else{
			leftButton.setVisibility(View.GONE);
		}
	}
	
}
