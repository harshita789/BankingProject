package com.dalberry.exception;

public class CurrencyNotPresentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CurrencyNotPresentException(){
		
	}
	public CurrencyNotPresentException(String str){
		super(str);
		System.out.println("we do not provide service for this Currency");
	}

}
