package com.ltsh.mk2_10_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainActivity extends Activity {

	private List<View>viewList;
	private ViewPager pager;
	private PagerTabStrip tab;
	private List<String>titleList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		viewList=new ArrayList<View>();
		
		/**
		 * ͨ��View����ȥ��Ϊ ViewPager������Դ
		 */
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);

		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		
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
		pager.setAdapter(adapter);
	}
}
