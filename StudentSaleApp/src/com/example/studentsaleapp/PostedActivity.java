package com.example.studentsaleapp;

import java.io.InputStream;

import com.parse.*;


import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class PostedActivity extends Activity {
	String itemID;
	String itemName;
	String itemDescription;
	Bitmap photo;
	ParseObject parseObject;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_posted);
		
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		photo = BitmapFactory.decodeStream(is);
		
		byte[] photoArray = null;
		
		Intent intent = getIntent();
		itemID = intent.getStringExtra(MainActivity.OBJECT_ID);
		
		ParseQuery query = new ParseQuery("ItemPost");
		query.getInBackground(itemID, new GetCallback() {
			public void done(ParseObject object, ParseException e) {    
				if (e == null) {      
					// object will be your game score  
					parseObject = object;
					} else {      
						// something went wrong    
						}  }});
			
		itemName = parseObject.getString("ItemName");
		itemDescription = parseObject.getString("ItemDescription");
		photoArray = parseObject.getBytes("ItemPhoto");
		
		
		if (!(intent.getByteArrayExtra(MainActivity.PHOTO) == null)) {
			photoArray = intent.getByteArrayExtra(MainActivity.PHOTO);
			photo = BitmapFactory.decodeByteArray(photoArray, 0, photoArray.length);
		}
		
	
		TextView textName = new TextView(this);    
		textName.setTextSize(40);    
		textName.setText(itemName);
		
		TextView textDesc = new TextView(this); 
		textDesc.setTextSize(40);    
		textDesc.setText(itemDescription);
		
		ImageView imageView = new ImageView(this);
		imageView.setImageBitmap(photo);
		
		setContentView(imageView);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_posted, menu);
		return true;
	}

}
