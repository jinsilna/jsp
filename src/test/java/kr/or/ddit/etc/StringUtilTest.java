package kr.or.ddit.etc;

import static org.junit.Assert.*;

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

}
