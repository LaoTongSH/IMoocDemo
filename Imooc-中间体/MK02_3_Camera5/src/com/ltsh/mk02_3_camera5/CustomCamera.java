package com.ltsh.mk02_3_camera5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.CursorJoiner.Result;
import android.graphics.ImageFormat;
import android.hardware.Camera;
//import android.graphics.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 *
 * @author LaoTong_ausu
 */
public class CustomCamera extends Activity implements SurfaceHolder.Callback{
	private Camera mCamera;
	private SurfaceView mPreview;
	private SurfaceHolder mHolder;
	private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
		
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			File tempFile = new File("/sdcard/temp.png");
			try {
				FileOutputStream fos = new FileOutputStream(tempFile);
				fos.write(data);
				fos.close();
				Intent intent = new Intent(CustomCamera.this,ResultAty.class);
				intent.putExtra("picPath", tempFile.getAbsolutePath());
				startActivity(intent);
				CustomCamera.this.finish();
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom);
		mPreview = (SurfaceView) findViewById(R.id.preview);
		mHolder = mPreview.getHolder();
		mHolder.addCallback(this);
		mPreview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCamera.autoFocus(null);
			}
		});
	}
	
	public void capture(View view){
		Camera.Parameters parameters = mCamera.getParameters();
		parameters.setPictureFormat(ImageFormat.JPEG);
		parameters.setPreviewSize(800, 400);
		parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
		mCamera.autoFocus(new Camera.AutoFocusCallback() {
			
			@Override
			public void onAutoFocus(boolean success, Camera camera) {
				if (success){
					mCamera.takePicture(null, null, mPictureCallback);
				}
				
			}
		});
	}
	
	//有关 Activity 生命周期的方法：
	//Activity 准备与用户交互时，调用本法。
	@Override
	protected void onResume() {
		super.onResume();
		if (mCamera == null){
			mCamera = getCamera();
			if (mHolder != null){
				setStartPreview(mCamera, mHolder);
			}
		}
	}
	
	//系统启动另一个 Acticity 时，启动本法
	@Override
	protected void onPause() {
		super.onPause();
		releaseCamera();
	}
	
	
	/**
	 * 获取 Camera 对象
	 * @return
	 */
	private Camera getCamera(){
		Camera camera;
		try {
			camera = Camera.open();
		} catch (Exception e) {
			camera = null;
			e.printStackTrace();
		}
		return camera;
	}

	/**
	 * 开始预览相片内容
	 */
	private void setStartPreview(Camera camera,SurfaceHolder holder){
		try {
			camera.setPreviewDisplay(holder);
			//旋转相机90度
			camera.setDisplayOrientation(90);
			camera.startPreview();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放相片占用的资源
	 */
	private void releaseCamera(){
		if (mCamera != null){
			mCamera.setPreviewCallback(null);
			mCamera.stopPreview();
			mCamera.release();
			mCamera = null;
		}
	}

	//有关接口：SurfaceHolder.Callback 的三个方法。
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		setStartPreview(mCamera, mHolder);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		mCamera.stopPreview();
		setStartPreview(mCamera, mHolder);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		releaseCamera();
	}
}
