package com.App.HMS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="item_master")

public class MasterModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "item_code")
	private String itemcode;
    @Column(name = "item_name")
	private String itemname;
	private String type;
	private String fee;
	private String remarks;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public MasterModel(long id, String itemcode, String itemname, String type, String fee, String remarks) {
		super();
		this.id = id;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.type = type;
		this.fee = fee;
		this.remarks = remarks;
	}
	public MasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
