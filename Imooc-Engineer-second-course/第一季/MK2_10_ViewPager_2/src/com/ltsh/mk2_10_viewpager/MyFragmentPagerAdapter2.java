package com.ltsh.mk2_10_viewpager;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;


public class MyFragmentPagerAdapter2 extends FragmentStatePagerAdapter {

	private List<Fragment>flagList;
	private List<String>titleList;
	public MyFragmentPagerAdapter2(FragmentManager fm,List<Fragment>flagList,List<String>titleList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.flagList=flagList;
		this.titleList=titleList;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
//		return null;
		return flagList.get(arg0);
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
//		return 0;
		return flagList.size();
	}
	
	//创建项目
	@Override
	public Object instantiateItem(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		return super.instantiateItem(arg0, arg1);
	}

	//销毁项目
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	}
}
