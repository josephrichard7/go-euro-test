package com.goeuro;

import com.goeuro.desg.interfaces.IPosition;
import com.goeuro.impl.services.PositionSrvImpl;

import junit.framework.TestCase;

public class PositionSrvImplTest extends TestCase{
    
	public void testQueryPositions(){
		IPosition position = new PositionSrvImpl();
		
		try{
			if(position.queryPositions("Germany").size() > 0)
				assertTrue(true);
		} catch(Exception e){
			fail();
		}
	}
	
	public void testPositionsToCSVFile(){
		IPosition position = new PositionSrvImpl();
		
		try{
			position.positionsToCSVFile(position.queryPositions("Germany"), "TestCase.csv");
			position.positionsToCSVFile(position.queryPositions(""), "TestCase2.csv");
			position.positionsToCSVFile(position.queryPositions("  "), "TestCase3.csv");
			position.positionsToCSVFile(position.queryPositions("3"), "TestCase4.csv");
			assertTrue(true);
		} catch(Exception e){
			fail();
		}
	}
}
