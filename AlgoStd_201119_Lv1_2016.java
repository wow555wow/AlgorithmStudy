package level1;

public class AlgoStd_201119_Lv1_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201119_Lv1_2016 c = new AlgoStd_201119_Lv1_2016();
		System.out.println(c.solution(5, 24));
//		System.out.println(c.solution(1, 1));

	}
	
	
	final String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//	String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
	// 7이하 홀수달 : 31일, 짝수달 : 30일
	// 짝수달 예외 : 2월-29일(윤달)
	// 7초과 홀수달 : 30일, 짝수달 : 31일
	final int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	/** 2016년
	 * 
	 * 1월 1일에서 입력받은 날짜까지가 며칠 차이인지를 구해서 요일 구하기
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution(int a, int b) {
		String answer = "";
		
//		int today = 5;	//요일배열의 idx, 초기값 1월 1일 금요일
//		int convertToDays = (a-1) * dayOfMonth[a-1] + b + 5;
		
		int convertToDays = b+4;	// 일 + 초기값(1월 1일이 idx 5인 FRI임)
		for(int i=0; i<a-1; i++) {
			convertToDays += dayOfMonth[i];
		}
		answer = day[convertToDays % 7];
		
        return answer;
    }

}
