package kr.or.ddit.sum;

import static org.junit.Assert.*;

import org.junit.Test;

import calculation.CalculationLogic;

public class CalculationLogicTest {

	
	//1 ~ 10까지의 합
	@Test 
	// 어노테이션
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		int start = 1 ;
		int end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);

		int min = Math.min(start, end);
		int max = Math.max(start, end);

		assertEquals(55, sumResult);	
		}
	
	@Test // 어노테이션 
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		int start = 3 ;
		int end = 12;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);

		assertEquals(75, sumResult);		
	}
}
