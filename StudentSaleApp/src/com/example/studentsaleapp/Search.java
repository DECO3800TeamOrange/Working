package com.example.studentsaleapp;

import java.util.List;

import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

/*
 * Search Class
 * 	Handles searching for items in the Parse Database.
 */
public class Search extends Activity {

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
		setContentView(R.layout.activity_search);
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
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	/*
	 * nameSearch(View)
	 * 
	 * Input:	View object representing ???
	 * Return:	None
	 */
	public void nameSearch(View view) {
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDis = (EditText) findViewById(R.id.dis);
		EditText editLower = (EditText) findViewById(R.id.lower);
		EditText editUpper = (EditText) findViewById(R.id.upper);
		String itemName = editName.getText().toString().toLowerCase();    
		String ITEM_NAME2 = "";
		
		List<ParseObject> kids;
		ParseQuery query = new ParseQuery("search");
			try {
				query.whereContains("title", itemName);
				if (editLower.length() > 0)
				{
					int lower = Integer.parseInt(editLower.getText().toString());
					query.whereGreaterThanOrEqualTo("price", lower);
					
				}
				
				if (editUpper.length() > 0)
				{
					int upper = Integer.parseInt(editUpper.getText().toString());
					query.whereLessThanOrEqualTo("price", upper);
				}
				
				if (editDis.length() > 0)
				{
					int distance = Integer.parseInt(editDis.getText().toString());
					ParseGeoPoint location = new ParseGeoPoint(-27.495069,152.984169);
					query.whereWithinKilometers("location", location, distance);
				}
				kids = query.find();
				
				
				for (int i=0; i < kids.size(); i++){
					ITEM_NAME2= ITEM_NAME2 +kids.get(i).getString("title")+"\n";
					Log.i("Info",""+kids.size());
				}
			} catch (ParseException e) {
				
			}

		Intent newIntent = new Intent(this, PostedActivity.class);
		//newIntent.putExtra(ITEM_NAME, ITEM_NAME2);
		startActivity(newIntent);
	}
	
	/*
	 * locationSearch(View)
	 * 
	 * Input:	View object
	 * Return:	None
	 */
	public void locationSearch(View view) {
		
	}
}
