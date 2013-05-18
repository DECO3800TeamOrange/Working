package com.example.studentsaleapp.test;

import com.example.studentsaleapp.PostedActivity;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;

import android.test.ActivityInstrumentationTestCase2;

public class PostedActivityTest extends
		ActivityInstrumentationTestCase2<PostedActivity> {
	
	String objectID = "";
	String itemName;
	String itemDesc;
	byte[] photo;
	ParseGeoPoint location;
	String userID;
	


	public PostedActivityTest() {
		super(PostedActivity.class);
		
		
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		
	}
	public void setValues() {
		PostedActivity activity = getActivity();
		ParseObject item = activity.returnItemObjectByID(objectID);
		itemName = item.getString("ItemName");
		itemDesc = item.getString("ItemDescription");
		photo = item.getBytes("ItemPhoto");
		location = item.getParseGeoPoint("Location");
		userID = item.getString("UserID");
		
		assertTrue(true);
	}
	
	public void testParseItemName() {
		boolean present;
		
		if (itemName == null)
			present = false;
		else if (itemName.equals(""))
			present = false;
		else if (itemName.length() > 0)
			present = true;
		else 
			present = false;
		
		assertTrue("Item name is not empty", present);
	}
	public void testParseItemDescription() {
		boolean present;
		
		if (itemDesc == null)
			present = false;
		else if (itemDesc.equals(""))
			present = false;
		else if (itemDesc.length() > 0)
			present = true;
		else 
			present = false;
	
		assertTrue("Item Description is not empty", present);
	}
	public void testParseItemPhoto() {
		boolean present;
		
		if (photo == null)
			present = false;
		else if (photo.length == 0)
			present = false;
		else if (photo.length > 0)
			present = true;
		else 
			present = false;
	
		assertTrue("Photo is not empty", present);
	}
	
	public void testParseItemlocation() {
		boolean present;
		
		if (location == null)
			present = false;
		else if (location.getLatitude() == 0.0 || location.getLongitude() == 0.0)
			present = false;
		else
			present = true;
	
		assertTrue("Location is not empty", present);
	}
	
	public void testParseItemUserID() {
		boolean present;
		if (userID == null)
			present = false;
		else if (itemDesc.equals(""))
			present = false;
		else if (itemDesc.length() > 0)
			present = true;
		else 
			present = false;
	
		assertTrue("Item userID is not empty", present);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
