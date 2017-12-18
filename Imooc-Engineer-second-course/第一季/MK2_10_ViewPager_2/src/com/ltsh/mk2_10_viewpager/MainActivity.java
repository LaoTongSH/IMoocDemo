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
		 * ͨ��View����ȥ��Ϊ ViewPager ������Դ
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
		 * ͨ�� Fragment ��Ϊ ViewPager ������Դ
		 */
		flagList = new ArrayList<Fragment>();
		flagList.add(new Fragment1());
		flagList.add(new Fragment2());
		flagList.add(new Fragment3());
		flagList.add(new Fragment4());
		
		//Ϊҳ�����ñ���
		titleList = new ArrayList<String>();
		titleList.add("��һҳ");
		titleList.add("�ڶ�ҳ");
		titleList.add("����ҳ");
		titleList.add("����ҳ");
		
		//ΪPagerTabStrip ��������
		tab=(PagerTabStrip) findViewById(R.id.tab);		
		tab.setBackgroundColor(Color.YELLOW);
		tab.setTextColor(Color.RED);
		tab.setDrawFullUnderline(false);
		tab.setTabIndicatorColor(Color.GREEN);
		
		//��ʼ��ҳ��
		pager=(ViewPager) findViewById(R.id.pager);
		//����PagerAdapter��������
		MyPagerAdapter adapter = new MyPagerAdapter(viewList,titleList);
		//����������
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
		Toast.makeText(this, "���ǵ�"+(arg0+1)+"������", Toast.LENGTH_SHORT).show();		
	}
}
