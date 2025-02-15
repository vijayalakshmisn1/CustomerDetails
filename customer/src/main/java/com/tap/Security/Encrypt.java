package com.tap.Security;

public class Encrypt {

	public static String encrypt(String str) {
		String s="";
		for(int i=0;i<str.length();i++) {
			s=s+((char)(str.charAt(i)+Key.getKey()));
		}
		return s;
	}
}