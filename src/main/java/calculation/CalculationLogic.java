package calculation;

public class CalculationLogic {

	public static void main(String[] args){
		CalculationLogic logic = new CalculationLogic();
		int start = 1 ;
		int end = 10;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		if(sumResult == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
		
		//-----------------------------------------------------
		sumResult = logic.sumBetweenTwoNumbers(start+2, end+2);
		if(sumResult == 75){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
		
		
	}
	public int sumBetweenTwoNumbers(int start, int end) {
		
		 int mul = 0;
		    for(int i = start; i<= end; i++){
		    	mul+=i;
		    }
		return mul;
		}
}
