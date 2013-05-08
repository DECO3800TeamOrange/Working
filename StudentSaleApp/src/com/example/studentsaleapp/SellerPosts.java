package com.example.studentsaleapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SellerPosts extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seller_posts);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seller_posts, menu);
		return true;
	}

}
