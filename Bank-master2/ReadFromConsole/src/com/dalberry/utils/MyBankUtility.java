package com.dalberry.utils;

import java.util.List;
import java.util.Scanner;

import com.dalberry.dao.UserMap;
import com.dalberry.model.User;
import com.dalberry.model.UserAccount;
import com.dalberry.request.LoginRequest;

public class MyBankUtility {
	public static Scanner scanner = new Scanner(System.in);

	public static String readInputFromConsole() {
		// Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();

		// scanner.close();
		return userInput;
	}

	public static boolean checkAvailabilityOfCountry(String userdesireCountryName) {
		List<String> selectedCountries = ReadFromPropertyFile.getSelectedCountryList();
		if (selectedCountries.contains(userdesireCountryName)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkAvailabilityOfCurrency(String Currency) {
		List<String> currencyList = ReadFromPropertyFile.getAllCurrencyList();
		if (currencyList.contains(Currency)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkAvailabilityOfIdentityCard(String document) {
		List<String> idProof = ReadFromPropertyFile.getIdProofAcceptedList();
		if (idProof.contains(document)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean userAccountWithParticularCurrency(LoginRequest loginRequest, String Currency) {

		User user = UserMap.getUserMap().get(loginRequest.getEmail());
		UserAccount userAccount = user.getMap().get(Currency);

		if (userAccount == null) {
			return false;
		} else {
			return true;
		}

	}

}
