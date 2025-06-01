package com.simplogics.hospitalManagement.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.simplogics.hospitalManagement.model.Procedure;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseDTO {
    private String message="Success";
    private Boolean hasError=false;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
	public void setMessage(String message2) {
		this.message = message2;		
	}
	public void setHasError(boolean b) {
		this.hasError = b;		
	}
	
	public void setData(List<Procedure> patientDto) {
		// TODO Auto-generated method stub
		
	}
	public void setData1(List<Procedure> patientDto) {
		// TODO Auto-generated method stub
		
	}
	
}
