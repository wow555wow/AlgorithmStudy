package level2;

public class AlgoStd_201030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		solution_2(2, 4, 2, 1);
		solution_2(16, 16, 2, 2);

	}
	
	
	/* 진법변환 참조
	 * 10진법 -> n진법 변환 : String.toBinaryString 등
	 * n진법 -> 10진법 변환 : Integer.parseInt(i, n);
	 */
	
	
	/** [3차] n진수 게임 : n진법 숫자를 차례로 말한다. 자릿수로 끊어서 말함
	 * 
	 * elaps : 10/29 22:30 ~ 10/30 23: 
	 * 
	 * @param n : 진법
	 * @param t : 미리 구할 숫자의 갯수(튜브가 말할)
	 * @param m : 게임에 참가하는 인원
	 * @param p : 튜브의 순서
	 * @return : 튜브가 말해야 하는 숫자를 공백 없이 차례로 나타낸 문자열 (10~15는 A~F로 표현)
	 */
	public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        //숫자 증가(제한 : 미리 구할 숫자의 갯수)
        int order=0;
        for(int i=0; i<(m*t); i++) {	// 참가인원(튜브포함) * round 수
        	
        	//진법변환 : n으로 나누어서 그 나머지를 역순으로 나열한다.
        	int decimal = i;
        	String converted = "";
        	while(decimal>0) {
        		
        		// 두자리 숫자 처리
        		int rest = decimal%n;
        		if(10 <= rest) {
        			switch(rest) {
    				case(10) : rest = 'A';
    				case(11) : rest = 'B';
    				case(12) : rest = 'C';
    				case(13) : rest = 'D';
    				case(14) : rest = 'E';
        			}
        		}
        		
        		converted = rest + converted;
        		decimal /= n;	//1 이후 0까지 도달 후 반복문 탈출
        	}
        	
        	for(int j=0; j<converted.length(); j++) {	//진법변환 한 수의 자릿수만큼 반복
        		if(order%m == p-1) {	// 참가인원들의 순번 중 튜브의 순번과 같은 경우
        			answer += converted.charAt(j);
        		}
        		order++;	//순서 증가
        	}
        	
        }
        
        return answer;
    }
	
	

	public static String solution_2(int n, int t, int m, int p) {
        String answer = "";
        
        int i=0;	//숫자 증가용
        int order=0;	//말할 순번 증가용 :: order=1로 할 경우 order%m == p-1 연산에서 구멍이 생긴다. 유의할 것
        while(t > answer.length()) {	// t개 구할 떄까지 반복
        	
        	//n진수 구하기 >> 함수로 빼는게 깔끔하고 좋았을 듯
        	int decimal = i++;	//decimal(진수변환용 변수)에 넣은 뒤 i 증가
        	String converted = "";
        	while(0 < decimal) {
        		
        		// 두자리 숫자 처리
        		int rest = decimal%n;
        		if(10 <= rest) {
//        			char c = 0;	//char 변환을 위한 변수
        			String s = "";
        			switch(rest) {
    				case(10) : s = "A"; break;	//case-break; 항상 짝꿍임.. break; 안해주면 결과 이상할 때 있음
    				case(11) : s = "B"; break;
    				case(12) : s = "C"; break;
    				case(13) : s = "D"; break;
    				case(14) : s = "E"; break;
    				case(15) : s = "F"; break;
        			}
        			converted = s + converted;
        		}else 
        			converted = rest + converted;
        		
        		decimal /= n;	//1 이후 0까지 도달 후 반복문 탈출
        	}
        	if(0==converted.length()) converted = "0";	//0인경우 while로 진입하지 않으므로 초기값 0 필요	
//        	System.out.println("진수변환 완료 :: " + converted);
        	
        	//구한 n진수를 하나씩 나열하며 튜브 순서 찾기
        	for(int j=0; j<converted.length(); j++) {
        		if(order%m == p-1) {	// 참가인원들의 순번 중 튜브의 순번과 같은 경우
        			answer += converted.charAt(j);
//        			System.out.println("answer >>> " + answer);
        			
        			if(t == answer.length()) break;
        		}
        		order++;	//순서 증가
        	}
        	
        }
        
        return answer;
	}
}
