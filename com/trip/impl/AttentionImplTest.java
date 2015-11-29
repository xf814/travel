package com.trip.impl;
import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
public class AttentionImplTest {
	 private static AttentionImpl attention = new AttentionImpl();
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testCountFans1() {
		try {
			attention.countFans(10000003);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,attention.getResult());
	}
	@Test
	public void testCountFans2() {
		try {
			attention.countFans(10000013);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,attention.getResult());
	}
	@Test
	public void testCountFans3() {
		try {
			attention.countFans(10000000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(1,attention.getResult());
	}

}
