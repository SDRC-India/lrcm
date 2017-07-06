package org.sdrc.lrcasemanagement.model.webservice;

import java.util.Map;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public class PostSyncModel {
	
    private Map<String, String> successPatientIdMap;
    private int isError;
    private String errorMessage;
	public Map<String, String> getSuccessPatientIdMap() {
		return successPatientIdMap;
	}
	public void setSuccessPatientIdMap(Map<String, String> successPatientIdMap) {
		this.successPatientIdMap = successPatientIdMap;
	}
	public int getIsError() {
		return isError;
	}
	public void setIsError(int isError) {
		this.isError = isError;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
