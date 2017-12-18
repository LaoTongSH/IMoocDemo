package com.ltsh.mk02_3_camera;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}
	
	public void startCamera(View view){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivity(intent);
	}




}
