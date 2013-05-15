package com.example.studentsaleapp.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.example.studentsaleapp.MainActivity;
import android.test.*;
import android.widget.*;

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
	 * testText()
	 * 	Test that text value of TextBox (itemName) is empty.
	 * Input:	None
	 * Return:	None
	 */
	public void testText() {
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
		boolean textRightLength = false;
		itemText.setText("printer", TextView.BufferType.EDITABLE);	
		if (itemText.length() > 3)
			textRightLength = true;
		
		assertTrue("Text is more than 3 characters", itemText.getText().equals("printer"));
	}
	
	/*
	 * testItemTextValue()
	 * 	Test that TextBox (itemName) is empty.
	 * Input:	None
	 * Return:	None
	 */
	public void testItemTextValue() {
		assertTrue("it", itemText.getText().equals(""));
	}
	
	/*
	 * testThis()
	 * 	Empty test, simply returns true.
	 * Input:	None
	 * Return:	None
	 */
	public void testThis() {
		assertTrue("It works", true);
	}
}
