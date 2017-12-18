package com.ltsh.webview_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private WebView webView;
	private Button mBack, mRefresh;
	private TextView mTitle;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView = (WebView)findViewById(R.id.webView1);
		webView.loadUrl("http://www.baidu.com");
		
		mBack = (Button)findViewById(R.id.IdBack);
		mRefresh = (Button)findViewById(R.id.IdRefresh);
		mTitle = (TextView)findViewById(R.id.textView1);
		
		webView.setWebChromeClient(new WebChromeClient(){
			
			@Override
			public void onReceivedTitle(WebView view, String title) {
				// TODO Auto-generated method stub
				super.onReceivedTitle(view, title);
				mTitle.setText(title);
			}
			
		});
//		mTitle.setText(getTitle());
		webView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
			
		});
		
		mRefresh.setOnClickListener(new MyListener());
		mBack.setOnClickListener(new MyListener());
		
	}
	
	class MyListener implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			switch (v.getId()) {
			case R.id.IdRefresh:
				webView.reload();
				break;
			case R.id.IdBack:
				webView.goBack();	//finish();
				break;

			default:
				break;
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
