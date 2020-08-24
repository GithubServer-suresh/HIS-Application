package com.healthInsurance.utils;

public class PwdUtils {

	private static final String ALPHA_NUMEIC_STRING ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String generateTempPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while(count-- !=0) {
			int chara = (int) (Math.random() * ALPHA_NUMEIC_STRING.length() );
			builder.append(ALPHA_NUMEIC_STRING.charAt(chara));
		}
		return builder.toString();
	}
	
	
}
