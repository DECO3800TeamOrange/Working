package com.example.studentsaleapp.test;

import com.example.studentsaleapp.*;
import com.example.studentsaleapp.R;
import android.test.ActivityInstrumentationTestCase2;
import android.graphics.Rect;
import android.test.*;
import android.view.View;
import android.widget.Button;

public class MainActivityLayoutTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	
	private Button postItem;
	private View mainLayout;

	public MainActivityLayoutTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		postItem = (Button) mainActivity.findViewById(R.id.postItem);
		mainLayout = (View) mainActivity.findViewById(R.layout.activity_main);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPostButtonOnScreen() {   
		   int fullWidth = mainLayout.getWidth();   
		   int fullHeight = mainLayout.getHeight();   
		   int[] mainLayoutLocation = new int[2];   
		   mainLayout.getLocationOnScreen(mainLayoutLocation);   
		   int[] viewLocation = new int[2];   
		   postItem.getLocationOnScreen(viewLocation);   
		   Rect outRect = new Rect();   
		   postItem.getDrawingRect(outRect);   
		   assertTrue("Add button off the right of the screen", fullWidth   
		           + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);   
		   assertTrue("Add button off the bottom of the screen", fullHeight   
		           + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);   
		
	}  

}
