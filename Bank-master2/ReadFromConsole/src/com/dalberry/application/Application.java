package com.dalberry.application;

import com.dalberry.service.MyBankService;
import com.dalberry.utils.ReadFromPropertyFile;

/**
 * Entry point to the system
 * 
 * @author harshita
 *
 */
public class Application {

	public static void main(String[] args) {
		
		ReadFromPropertyFile.populateMasterData();
		MyBankService myBankService = MyBankService.getInstance();
		myBankService.applicationMenu();

	}
}