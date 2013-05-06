/**
 * 
 */
package com.example.studentsaleapp.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.example.studentsaleapp.*;

import android.test.ActivityInstrumentationTestCase2;

/**
 * @author s4119270
 *
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTests() {
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see android.test.ActivityInstrumentationTestCase2#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
