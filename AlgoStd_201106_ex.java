package level1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_201106_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution_2(513));	//124224 (HINT)

	}
	
	
	
	/** 201106 124 나라의 숫자
	 * 
	 * 3진법 변형인 것 같음.
	 * 처음엔 0/1/2 -> 1/2/4 로 변환해서 대입한 뒤 +1 하려고 했지만
	 * 3진법의 1/2는 흐름이 같고 0과 올림수를 잘 처리해주면 될 것 같다는 생각이 들었음.
	 * 
	 * 1. 3진수 변환
	 * 2. 0 -> 4 변환, 올림수 처리
	 * 
	 * 
	 * 진수변환 : n으로 나눈 나머지의 역순 나열
	 *  ㄴ 올림수가 0 다음에 올 것임
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        //3진수 구하기
        int remain = 0;	//나머지
        int round = 0;	//올림수
        while(0 < n) {
        	
        	remain = n%3;
        	n /= 3;
        	
        	if(0 != round) {
        		remain--;
        		if(0 == remain) {
        			if(0 == n) break;
        			remain = 2;
//        			round = 1 ;	//유지
        		}else round = 0;
        	}
        	
        	if(0==remain) {
        		remain = 4;
        		round = 1;
        	}
//        	answer = remain + answer;
        	sb.insert(0, remain);
        	
        }
        
        if(sb.charAt(0) == '0')
        	sb.substring(1);
        answer = sb.toString();
        
        return answer;
    }
	
	/*
	 * 다른 사람의 풀이 
	 *  1. 나머지를 stack에 넣으면서 진법변환 (역순으로 꺼내야 하므로)
	 *  2. 나머지가 0이 나오면 몫에 -1 (올림수 -1처리)
	 *  	+ 나머지를 4로 넣기
	 * 
	 */
	
	
	//나머지처리를 다음 반복문에서 할게 아니라 몫 설정할때 넣어주면 되는거였음
	// StringBuilder 뭔가 편법인 것 같은데 달리 수정할 곳이 없을까? O(log3 n)으로 만들어야 한다고 함
	public static String solution_2(int n) {
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		
		int remain = 0;
		while(0 < n) {
			remain = n%3;
			
			if(0 == remain) {
				n = n/3 -1;
				remain = 4;
			}else n /= 3;
//			answer = remain + answer;
			sb.insert(0, remain);
		}
		answer = sb.toString();
		
		return answer;
	}
	
	
	/*
	 * StringBuilder 사용하지 않고도 1ms대 수행 가능
	 * 
	 public String solution(int n) {
	     String[] num = {"4","1","2"};
	     String answer = "";
	
	     while(n > 0){
	         answer = num[n % 3] + answer;
	         n = (n - 1) / 3;	// n-1이 이해가 안됨
	     }
	     return answer;
  	 }
	 */
	
	
	/*
	 * 재귀로도 풀이가 가능함
	 * 
	 public String change124(int n) {
        String answer = "";

        if (n > 0) {
            int rest = n % 3;
            answer = ((rest == 0) ? "4" : (rest == 1) ? "1" : "2") + answer;
            answer = change124((n-1) / 3) + answer;
        }

        return answer;
    }
	 */
}
