package com.ltsh.mk2_02_listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnScrollListener{
	
	private ListView listView;
	private ArrayAdapter<String>arr_adapter;
	private SimpleAdapter simp_adapter;
	private List<Map<String,Object>>dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		listView=(ListView)findViewById(R.id.listView);
		//1.新建一个数据适配器
		//2.适配器加载数据源
		String[]arr_data={"慕课网1","慕课网2" ,"慕课网3" ,"慕课网4" ,"慕课网5" };
		dataList=new ArrayList<Map<String,Object>>();
		arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
		simp_adapter=new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","text"}, new int []{R.id.pic,R.id.text});
		//3.视图(ListView)加载适配器
//		listView.setAdapter(arr_adapter);
		listView.setAdapter(simp_adapter);
		listView.setOnItemClickListener(this);
		listView.setOnScrollListener(this);
		
	}
	
	private List<Map<String,Object>> getData(){
		
		for(int i=0;i<20;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text","慕课网"+i);
			dataList.add(map);
		}
		return dataList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	//监听器方法。
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Log.i("Main","用户在手指离开屏幕之前，由于用力滑了一下，视图仍依靠惯性继续滑动");
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text", "增加项");
			dataList.add(map);
			simp_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("Main","视图已经停止滑动");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("Main","手指没有离开屏幕，视图正在滑动");
			break;
		}
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String text=listView.getItemAtPosition(position)+"";
		Toast.makeText(this, "position="+position+" text="+text, Toast.LENGTH_SHORT).show();
		
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	