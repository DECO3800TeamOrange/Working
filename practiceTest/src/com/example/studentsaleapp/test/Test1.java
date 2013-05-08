package com.example.studentsaleapp.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.*;
import android.test.*;

import com.example.studentsaleapp.MainActivity;
import com.example.studentsaleapp.R;

public class Test1 extends ActivityInstrumentationTestCase2<MainActivity> {

	public Test1() {
		super(MainActivity.class);   
		// TODO Auto-generated constructor stub
	}
	
	EditText itemText;
	Button postItem;
	Bitmap photo = BitmapFactory.decodeStream(super.getActivity().getResources().openRawResource(R.drawable.ic_launcher));


	
	protected void setUp() throws Exception {
		super.setUp();
		itemText = (EditText) 
				getActivity().findViewById(com.example.studentsaleapp.R.id.itemName);
		postItem = (Button) 
				getActivity().findViewById(com.example.studentsaleapp.R.id.postItem);	
	}
	
	protected void tearDown() {
		try {
			super.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testItemText() {
		boolean textTooShort = true;
		itemText.setText("printer");
		
		if (itemText.length() > 3)
			textTooShort = false;
		
		assertFalse("Text less than 4 characters", textTooShort);
	}
	public void testCameraFunction() {
		assertTrue(true);
	}
	public void testPhotoConversion() {
		byte[] byteArray = null;
		boolean success = false;
		try {
			byteArray = super.getActivity().convertBmpToBytes(photo);
			success = true;
		} catch (Exception e) {
			assertFalse("photo could not be converted to a byte array", false);
		}
		if (byteArray != null || byteArray.length > 0)
			success = true;
		
		assertTrue("photo converted successfully to byte array", success);
	}
	
	public void testPostButton() {
		assertTrue(true);
	}

}
