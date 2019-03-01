package com.dalberry.exception;

public class CountryIsNotPresentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CountryIsNotPresentException(){
		
	}
	
	public CountryIsNotPresentException(String str){
		super(str);
		System.out.println("We do not provide Service For this Country");
	}
	
	

}
