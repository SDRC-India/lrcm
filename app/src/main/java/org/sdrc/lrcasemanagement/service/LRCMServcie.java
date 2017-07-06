package org.sdrc.lrcasemanagement.service;

import org.sdrc.lrcasemanagement.model.DataModel;
import org.sdrc.lrcasemanagement.model.PatientModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Ratikanta Pradhan (ratikanta@sdrc.co.in) on 29-01-2017.
 */

public interface LRCMServcie {
    List<PatientModel> getPatientModel();

    List<PatientModel> getPatientModelByDate (Date startDate, Date endDate);
}
