package com.example.studentsaleapp.test;
import android.test.ActivityInstrumentationTestCase2;

import com.example.studentsaleapp.*;
import com.example.studentsaleapp.R;

import android.graphics.Rect;
import android.test.*;
import android.view.View;
import android.widget.Button;

public class ItemTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private Button postItem;
	private View mainLayout;
	
	/*
	 * ItemTest()
	 * 	Constructor class.
	 * Input:	None
	 * Return:	None
	 */
	public ItemTest() {
		super(MainActivity.class);
	}
	
	/*
	 * setUp()
	 * 	Set up variables for testing. 
	 * Input:	None
	 * Return:	None
	 * Throws:	Exception
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		postItem = (Button) mainActivity.findViewById(R.id.postItem);
		mainLayout = (View) mainActivity.findViewById(R.layout.activity_main);
	}
	
	/*
	 * tearDown()
	 * 	Clear variables after testing.
	 * Input:	None
	 * Return:	None
	 * Throws:	Exception
	 * 
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/*
	 * test()
	 * 	Empty test, simply returns true.
	 * Input:	None
	 * Return:	None
	 */
	public void test() {
		assertTrue(true);
	}
	
	/*
	 * testPostButtonOnScreen()
	 * 	Test that confirms that buttons have been established on the screen, and are
	 * thus accessible.
	 * Input:	None
	 * Return:	None
	 */
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
