package com.ltsh.mk2_09_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment3 extends Fragment {

	private TextView tv;

	// ����Fragment����>��Ļ��������>��Ļ��������>
	//�л���������Fragment����>�ص����桪��>�ص�Ӧ�á���>�˳�Fragment
	/**
	 * ÿ�δ����������Fragment��View���ʱ�ص��÷���
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment2, container, false);
		TextView tv = (TextView) view.findViewById(R.id.text);
		tv.setText("��һ��Fragment");
		Log.i("Main", "Fragment1---onCreateView()");
		return view;
	}

	/**
	 * ��Fragment����ӵ�Activityʱ���ص��������������ֻ����һ��
	 */
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.i("Main", "Fragment1---onAttach()");

	}

	/**
	 * ����Fragmentʱ��ص���ֻ�����һ��
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("Main", "Fragment1---onCreate()");

	}

	/**
	 * ��Fragment���ڵ�Activty������ɺ����
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.i("Main", "Fragment1---onActivityCreated()");

	}

	/**
	 * ����Fragment
	 * 
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Main", "Fragment1---onStart()");

	}

	/**
	 * �ָ�Fragmentʱ�ᱻ�ص�������onStart������������һ�������onResume()����
	 */
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("Main", "Fragment1---onResume()");

	}

	/**
	 * ��ͣFragment
	 */
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("Main", "Fragment1---onPause()");

	}

	/**
	 * ֹͣFragment
	 */
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("Main", "Fragment1---onStop()");

	}

	/**
	 * ����Fragment��������View���ʱ
	 */
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.i("Main", "Fragment1---onDestroyView()");

	}

	/**
	 * ����Fragmentʱ�ᱻ�ص�
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("Main", "Fragment1---onDestroy()");

	}

	/**
	 * Fragment��Activity��ɾ��ʱ��ص��÷����������������ֻ�����һ��
	 */
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.i("Main", "Fragment1---onDetach()");
	}
}