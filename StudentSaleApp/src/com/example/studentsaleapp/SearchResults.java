package com.example.studentsaleapp;

import java.util.List;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class SearchResults extends Activity {
	String searchName;
	String searchLower;
	String searchUpper;
	String searchDis;
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
		Intent intent = getIntent();
		searchName = intent.getStringExtra("Name");
		searchLower = intent.getStringExtra("Lower");
		searchUpper = intent.getStringExtra("Upper");
		searchDis = intent.getStringExtra("Dis");
		setContentView(R.layout.activity_search_results);
		nameSearch();
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
		getMenuInflater().inflate(R.menu.search_results, menu);
		return true;
	}

	public void item(View v){
		//Opens up a item page on the selected item
		Intent newIntent = new Intent(this, Item.class);
		newIntent.putExtra("ID", v.getTag().toString());
		startActivity(newIntent);
		
	}
	
	public void nameSearch() {
		
		List<ParseObject> kids;
		//Mock geo location for the prototype
		ParseGeoPoint location = new ParseGeoPoint(-27.495069,152.984169);
		ParseQuery query = new ParseQuery("ItemPost");
			try {
				query.whereContains("ItemName", searchName);
				//lower price bound of the user's search
				if (searchLower.length() > 0)
				{
					int lower = Integer.parseInt(searchLower);
					query.whereGreaterThanOrEqualTo("Price", lower);
					
				}
				//upper price bound of the user's search
				if (searchUpper.length() > 0)
				{
					int upper = Integer.parseInt(searchUpper);
					query.whereLessThanOrEqualTo("Price", upper);
				}
				//distance constraint on the search
				if (searchDis.length() > 0)
				{
					int distance = Integer.parseInt(searchDis);
					query.whereWithinKilometers("Location", location, distance);
				}
				// completes the search with Parse.com
				kids = query.find();
				for (int i=0; i < kids.size(); i++ )
				{
					try{
						/*Dynamically builds the layout for the search results*/
						String ObjectID = kids.get(i).getObjectId();
						//The parent layout
						LinearLayout A = (LinearLayout) findViewById(R.id.SearchResultsLayout);
						//Layout container for each result
					    LinearLayout B = new LinearLayout(this);
					    B.setOrientation(LinearLayout.HORIZONTAL);
					    
					    ImageView image = new ImageView(this);
					    //converts the image file from parse into a usable image file
					    byte[] photoByteStream = kids.get(i).getBytes("ItemPhoto");
						Bitmap photo = BitmapFactory.decodeByteArray(photoByteStream, 0, photoByteStream.length);
						image.setImageBitmap(photo);
						//sets the image size limits
						LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
						image.setLayoutParams(layoutParams);
						//Associates the current layout object with the Parse.com ObjectID
						image.setTag(ObjectID);
						//Adds a on click function to the layout object
						image.setOnClickListener(item_OnClickListener);
						B.addView(image,0);
						
					    TextView test = new TextView(this);
					    test.setTag(ObjectID);
					    test.setOnClickListener(item_OnClickListener);
					    test.setText(kids.get(i).getString("ItemName"));
					    test.setPadding(8, 8, 8, 8);
					    B.addView(test,1);
					    
					    TextView test2 = new TextView(this);
					    test2.setTag(ObjectID);
					    test2.setOnClickListener(item_OnClickListener);
					    test2.setText("$"+kids.get(i).getInt("Price"));
					    test2.setPadding(8, 8, 8, 8);
					    test2.setTag(ObjectID);
					    B.addView(test2,2);
					    
					    TextView test3 = new TextView(this);
					    test3.setTag(ObjectID);
					    test3.setOnClickListener(item_OnClickListener);
					    test3.setText("distance: " + 
					    location.distanceInKilometersTo(kids.get(i).getParseGeoPoint("Location")));
					    test3.setPadding(8, 8, 8, 8);
					    test3.setTag(ObjectID);
					    B.addView(test3,3);
					    //Adds the result layout to the parent layout
					    A.addView(B);
						}catch(Exception e){
							TextView textDesc = (TextView) findViewById(R.id.textView1);
							textDesc.setText(e.toString());
						}
				}
				if (kids.size()==0)
				{
					TextView textDesc = (TextView) findViewById(R.id.textView1);
					textDesc.setText("No Results for Current Search");
				}
			}catch (ParseException e){
				TextView textDesc = (TextView) findViewById(R.id.textView1);
				textDesc.setText(e.toString());
			}
		}
public ParseObject[] searchItemObjectByName(String itemName) {
		ParseObject[] b = null; 
		//b = new ParseObject[2];
		//ParseObject a = new ParseObject(itemName);
		//b[0] = a;
		return b;
	}
	public ParseObject[] returnItemObjectByLocation(ParseGeoPoint location) {
		ParseObject[] b = null;
		return b;
	}
}
