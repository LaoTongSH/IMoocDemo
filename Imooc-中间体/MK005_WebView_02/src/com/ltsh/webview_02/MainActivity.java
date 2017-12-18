package com.ltsh.webview_02;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private WebView mWebView;
	
	private Button mBack, mRefresh;
	private TextView mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mWebView = (WebView)findViewById(R.id.webView1);
		mWebView.loadUrl("http://www.520apk.com/shenghuoyingyong/");
		
		mBack = (Button)findViewById(R.id.IdBack);
		mRefresh = (Button)findViewById(R.id.IdRefresh);
		mTitle = (TextView)findViewById(R.id.textView1);
		
		mWebView.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onReceivedTitle(WebView view, String title) {
				// TODO Auto-generated method stub
				super.onReceivedTitle(view, title);
				mTitle.setText(title);
			}
		});
//		mTitle.setText(getTitle());
		mWebView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
			
		});
		
		mWebView.setDownloadListener(new MyDownload());
		
		mRefresh.setOnClickListener(new MyListener());
		mBack.setOnClickListener(new MyListener());
	}

	class MyListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.IdRefresh:
				mWebView.reload();
				break;
			case R.id.IdBack:
				mWebView.goBack(); // finish();
				break;

			default:
				break;
			}
		}
	}

	class MyDownload implements DownloadListener {

		@Override
		public void onDownloadStart(String url, String userAgent,
				String contentDisposition, String mimetype, long contentLength) {
			// TODO Auto-generated method stub
			
			Log.i("WebView", "URL---->"+url);
			
			if (url.endsWith(".apk")){
				
//				new HttpThread(url).start();
				
				//调用系统的notfikshe
				Uri uri = Uri.parse(url);
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
				
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
