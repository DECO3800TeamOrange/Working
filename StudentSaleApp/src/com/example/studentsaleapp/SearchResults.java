package com.example.studentsaleapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SearchResults extends Activity {

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
		setContentView(R.layout.activity_search_results);
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
}
