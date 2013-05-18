package com.example.studentsaleapp;

import java.util.List;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Item extends Activity {
	String ID;

	@Override
	/*
	 * onCreate(Bundle)
	 * 
	 * Input:	Bundle object
	 * Return:	None
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		ID = intent.getStringExtra("ID");
		setContentView(R.layout.activity_item);
		displayItem();
	}

	public void displayItem() {
		// TODO Auto-generated method stub
		ParseQuery query = new ParseQuery("ItemPost");
		try {
			ParseObject item = query.get(ID);
			TextView textName = (TextView) findViewById(R.id.textView1);
			textName.setText(item.getString("ItemName"));
			TextView textPrice = (TextView) findViewById(R.id.textView2);
			textPrice.setText("$"+item.getInt("Price"));
			TextView textDesc = (TextView) findViewById(R.id.textView3);
			textDesc.setText(item.getString("ItemDescription"));
		    byte[] photoByteStream = item.getBytes("ItemPhoto");
			Bitmap photo = BitmapFactory.decodeByteArray(photoByteStream, 0, photoByteStream.length);
			ImageView photoView = (ImageView) findViewById(R.id.ItemPhoto);
			photoView.setImageBitmap(photo);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	/*
	 * onCreateOptionsMenu(Menu)
	 * 	Sets up the options menu for this 'page'. Adds items to action bar if it is present.
	 * Input:	Menu object
	 * Return:	True if successful
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.item, menu);
		return true;
	}
}
