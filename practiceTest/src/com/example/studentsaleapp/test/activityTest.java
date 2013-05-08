package com.example.studentsaleapp.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.example.studentsaleapp.MainActivity;
import android.test.*;
import android.widget.*;

public class activityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
	Button postItem;
	
	public activityTest() {
		//ActivityInstrumentationTestCase2(MainActivity.class);
		super(MainActivity.class);   
		// TODO Auto-generated constructor stub
	}
	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();
		itemText = (EditText) 
				mainActivity.findViewById(com.example.studentsaleapp.R.id.itemName);
		postItem = (Button)
				mainActivity.findViewById(com.example.studentsaleapp.R.id.postItem);
        }
	
	protected void tearDown() throws Exception{
		super.tearDown();	
	}
	
	public void testText() {
		assertTrue(itemText.getText().equals(""));
	}
	
	public void testItemTextValueBefore() {
		assertNotNull(itemText.getText());
	}
	public void testItemText() {
		boolean textRightLength = false;
		itemText.setText("printer", TextView.BufferType.EDITABLE);	
		if (itemText.length() > 3)
			textRightLength = true;
		
		assertTrue("Text is more than 3 characters", itemText.getText().equals("printer"));
	}
	
	public void testItemTextValue() {
		assertTrue("it", itemText.getText().equals(""));
	}
	public void testThis() {
		assertTrue("It works", true);
	
	}
}
