package com.maksymchuk.shopify;

import org.junit.jupiter.api.Test;

import com.maksymchuk.shopify.UrlShortener.RandomString;

class UrlShortenerTest {
	
	UrlShortener urlShortener = new UrlShortener();
	
	@Test
	void test() {
		for (int i = 0; i < 100; i++) {
			System.out.println(RandomString.getRandonString(6));
		}
	}

}
