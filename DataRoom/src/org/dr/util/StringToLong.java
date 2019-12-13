package org.dr.util;

public class StringToLong {
	
	public static Long getLong(String str) {
		
		Long result = 0l;
		
		try {
			result = Long.parseLong(str);
		}catch(Exception e) {
			
		}
		return result;
	}
	public static int getInt(String str) {
		
		int result = 0;
		
		try {
			result = Integer.parseInt(str);
		}catch(Exception e) {
			
		}
		return result;
	}

}
