package com.example.studentsaleapp.test;

import java.io.InputStream;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.example.studentsaleapp.MainActivity;
import com.example.studentsaleapp.R;
import com.jayway.android.robotium.solo.Solo;
import com.parse.ParseGeoPoint;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.*;
import android.widget.*;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
	EditText itemDesc;
	ImageView itemPhoto;
	Button postItem;
	
	public MainActivityTest() {
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
		if (itemText.getText().toString().length() > 0 )//&& itemText.length() < 40)
			textCorrectLength = true;
		else 
			textCorrectLength = false;
		
		//assertTrue(itemText.getText().length() > 0);
		assertTrue("Item text is the right length", textCorrectLength);
	}
	
	//40 > item length

	//item length < 3 
	
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
	
	public void testGetPhoneID() {
		Boolean trueID = false;
		MainActivity mainActivity = getActivity();
		String phoneID = mainActivity.getUserID();
		if (phoneID.length() > 0)
			trueID = true;
		
		assertTrue(trueID);
	}
	
	public void testGetSuburbByGeoPoint() {
		ParseGeoPoint location = new ParseGeoPoint(27.5000, 153.0000);
		Boolean validSuburb = false;
		MainActivity mainActivity = getActivity();
		String suburb = mainActivity.getSuburbByGeoPoint(location);
		if (suburb.equalsIgnoreCase("St.Lucia") || suburb.equalsIgnoreCase("Saint Lucia") )
			validSuburb = true;
		assertTrue("correct suburb returned", validSuburb);
	}
	
	public void testPhotoConversion() {
		MainActivity activity = getActivity();
		InputStream is = activity.getResources().openRawResource(R.drawable.ic_launcher);
		Bitmap defaultPhoto = BitmapFactory.decodeStream(is);
		byte[] byteArray = null;
		boolean success = false;
		try {
			byteArray = super.getActivity().convertBmpToBytes(defaultPhoto);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		if (byteArray != null && byteArray.length > 0)
			success = true;
		
		assertTrue("photo converted successfully to byte array", success);
	}
	
	

}
