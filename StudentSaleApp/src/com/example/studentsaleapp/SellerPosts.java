package com.example.studentsaleapp;

import java.util.List;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SellerPosts extends Activity {
    
	String userID;
	final OnClickListener item_OnClickListener = new OnClickListener() {
        public void onClick(final View v) {
        	item(v);
        }
    };
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
		setContentView(R.layout.activity_seller_posts);
		nameSearch();
	}
	
	public void item(View v){
		Intent newIntent = new Intent(this, Item.class);
		newIntent.putExtra("ID", v.getTag().toString());
		startActivity(newIntent);
	}
	
public void nameSearch() {
		
		List<ParseObject> kids;
		userID = getUserID();
		ParseQuery query = new ParseQuery("ItemPost");
			try {
				query.whereContains("UserID", userID);

				kids = query.find();

				
				for (int i=0; i < kids.size(); i++ )
				{
					try{
						String ObjectID = kids.get(i).getObjectId();
						LinearLayout A = (LinearLayout) findViewById(R.id.SellerPostsLayout);
					    A.layout(50, 50, 50, 50);
					    LinearLayout B = new LinearLayout(this);
					    B.setOrientation(LinearLayout.HORIZONTAL);
					    ImageView image = new ImageView(this);
					    byte[] photoByteStream = kids.get(i).getBytes("ItemPhoto");
						Bitmap photo = BitmapFactory.decodeByteArray(photoByteStream, 0, photoByteStream.length);
						image.setImageBitmap(photo);
						LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
						image.setLayoutParams(layoutParams);
						image.setTag(ObjectID);
						image.setOnClickListener(item_OnClickListener);
						B.addView(image,0);
					    TextView test = new TextView(this);
					    test.setTag(ObjectID);
					    test.setText(kids.get(i).getString("ItemName"));
					    test.setPadding(8, 8, 8, 8);
					    B.addView(test,1);
					    TextView test2 = new TextView(this);
					    test2.setTag("da");
					    test2.setText(kids.get(i).getObjectId());
					    test2.setPadding(8, 8, 8, 8);
					    test2.setTag(ObjectID);
					    B.addView(test2,2);
					    A.addView(B);
						}catch(Exception e){
							TextView textDesc = (TextView) findViewById(R.id.textView1);
							textDesc.setText(e.toString());
						}
				}
			}catch (ParseException e){
				TextView textDesc = (TextView) findViewById(R.id.textView1);
				textDesc.setText(e.toString());
			}
		}
	@Override
	/*
	 * onCreateOptionsMenu(Menu)
	 * 	Sets up the options menu for this 'page'. Adds items to action bar if it is present.
	 * Input:	Menu object
	 * Return:	None
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.seller_posts, menu);
		return true;
	}
	/*
	 * getUserID()
	 * 	Gets an ID representing the user.
	 * Input:	None
	 * Return:	String of Device ID, representing unique user code
	 */
	public String getUserID() {
		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}
	
}
