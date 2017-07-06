package org.sdrc.lrcasemanagement.model.webservice;

import java.util.List;

/**
 * 
 *
 * @author Ratikanta Pradhan (ratikanta@sdrc.co.in) on 02-Feb-2017 5:08:54 pm
 */
public class TypeModel {

	private Integer id;
	private String name;
	private List<TypeDetailsModel> typeDetailsModels;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TypeDetailsModel> getTypeDetailsModels() {
		return typeDetailsModels;
	}
	public void setTypeDetailsModels(List<TypeDetailsModel> typeDetailsModels) {
		this.typeDetailsModels = typeDetailsModels;
	}	
	
}
