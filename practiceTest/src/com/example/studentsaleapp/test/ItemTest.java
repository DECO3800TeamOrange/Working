package com.example.studentsaleapp.test;
import android.test.ActivityInstrumentationTestCase2;

import com.example.studentsaleapp.*;
import com.example.studentsaleapp.R;

import android.graphics.Rect;
import android.test.*;
import android.view.View;
import android.widget.Button;

/*
 * ItemTest Class
 * 
 * ItemTest() - -	-	-	-	constructor class
 * setUp() - 	-	-	-	-	set up variables for testing
 * tearDown() -	-	-	-	-	clear variables after testing
 * testPreConditions() -	-	tests that the pretest conditions are met, that the environment has been set
 *						up correctly
 * test() - -	-	-	-	-	empty test, simply returns true
 * testPostButtonOnScreen() -	test that confirms that buttons have been established on 
 * 						the screen, and are thus accessible.
 */
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
	 * 	Set up variables for testing. Invoked before each test is run.
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
	 * testPreConditions()
	 * 	Tests that the pretest conditions are met, that the environment has been set
	 * up correctly.
	 * Input:	None
	 * Return:	None
	 */
	public void testPreConditions() {
		
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
		// Set local variables
		int fullWidth = mainLayout.getWidth();
		int fullHeight = mainLayout.getHeight();
		int[] mainLayoutLocation = new int[2];

		// What does this do?
		mainLayout.getLocationOnScreen(mainLayoutLocation);   

		int[] viewLocation = new int[2];   
		
		// What does this do?
		postItem.getLocationOnScreen(viewLocation);   

		Rect outRect = new Rect();   

		// What does this do?
		postItem.getDrawingRect(outRect);
		
		// -> no values presently assigned to the compared variables
		assertTrue("Add button off the right of the screen", fullWidth   
				+ mainLayoutLocation[0] > outRect.width() + viewLocation[0]);   
		assertTrue("Add button off the bottom of the screen", fullHeight   
				+ mainLayoutLocation[1] > outRect.height() + viewLocation[1]);   
	}  
}
