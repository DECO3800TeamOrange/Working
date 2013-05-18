package com.example.studentsaleapp.test;

import android.test.ActivityInstrumentationTestCase2;
import com.example.studentsaleapp.*;
import com.jayway.android.robotium.solo.Solo;

public class RobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	public RobotiumTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
		
	}
	public void testPostItem() throws Exception {
		solo.sendKey(solo.MENU);
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
