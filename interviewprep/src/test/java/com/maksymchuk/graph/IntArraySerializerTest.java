package com.maksymchuk.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntArraySerializerTest {

	IntArraySerializer ias = new IntArraySerializer();

	@Test
	void testSerializeNull() {
		assertEquals("[]", ias.serialize(null));
	}

	@Test
	void testSerializeEmpty() {
		assertEquals("[]", ias.serialize(new Integer[] {}));
	}

	@Test
	void testSerializeNonEmpty() {
		assertEquals("[1, 2]", ias.serialize(new Integer[] { 1, 2 }));
	}

	@Test
	void testDeSerializeNull() {
		assertEquals(0, ias.deSerialize(null).length);
	}

	@Test
	void testDeSerializeEmpty() {
		assertEquals(0, ias.deSerialize("[]").length);
	}

	@Test
	void testDeSerializeNonEmpty() {
		assertEquals(ias.serialize(new Integer[] { 1, 2 }), "[1, 2]");
	}
}
