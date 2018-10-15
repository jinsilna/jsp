package kr.or.ddit.etc;

import static org.junit.Assert.*;
import kr.or.ddit.util.StringUtill;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDispositon = "form-data; name =name=\"profile\"; filename=\"brown.png\"";	

		/***When***/

		String fileName = "brown.png";
		String [] splists = contentDispositon.split("; ");

		for(String str : splists){
			if(str.indexOf("filename=")>=0)
				//filename="brown.png"
				fileName = str.substring(10,str.lastIndexOf("\""));
			/***Then***/
			assertEquals("brown.png",fileName);


		}
	}

	@Test
	public void getCookieTest(){
		/***Given***/
		String cookieString = "remember=Y; userId=brown; etc=test";

		/***When***/
		String cookieValue = StringUtill.getCookie(cookieString, "remember");
		String cookieValue2 = StringUtill.getCookie(cookieString, "userId");

		/***Then***/

		assertEquals("Y", cookieValue);
		assertEquals("brown", cookieValue2);
	}	
}


























