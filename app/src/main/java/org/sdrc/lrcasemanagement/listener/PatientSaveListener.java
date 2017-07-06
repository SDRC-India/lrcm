package org.sdrc.lrcasemanagement.listener;

import org.sdrc.lrcasemanagement.model.AsyncTaskResultModel;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 26-01-2017.
 */

public interface PatientSaveListener {
    void patientSaveComplete(AsyncTaskResultModel asyncTaskResultModel);
}
