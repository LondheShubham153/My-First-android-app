package com.example.demo1;
import java.io.IOException;

import com.example.demo1.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class Camera extends Activity implements View.OnClickListener
{
	View v ;
	ImageButton ib;
	Button b;
	ImageView iv;
	Intent i;
	int camRes;
	int camData;
	Bitmap bmp;
 @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.photo);
	initialize();
}
private void initialize()
{
	iv = (ImageView)findViewById(R.id.ivReturnPic);
	ib = (ImageButton)findViewById(R.id.ibTakePic);
	b = (Button)findViewById(R.id.bSetWall);
	b.setOnClickListener(this);
	ib.setOnClickListener(this);
	
}
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	switch (v.getId()) {
	case R.id.bSetWall :
		try {
			getApplicationContext().setWallpaper(bmp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
	case R.id.ibTakePic :
	i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		
		startActivityForResult(i, camData);
		break;
	}
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	
	if(resultCode == RESULT_OK)
	{
		Bundle extra = data.getExtras();
		bmp = (Bitmap)extra.get("data");
		iv.setImageBitmap(bmp);
	}
}
}
