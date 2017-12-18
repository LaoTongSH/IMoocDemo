package com.ltsh.mk2_10_viewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {

	
	private List<View>viewList;
	private List<String>titleList;

	public MyPagerAdapter(List<View>viewList,List<String>titleList)
	{
		this.viewList=viewList;
		this.titleList=titleList;
	}
	
	//返回所有视图的数量	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewList.size();
	}

	//判断视图是否由对象产生
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
//		return false;
		return arg0==arg1;		//官方写法
	}
	
	//实例化页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	// TODO Auto-generated method stub
    	container.addView(viewList.get(position));
    	return viewList.get(position);
    }
    
    //删除页面
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	container.removeView(viewList.get(position));
    }
    /**
     * 设置页卡的标题
     */
    @Override
    public CharSequence getPageTitle(int position) {
    	// TODO Auto-generated method stub
    	return titleList.get(position);
    }


}
