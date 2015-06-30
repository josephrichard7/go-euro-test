package com.goeuro.desg.services;

import java.util.List;

import com.goeuro.core.exceptions.GoEuroServiceException;
import com.goeuro.desg.interfaces.IPosition;
import com.goeuro.desg.vos.PositionVO;

public abstract class AbstractPositionSrv implements IPosition {

	public List<PositionVO> queryPositions(String filter) throws GoEuroServiceException{
		List<PositionVO> listPositionVO = null;

		// TODO Profiling
		try {
			listPositionVO = doQueryPositions(filter);
			// TODO Profiling
		} catch (GoEuroServiceException serviceException) {
			throw serviceException;
		} catch (Exception e){
			throw new GoEuroServiceException(e);
		}
		
		return listPositionVO;
	}
	
	public void positionsToCSVFile(List<PositionVO> positions, String filename) throws GoEuroServiceException {
		// TODO Profiling
		try {
			doPositionsToCSVFile(positions, filename);
			// TODO Profiling
		} catch (GoEuroServiceException serviceException) {
			throw serviceException;
		} catch (Exception e){
			throw new GoEuroServiceException(e);
		}
	};
	
	
	protected abstract void doPositionsToCSVFile(List<PositionVO> positions, String filename);
	protected abstract List<PositionVO> doQueryPositions(String filter);
	
}
