package com.util;

public class nameShorter {
    public static String getShortString(String longString, Integer shortNumber) {
		longString = longString.replaceAll("\\s+","");
		if(longString==null) {
			return  "";
		}
		if(longString.length()<shortNumber) {
			return longString;
		}
		else {
			return longString.substring(0,shortNumber)+"...";
		}
    }
}
