package com.example.studentsaleapp;

import java.util.List;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class SellerPosts extends Activity {

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
	 * Retrieve()
	 * 
	 * Input:	None
	 * Return:	None
	 */
	public void Retrieve() {
		Intent intent = getIntent();
		EditText editName = (EditText) findViewById(R.id.itemName);
		EditText editDis = (EditText) findViewById(R.id.dis);
		EditText editLower = (EditText) findViewById(R.id.lower);
		EditText editUpper = (EditText) findViewById(R.id.upper);
		String itemName = intent.getStringExtra(MainActivity.ITEM_NAME);
		String ITEM_NAME2 = "";
		
		List<ParseObject> itemList;
		ParseQuery query = new ParseQuery("search");
			try {
				query.whereContains("title", itemName);
				try
				{
					int lower = Integer.parseInt(editLower.getText().toString());
					query.whereGreaterThanOrEqualTo("price", lower);
				} catch (Exception e) {
					
				}
			} catch (Exception ex) {
				
			}
	}
}
