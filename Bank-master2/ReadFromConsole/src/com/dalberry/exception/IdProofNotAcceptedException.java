package com.dalberry.exception;

public class IdProofNotAcceptedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IdProofNotAcceptedException(){
		
	}
	
	public IdProofNotAcceptedException(String str){
		super(str);
		System.out.println("We don't accept this ID PROOF");
	}

}
