package com.revature.p0.daoimpl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomerDAOImplTest {

	private static CustomerDAOImpl customerDAOImpl;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // if any exception is thrown, test will fail

	@BeforeClass
	public static void initializeCustomerDAOImpl() {
		customerDAOImpl = new CustomerDAOImpl();
	}
	
	@Test
	public void sameCustomerMakesOfferOnSameCarThrowException() throws SQLException {

		thrown.expect(SQLException.class);
		customerDAOImpl.makeOffer(1000, 1030, 10000);
	}
}
