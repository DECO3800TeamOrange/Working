package com.example.studentsaleapp.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.studentsaleapp.*;

/*
 * SearchTest Class
 * 
 * SearchTest() -	-	-	-	constructor class
 * setUp() -	-	-	-	-	set up variables for testing 
 * tearDown() -	-	-	-	-	clear variables after testing
 * testPreConditions() -	-	tests that the pretest conditions are met, that the environment has been set
 *						up correctly
 */
public class SearchTest extends ActivityInstrumentationTestCase2<Search> {

	/*
	 * SearchTest()
	 * 	Constructor class.
	 * Input:	None
	 * Return:	None
	 */
	public SearchTest() {
		super(Search.class);
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
}
