package com.maksymchuk.shopify.space;

import static org.junit.jupiter.api.Assertions.fail;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EasyMockExtension.class)
class SpaceShipAppTest {

	@TestSubject
	SpaceShipApp app = new SpaceShipApp();
	@Mock
	SpaceShipInterface	ssMock;
	
	
	@BeforeEach
	public void setUp() {
		
	}
    
	@Test
	void testIncrease() {
		ssMock.setMinSpeed(1);
		EasyMock.expectLastCall();
		
		ssMock.changeSpeed(1);
		EasyMock.expectLastCall();
		
		ssMock.moveForward();
		EasyMock.expectLastCall();
		
		EasyMock.replay(ssMock);
		app.increase();
		
		EasyMock.verify(ssMock);
		
	}

	@Test
	void testDecrease() {
		fail("Not yet implemented");
	}

	@Test
	void testLeft() {
		fail("Not yet implemented");
	}

	@Test
	void testRight() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckCoords() {
		fail("Not yet implemented");
	}

}
