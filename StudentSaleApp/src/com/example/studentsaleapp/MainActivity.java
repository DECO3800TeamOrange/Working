package com.example.studentsaleapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import android.os.Bundle;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{
	
	public final static String PHOTO = "com.example.StudentSaleApp.PHOTO";
	public final static String OBJECT_ID = "com.example.StudentSaleApp.OBJECTID";
	
	ImageButton ib;
	ImageView iv;
	Intent i;
	final static int cameraData = 0;
	Bitmap itemPhoto;
	byte[] photoByteStream;
	WallpaperManager wallpaperManager;
	String itemName;
	String itemDescription;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, "gkmWKqQ1qSDSPZeIVoYT7trj1u4OSGhaJCXuQlwF","uHDDpxsL0xkzST0b9Afajty3lZJCQzdSDl9mEW9s"); 
		setContentView(R.layout.activity_main);
		initialize();
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		itemPhoto = BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById (R.id.ivReturnedPic);
		ib = (ImageButton)findViewById(R.id.ibTakePhoto);
		ib.setOnClickListener(this);
	
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibTakePhoto:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
		break;
		case R.id.postItem:
			
		}
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			itemPhoto = (Bitmap)extras.get("data");
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			itemPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);
			photoByteStream = stream.toByteArray();
			iv.setImageBitmap(itemPhoto);
		}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void postItem(View view) {
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDesc = (EditText) findViewById(R.id.itemDescription);
		itemName = editName.getText().toString();    
		itemDescription = editDesc.getText().toString();
		
		ParseObject itemPost = new ParseObject("ItemPost");
		
		

		itemPost.put("ItemName", itemName);
		itemPost.put("ItemDescription", itemDescription);
		//itemPost.put("ItemPhoto", photoByteStream);
		itemPost.saveInBackground();
		
		String itemID = itemPost.getObjectId();
		System.out.println((itemID == null));

		Intent newIntent = new Intent(this, PostedActivity.class);
		newIntent.putExtra(OBJECT_ID, itemID);
		newIntent.putExtra(PHOTO, photoByteStream);
		startActivity(newIntent);
	}
	
	

}
