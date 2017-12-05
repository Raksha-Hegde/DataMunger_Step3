package com.stackroute.datamunger.query;

//this class contains the data type definitions
public class DataTypeDefinitions {

	/*
	 * this class should contain a member variable which is a String array, to hold
	 * the data type for all columns for all data types
	 */
	private String[] dataType;

	public String[] getDataTypes() {
		return dataType;
	}
	
	public void setDataTypes(String[] dataType) {
		this.dataType = dataType;
	}
}
