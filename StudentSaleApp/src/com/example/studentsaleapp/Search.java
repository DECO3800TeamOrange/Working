

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
		String itemLower = editLower.getText().toString();
		String itemUpper = editUpper.getText().toString();
		String itemDis = editDis.getText().toString();

		Intent newIntent = new Intent(this, SearchResults.class);
		newIntent.putExtra("Name", itemName);
		newIntent.putExtra("Lower", itemLower);
		newIntent.putExtra("Upper", itemUpper);
		newIntent.putExtra("Dis", itemDis);
		startActivity(newIntent);
		
		/*
		 * locationSearch(View)
		 * 
		 * Input:	View object
		 * Return:	None
		 */
		
		
	}
	public void locationSearch(View view) {
		
}
	public ParseObject[] returnItemObjectByLocation(ParseGeoPoint location) {
		return null;
		
	}
	public ParseObject[] searchItemObjectByName(String name) {
		return null;
		
	}

}