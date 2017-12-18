package com.ltsh.webview_02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpConnection;
import org.xml.sax.InputSource;

import android.os.Environment;
import android.util.Log;


public class HttpThread extends Thread {
	
	private String mUrl;
	
	public HttpThread(String url){
		this.mUrl=url;
	}

	@Override
	public void run() {

		try {
			
			Log.i("WebView","Start Download !");
			URL  httpUrl = new URL(mUrl);
			HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			InputStream in = conn.getInputStream();
			File downloadFile;
			File sdFile;
			FileOutputStream out = null;
			
			if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
				downloadFile = Environment.getExternalStorageDirectory();
				sdFile = new File(downloadFile,"test.apk");
				out = new FileOutputStream(sdFile);
			}
			
			byte[] b = new byte[6*1024];
			int len;
			
			while ((len = in.read(b)) != -1) {
				if(out !=null){
					out.write(b,0,len);
				}
			}
			
			if(out!=null){
				out.close();
			}
			
			if(in !=null){
				in.close();
			}
			
			Log.i("WebView","Download Success !");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
