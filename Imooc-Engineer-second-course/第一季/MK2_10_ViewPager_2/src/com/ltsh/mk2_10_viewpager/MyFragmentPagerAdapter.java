package com.ltsh.mk2_10_viewpager;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment>flagList;
	private List<String>titleList;
	public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment>flagList,List<String>titleList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.flagList=flagList;
		this.titleList=titleList;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
///		return null;
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
///		return 0;
		return flagList.size();
	}

}
