package com.example.studentsaleapp.test;

import com.example.studentsaleapp.MainActivity;
import android.test.*;
import android.widget.*;
import android.view.KeyEvent;

/*
 * activityTest Class
 * 	Tests the functions of the MainActivity Class.
 * 
 * activityTest() -	-	-	-	constructor method
 * setUp() -	-	-	-	-	setup variables for testing
 * tearDown() -	-	-	-	-	clean up variables after testing
 * testPreConditions() -	-	tests that the pretest conditions are met, that the environment has been set
 *						up correctly
 * testText() -	-	-	-	-	test that text value of TextBox is empty
 * testItemTextValueBefore() -	test that TextBox isn't null
 * testItemText() -	-	-	-	test that TextBox contents match set value
 * testItemTextValue() -	-	test that TextBox is empty
 * testThis() -	-	-	-	-	empty test, simply returns true
 */
public class activityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
	Button postItem;
	
	/*
	 * activityTest()
	 * 	Constructor class. 
	 * Input:	None
	 * Return:	None
	 */
	public activityTest() {
		//ActivityInstrumentationTestCase2(MainActivity.class);
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
		
		// Turns off touch mode - necessary for key events to work 
		setActivityInitialTouchMode(false);
		
		MainActivity mainActivity = getActivity();
		
		itemText = (EditText) 
				mainActivity.findViewById(com.example.studentsaleapp.R.id.itemName);
		postItem = (Button) 
				mainActivity.findViewById(com.example.studentsaleapp.R.id.postItem);
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
	protected void tearDown() throws Exception{
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
		assertTrue(itemText != null);
		assertTrue(postItem != null);
	}
	
	/*
	 * testText()
	 * 	Test that text value of TextBox (itemName) is empty.
	 * Input:	None
	 * Return:	None
	 */
	public void testText() {
		// -> problem ATM, comparing Editable with String
		assertTrue(itemText.getText().equals(""));
	}
	
	/*
	 * testItemTextValueBefore()
	 * 	Test that TextBox (itemName) isn't null.
	 * Input:	None
	 * Return:	None
	 */
	public void testItemTextValueBefore() {
		assertNotNull(itemText.getText());
	}
	
	/*
	 * testItemText()
	 * 	Test that TextBox (itemName) contents match set value.
	 * Input:	None
	 * Return:	None
	 */
	public void testItemText() {
		//itemText.setText("printer", TextView.BufferType.EDITABLE);
		
		// Set focus of UI to the appropriate text field
		itemText.requestFocus();
		itemText.setSelection(0);
		
		// Send key inputs to device - 'printer'
		this.sendKeys(KeyEvent.KEYCODE_P, KeyEvent.KEYCODE_R, KeyEvent.KEYCODE_I,
				KeyEvent.KEYCODE_N, KeyEvent.KEYCODE_T, KeyEvent.KEYCODE_E,
				KeyEvent.KEYCODE_R);
		
		// Check that input matches expectation 
		// -> problem ATM, comparing Editable with String
		assertTrue("Text does not match input", itemText.getText().toString().equalsIgnoreCase("printer"));
	}
	
	/*
	 * testItemTextValue()
	 * 	Test that TextBox (itemName) is empty.
	 * Input:	None
	 * Return:	None
	 */
	public void testItemTextValue() {
		// -> problem ATM, comparing Editable with String
		assertTrue("it", itemText.getText().equals(""));
	}
	
	/*
	 * testThis()
	 * 	Empty test, simply returns true.
	 * Input:	None
	 * Return:	None
	 */

}
