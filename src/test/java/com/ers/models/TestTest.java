package com.ers.models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
//import org.meanbean.test.BeanTester;

import com.ers.dao.UserDAO;

public class TestTest {

	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("This happens once, before any tests are run.");
	}
	
	@Before
	public void beforeEachTest() {
		System.out.println("This happens before each test");
	}
	
	@After
	public void afterEachTest() {
		System.out.println("This happens after each test");
	}
	
	@AfterClass
	public static void afterAllTests() {
		System.out.println("This happens once, after all tests are run");
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void testSomething() {
		expectedException.expect(Exception.class);
		//pass something we expect would cause an exception to test the exceptions
		//this fails when this file is run because we expected an exception but there wasn't one :)
	}
	
	
	//practice model test to learn
	
	
	@Test
	public void testUserRole() {
		User u = new User();
		UserRole ur = new UserRole();
		u.setRole(ur);
		
		assertEquals(ur, u.getRole());
		
	}	
	
//	This happens once, before any tests are run.
//	This happens before each test
//	This happens after each test
//	This happens before each test
//	This happens after each test
//	This happens once, after all tests are run

	
	
//	@Test
//	public void testUserUserId() {
//		User u = new User();
//		int testId = 15;
//		u.setUserId(testId);
//		
//		assertEquals(testId, u.getUserId());
//		
//	}
	
	
	
//	@Test
//	public void testObjectMethod() {
//		TestTest t = new TestTest();
//		assertTrue(((String) t.objectMethod(new User())).contains("hello"));
//	}
	
	
	
//	private Object objectMethod(User user) {
//		String h = "hello";
//		return null;
//	}

	//With mean bean
	
	
//	@Test
//	public void getterAndSetterTestForUser() throws Exception {
//	    new BeanTester().testBean(User.class);
//	}
//	
//	@Test
//	public void getterAndSetterTestForReimbursement() throws Exception {
//	    new BeanTester().testBean(Reimbursement.class);
//	}
	
	//get it to work then do the other three 
	
	
		
}
