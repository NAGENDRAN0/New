package com.simplogics.hospitalManagement.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Setter
public class PatientProcedureDto {
    private String procedureId;
    private String patientId;
    private String date;
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPatientId() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getProcedureId() {
		// TODO Auto-generated method stub
		return null;
	}
}
