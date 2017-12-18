package com.ltsh.mk02_3_camera5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

public class ResultAty extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		String path = getIntent().getStringExtra("picPath");
		ImageView imageView = (ImageView) findViewById(R.id.pic);
		try {
			FileInputStream fis = new FileInputStream(path);
			Bitmap bitmap = BitmapFactory.decodeFile(path);
			Matrix matrix = new Matrix();
			matrix.setRotate(90);
			bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
			imageView.setImageBitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Bitmap bitmap = BitmapFactory.decodeFile(path);
//		imageView.setImageBitmap(bitmap);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
