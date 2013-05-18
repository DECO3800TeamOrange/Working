package com.example.studentsaleapp.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.studentsaleapp.*;
import com.parse.*;

public class SearchTest extends
		ActivityInstrumentationTestCase2<Search> {

	public SearchTest() {
		super(Search.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Search activity = getActivity();
	}

	public void testSearchItemObjectByName() {
		Search activity = getActivity();
		ParseObject[] itemObjects;
		itemObjects = activity.searchItemObjectByName("chair");
		
		assertNotNull(itemObjects);
		//assertTrue(itemObjects.length > 0);
	}
	
	public void testReturnItemsByLocation() {
		//Brisbane coordinates
		ParseGeoPoint location = new ParseGeoPoint(-27.527758,153.039551);
		Search activity = getActivity();
		ParseObject[] itemObjects;
		itemObjects = activity.returnItemObjectByLocation(location);
		assertNotNull(itemObjects);
	}
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
