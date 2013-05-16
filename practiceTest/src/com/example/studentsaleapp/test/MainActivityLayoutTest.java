package com.example.studentsaleapp.test;

import com.example.studentsaleapp.*;
import com.example.studentsaleapp.R;
import android.test.ActivityInstrumentationTestCase2;
import android.graphics.Rect;
import android.test.*;
import android.view.View;
import android.widget.Button;

/*
 * MainActivityLayoutTest Class
 * 
 * MainActivityLayoutTest() -	constructor class
 * setUp() -	-	-	-	-	set up variables for testing
 * tearDown() - -	-	-	-	clear variables after testing
 * testPreConditions() -	-	tests that the pretest conditions are met, that the environment has been set
 *						up correctly
 * testPostButtonOnScreen() -	test that confirms that buttons have been established on
 * 						the screen, and are thus accessible
 */
public class MainActivityLayoutTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	
	private Button postItem;
	private View mainLayout;

	/*
	 * MainActivityLayoutTest()
	 * 	Constructor class.
	 * Input:	None
	 * Return:	None
	 */
	public MainActivityLayoutTest() {
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

		// -> currently the variables being compared have not be defined
		assertTrue("Add button off the right of the screen", fullWidth   
			+ mainLayoutLocation[0] > outRect.width() + viewLocation[0]);   
		assertTrue("Add button off the bottom of the screen", fullHeight   
			+ mainLayoutLocation[1] > outRect.height() + viewLocation[1]);   
	}
}
