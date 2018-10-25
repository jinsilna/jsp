package kr.or.ddit.locales;

import java.util.TimeZone;

import org.junit.Test;

public class TimezoneTest {

	@Test
	public void timezoneTest() {
		
		/***Given***/
		

		/***When***/
		String[] timezone = TimeZone.getAvailableIDs();			
		for(String str : timezone)
			System.out.println(str);
		
		/***Then***/

	}

}
