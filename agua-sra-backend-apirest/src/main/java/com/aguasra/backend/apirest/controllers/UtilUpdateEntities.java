package com.aguasra.backend.apirest.controllers;

import com.aguasra.backend.apirest.models.entity.Measurer;
import com.aguasra.backend.apirest.models.entity.Parameter;
import com.aguasra.backend.apirest.models.entity.Partner;
import com.aguasra.backend.apirest.models.entity.Role;

public class UtilUpdateEntities {
	
	public static Object entityUpdated(Object actual, Object enteredByUser) {
		Object updated=null;

		if(actual instanceof Role) {
			Role roleActual= (Role) actual;
			Role roleByUser= (Role) enteredByUser;
			
			roleActual.setNameRole(roleByUser.getNameRole());
			roleActual.setStateRole(roleByUser.getStateRole());
			roleActual.setDateCreateRole(roleByUser.getDateCreateRole());
			
			updated = roleActual;
		}else if(actual instanceof Measurer) {
			Measurer measurerActual = (Measurer) actual;
			Measurer measurerByUser = (Measurer) enteredByUser;
			//TODO: verify one by one
			measurerActual.setStateMeasurer(measurerByUser.getStateMeasurer());
			
			updated= measurerActual;
		}else if(actual instanceof Parameter) {
			Parameter parameterActual = (Parameter) actual;
			Parameter parameterByUser = (Parameter) enteredByUser;
			
			parameterActual.setNameParameter(parameterByUser.getNameParameter());
			parameterActual.setDescriptionParameter(parameterByUser.getDescriptionParameter());
			parameterActual.setValueParameter(parameterByUser.getValueParameter());
			parameterActual.setTypeParameter(parameterByUser.getTypeParameter());
			parameterActual.setStateParameter(parameterByUser.getStateParameter());
			parameterActual.setDateCreateParameter(parameterByUser.getDateCreateParameter());
			
			updated = parameterActual;
		}else if(actual instanceof Partner) {
			Partner partnerActual = (Partner) actual;
			Partner partnerByUser = (Partner) enteredByUser;
			
			partnerActual.setNamePartner(partnerByUser.getNamePartner());
			partnerActual.setLastnamePartner(partnerByUser.getLastnamePartner());
			partnerActual.setDniPartner(partnerByUser.getDniPartner());
			partnerActual.setNumberPartner(partnerByUser.getNumberPartner());
			partnerActual.setApplePartner(partnerByUser.getApplePartner());
			partnerActual.setLotPartner(partnerByUser.getLotPartner());
			partnerActual.setPhone1Partner(partnerByUser.getPhone1Partner());
			partnerActual.setPhone2Partner(partnerByUser.getPhone2Partner());
			partnerActual.setStatePartner(partnerByUser.getStatePartner());
			partnerActual.setUser(partnerByUser.getUser());
			
			updated = partnerActual;
		}
		
		return updated;
	}

}
