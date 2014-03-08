/**
 *  Copyright 2010 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Hospital-core module.
 *
 *  Hospital-core module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Hospital-core module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Hospital-core module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/



package org.openmrs.module.hospitalcore.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.hospitalcore.PatientQueueService;
import org.openmrs.module.hospitalcore.db.PatientQueueDAO;
import org.openmrs.module.hospitalcore.model.OpdPatientQueue;
import org.openmrs.module.hospitalcore.model.OpdPatientQueueLog;

/**
 * <p> Class: PatientQueueServiceImpl </p>
 * <p> Package: org.openmrs.module.hospitalcore.impl </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Feb 16, 2011 12:36:59 PM </p>
 * <p> Update date: Feb 16, 2011 12:36:59 PM </p>
 **/
public class PatientQueueServiceImpl  extends BaseOpenmrsService implements PatientQueueService{
	
	public PatientQueueServiceImpl() {
	}

	protected PatientQueueDAO dao;
	
	

	public PatientQueueDAO getDao() {
		return dao;
	}

	public void setDao(PatientQueueDAO dao) {
		this.dao = dao;
	}

	public OpdPatientQueue saveOpdPatientQueue(OpdPatientQueue opdPatientQueue)
			throws APIException {
		// TODO Auto-generated method stub
		return dao.saveOpdPatientQueue(opdPatientQueue);
	}

	public OpdPatientQueue updateOpdPatientQueue(Integer id, String status)
			throws APIException {
		// TODO Auto-generated method stub
		return dao.updateOpdPatientQueue(id, status);
	}

	public OpdPatientQueue getOpdPatientQueueById(Integer id)
			throws APIException {
		// TODO Auto-generated method stub
		return dao.getOpdPatientQueueById(id);
	}

	public void deleteOpdPatientQueue(OpdPatientQueue opdPatientQueue)
			throws APIException {
		// TODO Auto-generated method stub
		dao.deleteOpdPatientQueue(opdPatientQueue);
	}

	public List<OpdPatientQueue> listOpdPatientQueue(String patientName,
			Integer referralConceptId, String status, int min, int max)
			throws APIException {
		// TODO Auto-generated method stub
		return dao.listOpdPatientQueue(patientName, referralConceptId, status, min, max);
	}

	public Integer countOpdPatientQueue(String patientName, String searchType,
			Integer referralConceptId, String status) throws APIException {
		// TODO Auto-generated method stub
		return dao.countOpdPatientQueue(patientName, searchType,referralConceptId, status);
	}

	public OpdPatientQueueLog saveOpdPatientQueueLog(
			OpdPatientQueueLog opdPatientQueueLog) throws APIException {
		// TODO Auto-generated method stub
		return dao.saveOpdPatientQueueLog(opdPatientQueueLog);
	}

	public OpdPatientQueueLog getOpdPatientQueueLogById(Integer id)
			throws APIException {
		// TODO Auto-generated method stub
		return dao.getOpdPatientQueueLogById(id);
	}

	public OpdPatientQueueLog copyTo(OpdPatientQueue opdPatientQueue){
		OpdPatientQueueLog opdPatientQueueLog = new OpdPatientQueueLog();
		opdPatientQueueLog.setBirthDate(opdPatientQueue.getBirthDate());
		opdPatientQueueLog.setCreatedOn(opdPatientQueue.getCreatedOn());
		opdPatientQueueLog.setOpdConcept(opdPatientQueue.getOpdConcept());
		opdPatientQueueLog.setOpdConceptName(opdPatientQueue.getOpdConceptName());
		opdPatientQueueLog.setPatientIdentifier(opdPatientQueue.getPatientIdentifier());
		opdPatientQueueLog.setPatient(opdPatientQueue.getPatient());
		opdPatientQueueLog.setPatientName(opdPatientQueue.getPatientName());
		opdPatientQueueLog.setReferralConcept(opdPatientQueue.getReferralConcept());
		opdPatientQueueLog.setReferralConceptName(opdPatientQueue.getReferralConceptName());
		opdPatientQueueLog.setSex(opdPatientQueue.getSex());
		opdPatientQueueLog.setStatus(opdPatientQueue.getStatus());
		opdPatientQueueLog.setUser(opdPatientQueue.getUser());
		return opdPatientQueueLog;
	}
	
	

	public OpdPatientQueue getOpdPatientQueue(String patientIdentifier,Integer opdConceptId)throws APIException {
		// TODO Auto-generated method stub
		return dao.getOpdPatientQueue(patientIdentifier,opdConceptId);
	}

	public List<OpdPatientQueue> getAllPatientInQueue() throws APIException {
		return dao.getAllPatientInQueue();
	}
}
