package kr.or.ddit.util;

import static org.junit.Assert.assertEquals;

public class StringUtill {
	/**
	 * Method : getFileNameFormHeader
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 :contentDispositon에서 filename을 호출 
	 */
	public static String getFileNameFormHeader(String contentDispositon){
		String fileName = "";
		String[] splists = contentDispositon.split("; ");
		for(String str : splists){
			if(str.indexOf("filename=")>=0)
				//filename="brown.png"
				fileName = str.substring(10,str.lastIndexOf("\""));
		}
		return fileName;
	}

	public static String getCookie(String cookieString, String cookieName) {
		
		// "remember=Y; userId=brown; etc=test";
		String[] splists = cookieString.split("; ");
		String cookie = "";
		
		for(String str : splists){
			if(str.startsWith(cookieName + "="))
				//filename="brown.png"
				cookie = str.substring((cookieName + "=").length());
		}
		return cookie;
	}
}








