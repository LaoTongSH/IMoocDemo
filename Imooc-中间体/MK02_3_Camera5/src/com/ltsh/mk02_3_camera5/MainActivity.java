package com.ltsh.mk02_3_camera5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static int REQ_1 = 1;
	private static int REQ_2 = 2;
	private ImageView mImageView;
	private String mFilePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mImageView = (ImageView) findViewById(R.id.iv);
		//24小时制  		
        SimpleDateFormat dateFormat24 = new SimpleDateFormat("yyyyMMddHHmmss");   //"yyyy-MM-dd HH:mm:ss");
        //12小时制  
//      SimpleDateFormat dateFormat12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        
        //获取SD卡根目录
		mFilePath = Environment.getExternalStorageDirectory().getPath();
//		mFilePath = mFilePath + "/" + "temp.png";
		mFilePath = mFilePath + "/" + dateFormat24.format(new Date()) + ".png";
	}
	
	public void startCamera1(View view){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, REQ_1);
	}
	
	public void startCamera2(View view){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		Uri photoUri = Uri.fromFile(new File(mFilePath));
		intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
		startActivityForResult(intent, REQ_2);
	}
	
	public void customCamera(View view){
		startActivity(new Intent(this,CustomCamera.class));
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			if (requestCode == REQ_1){
				Bundle bundle = data.getExtras();
				Bitmap bitmap = (Bitmap) bundle.get("data");
				mImageView.setImageBitmap(bitmap);
			}else if(requestCode == REQ_2){
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(mFilePath);
					Bitmap bitmap = BitmapFactory.decodeStream(fis);
					mImageView.setImageBitmap(bitmap);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
