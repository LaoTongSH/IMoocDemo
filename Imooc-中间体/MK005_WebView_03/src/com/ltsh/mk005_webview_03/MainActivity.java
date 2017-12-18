package com.ltsh.mk005_webview_03;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

	private WebView webView;
	private TextView mTextView_Error;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webView = (WebView)findViewById(R.id.webView1);
		webView.loadUrl("http://www.baidu.com");

		mTextView_Error = (TextView) findViewById(R.id.textView_error);
		
		webView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				
				view.loadUrl(url);
				return super.shouldOverrideUrlLoading(view, url);
			}
			
			@Override
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				// TODO Auto-generated method stub
				super.onReceivedError(view, errorCode, description, failingUrl);
//				view.loadUrl("file:///android_asset/error.html");
				
				mTextView_Error.setText("404 ERROR");
				webView.setVisibility(View.GONE);
			}
		});
	}
}
