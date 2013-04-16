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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PostedActivity extends Activity {
	String itemID;
	String itemName;
	String itemDescription;
	Bitmap photo;
	ParseObject parseObject;
	byte[] photoArray = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_posted);
		
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		photo = BitmapFactory.decodeStream(is);
		
		Intent intent = getIntent();
		itemID = intent.getStringExtra(MainActivity.OBJECT_ID);
		
		
		/*ParseQuery query = new ParseQuery("ItemPost");
		 query.getInBackground(itemID, new GetCallback() {
		     public void done(ParseObject object, ParseException e) {
		         if (e == null) {
		             parseObject = object;
		             System.out.println("parse object was retrieved");
		         } else {
		             parseObject = null;
		             System.out.println("parse object was not retrieved");
		         }
		     }
		 });*/

		ParseQuery query = new ParseQuery("ItemPost");
		System.out.print(itemID);
		try {
			parseObject = query.get(itemID);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
			
		itemName = intent.getStringExtra(MainActivity.ITEM_NAME);
		itemDescription = intent.getStringExtra(MainActivity.ITEM_DESC);
		photoArray = parseObject.getBytes("ItemPhoto");
		photo = BitmapFactory.decodeByteArray(photoArray, 0, photoArray.length);
		
		
		if (photo != null) {
			photoArray = intent.getByteArrayExtra(MainActivity.PHOTO);
			photo = BitmapFactory.decodeByteArray(photoArray, 0, photoArray.length);
		}
		
		TextView textName = (TextView) findViewById(R.id.name);    
		textName.setTextSize(40);    
		if (itemName != null) 
			textName.setText(itemName);
		else
			textName.setText(itemID);
		
		
		TextView textDesc = (TextView) findViewById(R.id.description);
		textDesc.setTextSize(40);    
		textDesc.setText(itemDescription);
		
		
		ImageView imageView = (ImageView) findViewById(R.id.item_photo);
		imageView.setImageBitmap(photo);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_posted, menu);
		return true;
	}

}
