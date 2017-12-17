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
		//打开本地资源
//		webView.loadUrl("file:///android_asset/index.html"); 
		//打开WEB资源
//		webView.loadUrl("http://www.beidu.com/");
		webView.loadUrl(url);
		
		//可以用下面的方法覆盖由系统或第三方浏览器打开网页的行为，使得网页直接在WebView中打开。
		webView.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				//return super.shouldOverrideUrlLoading(view, url);
				//返回值为true，直接在WebView中打开；否则通过浏览器打开。
				view.loadUrl(url);
				return true;
			}
		});
		//启用支持JavaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		//WebView加载页面时，优先使用缓加载
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		
		//为网页加进度条！
		webView.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				// TODO Auto-generated method stub
				//super.onProgressChanged(view, newProgress);
				//newProgress 1-100之间的整数
				if(newProgress == 100){
					//网页加载完毕
					closeDialog();
				}else{
					//网页加载中。。。。。。。
					openDialog(newProgress);
				}
			}

			private void openDialog(int newProgress) {
				// TODO Auto-generated method stub
				if(dialog==null){
					dialog=new ProgressDialog(MainActivity.this);
					dialog.setTitle("正在加载！");
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
	
	//改写物理按键--返回的逻辑
	@Override
	public boolean onKeyDown(int keyCode , KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if (webView.canGoBack()) {
				webView.goBack();		//返回上一页面
				return true;
			}else{
				System.exit(0);			//退出程序
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
