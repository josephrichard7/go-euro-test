package com.goeuro.desg.interfaces;

import java.util.List;

import com.goeuro.core.exceptions.GoEuroServiceException;
import com.goeuro.desg.vos.PositionVO;

public interface IPosition {

	List<PositionVO> queryPositions(String filter) throws GoEuroServiceException;
	
	void positionsToCSVFile(List<PositionVO> positions, String filename) throws GoEuroServiceException;
}
