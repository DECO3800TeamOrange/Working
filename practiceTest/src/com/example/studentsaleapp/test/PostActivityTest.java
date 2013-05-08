package com.example.studentsaleapp.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import com.example.studentsaleapp.MainActivity;
import android.test.*;
import android.widget.*;

public class PostActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	EditText itemText;
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
		postItem = (Button)
				mainActivity.findViewById(com.example.studentsaleapp.R.id.postItem);
        }
	
	protected void tearDown() throws Exception{
		super.tearDown();	
	}
	
	public void testText() {
		assertTrue(itemText.getText().equals(""));
	}
	
	public void testItemIsNotNull() {
		assertNotNull(itemText.getText());
	}
	//40 > item < 3 item length
	public void testItemRightLength() {
		boolean textCorrectLength;
		itemText.setText("printer", TextView.BufferType.EDITABLE);	
		if (itemText.length() > 3 && itemText.length() < 40)
			textCorrectLength = true;
		else 
			textCorrectLength = false;
		
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
	//40 > item length
	public void testItemTooLong() {
		boolean textCorrectLength;
		itemText.setText("printer", TextView.BufferType.EDITABLE);	
		if (itemText.length() > 40)
			textCorrectLength = false;
		else 
			textCorrectLength = true;
		
		assertTrue("Text is more than 40 characters", textCorrectLength);
	}
	//item length < 3 
	public void testItemTooShort() {
		boolean textCorrectLength;
		itemText.setText("printer", TextView.BufferType.EDITABLE);	
		if (itemText.length() > 3)
			textCorrectLength = true;
		else
			textCorrectLength = false;
		
		assertTrue("Text is more than 3 characters", textCorrectLength);
	}
	
	
	public void testItemTextValue() {
		assertTrue("it", itemText.getText().equals(""));
	}
	public void testThis() {
		assertTrue("It works", true);
	
	}
}
