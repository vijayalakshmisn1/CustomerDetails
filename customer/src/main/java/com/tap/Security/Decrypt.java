package com.tap.Security;

public class Decrypt {

	public static String decrypt(String str) {
		String s="";
		for(int i=0;i<str.length();i++) {
			s=s+((char)(str.charAt(i)-Key.getKey()));
		}
		return s;
	}
}