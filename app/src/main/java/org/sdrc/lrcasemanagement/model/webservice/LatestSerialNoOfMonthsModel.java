package org.sdrc.lrcasemanagement.model.webservice;

import java.util.Map;

/**
 * 
 *
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in) on 05-Apr-2017 5:56:05 pm
 */
public class LatestSerialNoOfMonthsModel {
	
	private Map<String, Integer> serialNoMap;

	public Map<String, Integer> getSerialNoMap() {
		return serialNoMap;
	}

	public void setSerialNoMap(Map<String, Integer> serialNoMap) {
		this.serialNoMap = serialNoMap;
	}
}
