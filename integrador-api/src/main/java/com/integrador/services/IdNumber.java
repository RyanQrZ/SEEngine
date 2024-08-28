package com.integrador.services;

/*
 * 
 * This section verify if personal or enterprise id is valid
 * After that, it assignment to value field 
 * 
 */

public class IdNumber {
	
	private String value;

	// Constructor takes the parameter and calls the setter method

	public IdNumber(String value) {
		setValue(value);
	}

	// This method calls validation method before assignment the value attribute

	public void setValue(String input) {

		if (!isValid(input)){
			//An exception occurred
			//throw new IdNumberException();
			
		} else {
			this.value = input;
			
		}

	}

	// Calls more specific valid methods to validate string text

	private Boolean isValid(String text) {

		if (text.replaceAll("[^0-9]", "").length() == 11) {
			return isPersonalID(text);
			
		} else if (text.replaceAll("[^0-9]", "").length() == 14) {
			return isEnterpriseID(text);
			
		} else {
			return false;
			
		}

	}

	// Verify if personal id is correct

	private Boolean isPersonalID(String personalID) {
		
		// Format string by regular expression
		
		personalID = personalID.replaceAll("[^0-9]", "");

		int firstVerify, secondVerify, sum = 0;

		// First load verification
		// The - '0' cast char to integer

		for (int i = 0; i < 9; i++) {
			sum += (personalID.charAt(i) - '0') * (10 - i);
		}

		if (sum % 11 == 1 || sum % 11 == 0) {
			firstVerify = 0;
		} else {
			firstVerify = 11 - (sum % 11);
		}

		// Compare if first digit is correct

		if (personalID.charAt(9) - '0' != firstVerify) {
			return false;
		}

		// Second load verification
		
		sum = 0;

		for (int i = 0; i < 9; i++) {
			sum += (personalID.charAt(i + 1) - '0') * (10 - i);
		}

		if (sum % 11 == 1 || sum % 11 == 0) {
			secondVerify = 0;
		} else {
			secondVerify = 11 - (sum % 11);
		}

		// If everything went right this should return true

		return (personalID.charAt(10) - '0') == secondVerify;

	}

	// Verify if enterprise id is correct

	private Boolean isEnterpriseID(String enterpriseID) {
		return false;
	}

	// Get the value field

	public String getValue() {
		return value;
	}

}