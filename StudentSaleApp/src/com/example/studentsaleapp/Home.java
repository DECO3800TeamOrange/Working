package com.example.studentsaleapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class Home extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		TabHost tabHost = getTabHost();
        
        // Tab for searching
        TabSpec searchspec = tabHost.newTabSpec("Search");
        Intent searchIntent = new Intent(this, Search.class);
        searchspec.setContent(searchIntent);
        searchspec.setIndicator("Search");
         
        // Tab for Selling
        TabSpec sellspec = tabHost.newTabSpec("Sell");        
        Intent sellIntent = new Intent(this, MainActivity.class);
        sellspec.setContent(sellIntent);
        sellspec.setIndicator("Sell");
         
         
        // Adding all TabSpec to TabHost
        tabHost.addTab(searchspec); // Adding search tab
        tabHost.addTab(sellspec); // Adding sell tab
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}    