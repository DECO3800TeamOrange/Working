package com.example.studentsaleapp.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.example.studentsaleapp.MainActivity;
import com.parse.ParseGeoPoint;

import android.test.*;
import android.widget.*;

public class PostActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
	EditText itemDesc;
	ImageView itemPhoto;
	Button postItem;
	
	public PostActivityTest() {
		//ActivityInstrumentationTestCase2(MainActivity.class);
		super(MainActivity.class);   
		// TODO Auto-generated constructor stub
	}
	
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
	
	protected void tearDown() throws Exception{
		super.tearDown();	
	}
	
	
	
	public void testText() {
		assertTrue(itemText.getText().length() == 0);
	}
	
	public void testItemIsNotNull() {
		assertNotNull(itemText.getText());
	}
	
	public void testDescIsNotNull() {
		assertNotNull(itemDesc.getText());
	}
	
	public void testPhotoIsNotNull() {
		assertNotNull(itemPhoto.getDrawable()
				);
	}
	//40 > item < 3 item length
	public void testItemRightLength() {
		boolean textCorrectLength;	
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");
		if (itemText.length() > 3 && itemText.length() < 40)
			textCorrectLength = true;
		else 
			textCorrectLength = false;
		
		//assertTrue(itemText.getText().length() > 0);
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
	//40 > item length
	public void testItemNotTooLong() {
		boolean textCorrectLength;
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");
		if (itemText.length() > 40)
			textCorrectLength = false;
		else 
			textCorrectLength = true;
		
		assertTrue("Text is more than 40 characters", textCorrectLength);
	}
	//item length < 3 
	public void testItemNotTooShort() {
		boolean textCorrectLength;
		sendKeys("printer ENTER ");
		sendKeys("$100 ENTER ");
		sendKeys("ENTER");	
		if (itemText.length() > 3)
			textCorrectLength = true;
		else
			textCorrectLength = false;
		
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
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
