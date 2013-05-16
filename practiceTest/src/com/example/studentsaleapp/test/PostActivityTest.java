package com.example.studentsaleapp.test;

import com.example.studentsaleapp.MainActivity;
import com.parse.ParseGeoPoint;

import android.test.*;
import android.widget.*;

/*
 * PostActivityTest Class
 * 
 * PostActivityTest() -	-	-	constructor class
 * setUp() -	-	-	-	-	set up variables for testing 
 * tearDown() -	-	-	-	-	clear variables after testing
 * testPreConditions() -	-	tests that the pretest conditions are met, that the environment has been set
 *						up correctly
 * testText() -	-	-	-	-	test that the text length of TextBox (itemText) is zero
 * testItemIsNotNull() -	-	test that the contents of TextBox (itemText) isn't null
 * testDescIsNotNull() -	-	test that the contents of TextBox (itemDesc) isn't null
 * testItemRightLength() -	-	input text into text field and confirm that text doesn't 
 * 						exceed specified length (40 > item < 3 item length)
 * testItemNotTooLong() -	-	input text into text field and confirm that text doesn't 
 * 						exceed specified length (40 > item length)
 * testItemNotTooShort() -	-	input text into text field and confirm that text doesn't 
 * 						exceed specified length (item length < 3)
 * testGetPhoneGeoPoint() -	-	test that location returns a value
 */
public class PostActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
	EditText itemDesc;
	ImageView itemPhoto;
	Button postItem;
	
	/*
	 * PostActivityTest()
	 * 	Constructor class.
	 * Input:	None
	 * Return:	None
	 */
	public PostActivityTest() {
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
		MainActivity mainActivity = getActivity();
		itemText = (EditText) 
				mainActivity.findViewById(com.example.studentsaleapp.R.id.itemName);
		itemDesc = (EditText)
				mainActivity.findViewById(com.example.studentsaleapp.R.id.itemDescription);
		itemPhoto = (ImageView)
				mainActivity.findViewById(com.example.studentsaleapp.R.id.ivReturnedPic);
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
		
	}
	
	/*
	 * testText()
	 * 	Test that the text length of TextBox (itemText) is zero.
	 * Input:	None
	 * Return:	None
	 */
	public void testText() {
		assertTrue(itemText.getText().length() == 0);
	}
	
	/*
	 * testItemIsNotNull()
	 * 	Test that the contents of TextBox (itemText) isn't null.
	 * Input:	None
	 * Return:	None
	 */
	public void testItemIsNotNull() {
		assertNotNull(itemText.getText());
	}
	
	/*
	 * testDescIsNotNull()
	 * 	Test that the contents of TextBox (itemDesc) isn't null.
	 * Input:	None
	 * Return:	None
	 */
	public void testDescIsNotNull() {
		assertNotNull(itemDesc.getText());
	}
	
	/*
	 * testPhotoIsNotNull()
	 * 	Test that the photo object (itemPhoto) isn't null.
	 * Input:	None
	 * Return:	None
	 */
	public void testPhotoIsNotNull() {
		assertNotNull(itemPhoto.getDrawable());
	}
	/*
	 * testItemRightLength()
	 * 	Input text into text field and confirm that text doesn't exceed 
	 * specified length. (40 > item < 3 item length)
	 * Input:	None
	 * Return:	None
	 */
	public void testItemRightLength() {
		boolean textCorrectLength = false;
		
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");
		
		if ((itemText.length() > 3) && (itemText.length() < 40))
			textCorrectLength = true;
		else 
			textCorrectLength = false;
		
		//assertTrue(itemText.getText().length() > 0);
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
	/*
	 * testItemNotTooLong()
	 * 	Input text into text field and confirm that text doesn't exceed 
	 * specified length. (40 > item length)
	 * Input:	None
	 * Return:	None
	 */
	public void testItemNotTooLong() {
		boolean textCorrectLength = false;
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");
		if (itemText.length() > 40)
			textCorrectLength = false;
		else 
			textCorrectLength = true;
		
		assertTrue("Text is more than 40 characters", textCorrectLength);
	}
	
	/*
	 * testItemNotTooShort()
	 * 	Input text into text field and confirm that text doesn't exceed 
	 * specified length. (item length < 3)
	 * Input:	None
	 * Return:	None
	 */
	public void testItemNotTooShort() {
		boolean textCorrectLength = false;
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");	
		if (itemText.length() > 3)
			textCorrectLength = true;
		else
			textCorrectLength = false;
		
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
	/*
	 * testGetPhoneGeoPoint()
	 * 	Test that location returns a value.
	 * Input:	None
	 * Return:	None
	 */
	public void testGetPhoneGeoPoint() {
		double longitude = 0;
		double latitude = 0;
		MainActivity mainActivity = getActivity();
		ParseGeoPoint point = mainActivity.getPhoneGeoPoint();
		
		longitude = point.getLongitude();
		latitude = point.getLatitude();

		assertTrue(longitude != 0);
		assertTrue(latitude != 0);
	}
}
