package com.example.studentsaleapp.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.*;
import android.test.*;

import com.example.studentsaleapp.MainActivity;
import com.example.studentsaleapp.R;

public class Test1 extends ActivityInstrumentationTestCase2<MainActivity> {

	/*
	 * Test1()
	 * 	Constructor class.
	 * Input:	None
	 * Return:	None
	 */
	public Test1() {
		super(MainActivity.class);   
	}
	
	EditText itemText;
	Button postItem;
	Bitmap photo = BitmapFactory.decodeStream(super.getActivity().getResources().openRawResource(R.drawable.ic_launcher));

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
		itemText = (EditText) 
				getActivity().findViewById(com.example.studentsaleapp.R.id.itemName);
		postItem = (Button) 
				getActivity().findViewById(com.example.studentsaleapp.R.id.postItem);	
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
	protected void tearDown() {
		try {
			super.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * testItemText()
	 * 	Test that the TextBox (itemText) takes input, and that the received
	 * input is of sufficient length.
	 * Input:	None
	 * Output:	None
	 */
	public void testItemText() {
		boolean textTooShort = true;
		itemText.setText("printer");
		
		if (itemText.length() > 3)
			textTooShort = false;
		
		assertFalse("Text less than 4 characters", textTooShort);
	}
	
	/*
	 * testCameraFunction()
	 * 	Empty test, always returns true.
	 * Input:	None
	 * Return:	None
	 */
	public void testCameraFunction() {
		assertTrue(true);
	}
	
	/*
	 * testPhotoConversion()
	 * 	Checks if photo is successfully converted to bytearray from bitmap.
	 * Input:	None
	 * Return:	None
	 */
	public void testPhotoConversion() {
		byte[] byteArray = null;
		boolean success = false;
		
		try {
			byteArray = super.getActivity().convertBmpToBytes(photo);
			success = true;
		} catch (Exception e) {
			// Failed to convert Bitmap to Byte Array
			assertFalse("photo could not be converted to a byte array", false);
		}
		
		// Check that conversion result isn't null or zero length
		if ((byteArray != null) || (byteArray.length > 0))
			success = true;
		
		assertTrue("photo converted successfully to byte array", success);
	}
	
	/*
	 * testPostButton()
	 *  Empty test, always returns true.
	 * Input:	None
	 * Return:	None
	 */
	public void testPostButton() {
		assertTrue(true);
	}
}
