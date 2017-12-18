package com.ltsh.mk2_10_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnPageChangeListener{

	private List<View>viewList;
	private ViewPager pager;
	private PagerTabStrip tab;
	private List<String>titleList;
	private List<Fragment>flagList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		viewList=new ArrayList<View>();
		
		/**
		 * 通过View对象去作为 ViewPager 的数据源
		 */
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);

		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		
		/**
		 * 通过 Fragment 作为 ViewPager 的数据源
		 */
		flagList = new ArrayList<Fragment>();
		flagList.add(new Fragment1());
		flagList.add(new Fragment2());
		flagList.add(new Fragment3());
		flagList.add(new Fragment4());
		
		//为页卡设置标题
		titleList = new ArrayList<String>();
		titleList.add("第一页");
		titleList.add("第二页");
		titleList.add("第三页");
		titleList.add("第四页");
		
		//为PagerTabStrip 设置属性
		tab=(PagerTabStrip) findViewById(R.id.tab);		
		tab.setBackgroundColor(Color.YELLOW);
		tab.setTextColor(Color.RED);
		tab.setDrawFullUnderline(false);
		tab.setTabIndicatorColor(Color.GREEN);
		
		//初始化页卡
		pager=(ViewPager) findViewById(R.id.pager);
		//创建PagerAdapter适配器：
		MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);
		//加载适配器
//		pager.setAdapter(adapter);
		
		MyFragmentPagerAdapter adapter2 =new MyFragmentPagerAdapter(getSupportFragmentManager(), flagList, titleList);
//		pager.setAdapter(adapter2);
		
		MyFragmentPagerAdapter2 adapter3 = new MyFragmentPagerAdapter2(getSupportFragmentManager(), flagList, titleList);
		pager.setAdapter(adapter3);	
		pager.setOnPageChangeListener(this);		
		
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "这是第"+(arg0+1)+"个界面", Toast.LENGTH_SHORT).show();		
	}
}
