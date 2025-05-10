package com.exception;


public class ResourceNotFoundException extends RuntimeException{
	
	String resource;
	String resourceName;
	int id;
	
	public ResourceNotFoundException(String resource,String resourceName,int id) {
		super(String.format("%s with %s : %s is not found", resource,resourceName,id));
		this.resource = resource;
		this.resourceName=resourceName;
		this.id=id;
	}
}
