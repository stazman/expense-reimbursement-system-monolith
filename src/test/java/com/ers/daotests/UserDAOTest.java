package com.ers.daotests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.ers.dao.UserDAO;
import com.ers.dao.ReimbursementDAO;


import com.ers.models.User;
import com.ers.models.UserRole;
import com.ers.models.Reimbursement;
import com.ers.models.ReimbursementStatus;
import com.ers.models.ReimbursementType;
import com.ers.utilities.ConnectionUtil;

public class UserDAOTest {

	User user0;
	User user1;
	User user2;
	UserDAO ud1;
	UserDAO udm;

	UserRole role;

	@BeforeClass
	public static void beforeAll() {
		ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
		try(Connection conn = cu.getConnection()){
			conn.close();
		} catch (SQLException e) {
			System.exit(500);
		}

	}
	@Before
	public void setup() {
		ud1 = new UserDAO();
		role = new UserRole(2, "manager");
		user0 = new User(3, "kelsey1", "882baec383c3991f46585cc4a2becbb4",
				"kelsey", "iafrate", "kiafrate1@email.com", role);
		udm = Mockito.mock(UserDAO.class);
		user1 = new User(0, "kelsey", "password", "kelsey","iafrate","kiafrate@gmail.com",role);
		user2 = new User(0, "kelsey", "50f48c00e1534a29304709b4f136e50f",  "kelsey","iafrate","kiafrate@gmail.com",role);
	}

//	@Test
//	public void createUserTest() {
//		User u = ud1.create(User user1);
//		if(u.getUserId() !=0) {
//			user2.setPassword(u.getPassword());
//			u.setUserId(0);
//			assertEquals(u, user2);
//		} else {
//			assertTrue(false);
//		}
//	}

//	@Test
//	public void confirmCredentialsTest() {
//
//		Mockito.when(udm.getRoleById(2)).thenReturn(role);
//		User u = ud1.confirmCredentials("kelsey1", "password");
//		assertEquals(u,user0);
//	}


//	@Test
//	public void getRoleByIdTest() {
//
//		UserRole r = ud1.getRoleById(2);
//		assertEquals(role, r);
//	}

//	@Test
//	public void getRoleByNameTest() {
//
//		Role r = up1.getRoleByName("manager");
//		assertEquals(role, r);
//	}



//	@Test
//	public void deleteUserTest() {
//		assertTrue(up1.deleteUser(user2));
//	}

}

//
//UserService us;
//DaoInstance dao;
//
//@Before
//public void setup() {
//	dao = Mockito.mock(DaoInstance.class);
//	us = new UserService(dao);
//}
//
//@Test
//public void testCheckCreds() {
//	Mockito.when(dao.findByUsername("sarah")).thenReturn(new User("sarah","p4ssw0rd",0));
//	boolean b1 = us.checkCreds("sarah", "p4ssw0rd");
//	assertTrue(b1);
//}
//}