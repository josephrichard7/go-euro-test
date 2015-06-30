package com.goeuro;

import com.goeuro.entry.Entry;

import junit.framework.TestCase;

public class EntryTest extends TestCase{

	public void testMain(){
		Entry.main(new String[]{"Germany"});
		Entry.main(null);
		
		assertTrue(true);		
	}
}
