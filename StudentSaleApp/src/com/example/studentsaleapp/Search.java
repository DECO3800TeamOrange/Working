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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
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
			}catch (ParseException e){
			}


		Intent newIntent = new Intent(this, PostedActivity.class);
		//newIntent.putExtra(ITEM_NAME, ITEM_NAME2);
		startActivity(newIntent);
		
		
		
	}
	public void locationSearch(View view) {
		
}

}
