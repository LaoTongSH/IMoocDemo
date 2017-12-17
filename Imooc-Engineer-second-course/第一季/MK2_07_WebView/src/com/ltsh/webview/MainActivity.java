package com.ltsh.webview;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	private String url = "http://2014.qq.com/";
	private WebView webView;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web);
		
//		Uri uri = Uri.parse(url);
//		Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//		startActivity(intent);
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		webView =(WebView)findViewById(R.id.webview);
		//�򿪱�����Դ
//		webView.loadUrl("file:///android_asset/index.html"); 
		//��WEB��Դ
//		webView.loadUrl("http://www.beidu.com/");
		webView.loadUrl(url);
		
		//����������ķ���������ϵͳ����������������ҳ����Ϊ��ʹ����ҳֱ����WebView�д򿪡�
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				//return super.shouldOverrideUrlLoading(view, url);
				//����ֵΪtrue��ֱ����WebView�д򿪣�����ͨ��������򿪡�
				view.loadUrl(url);
				return true;
			}
		});
		//����֧��JavaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		//WebView����ҳ��ʱ������ʹ�û�����
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
		//Ϊ��ҳ�ӽ�������
		webView.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				//super.onProgressChanged(view, newProgress);
				//newProgress 1-100֮�������
				if(newProgress == 100){
					//��ҳ�������
					closeDialog();
				}else{
					//��ҳ�����С�������������
					openDialog(newProgress);
				}
			}

			private void openDialog(int newProgress) {
				// TODO Auto-generated method stub
				if(dialog==null){
					dialog=new ProgressDialog(MainActivity.this);
					dialog.setTitle("���ڼ��أ�");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				}else{
					dialog.setProgress(newProgress);
				}
				
			}

			private void closeDialog() {
				// TODO Auto-generated method stub
				if(dialog!=null&&dialog.isShowing()){
					dialog.dismiss();
					dialog=null;
				}
				
			}
			
		});
	}
	
	//��д������--���ص��߼�
	@Override
	public boolean onKeyDown(int keyCode , KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if (webView.canGoBack()) {
				webView.goBack();		//������һҳ��
				return true;
			}else{
				System.exit(0);			//�˳�����
			}
		}
		
		return super.onKeyDown(keyCode, event);
		//return false;
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
