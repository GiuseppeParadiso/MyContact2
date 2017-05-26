package it.paradisogiuseppe.utility;

import java.util.regex.Pattern;

public class StringValidation {
	private static String EMAIL_REGEX = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	private static String NAME_REGEX = "[a-zA-Z]+ [a-zA-Z]";
	private static String TEL_REGEX = "[0-9]{5,10}";
	
	public static boolean check(String regex, String input){
		  if (Pattern.matches(regex, input))
		    return true;
		  else
		    return false;
	}
	
	public static String getEmailRegex(){
		return EMAIL_REGEX;
	}
	
	public static String getNameRegex(){
		return NAME_REGEX;
	}

	public static String getTelRegex() {
		return TEL_REGEX;
	}
}
