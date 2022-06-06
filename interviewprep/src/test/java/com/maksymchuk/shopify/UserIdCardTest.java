package com.maksymchuk.shopify;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class UserIdCardTest {

	UserIdCard uic = new UserIdCard();
	
	@Test
	public void playingAround() 
	{
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println(Calendar.getInstance().get(Calendar.MONTH));

	}
	
	@Test
	void testValid() {
		assertTrue(uic.isValid("Jigarius", "Caesar", "CAJI202002196"));
	}
	
	@Test
	void testInvalidLength() {
		assertFalse(uic.isValid("Jigarius", "Caesar", "CAJI20200219"));
	}

}
