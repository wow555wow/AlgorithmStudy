package level1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_201013 {

	public static void main(String[] args) {
		
		System.out.println(">>" + solution(45));
//		System.out.println(">>" + solution(125));
	}
	
	
	public static int solution(int n) {
        int answer = 0;
        
        List<Integer> lst = new ArrayList<Integer>();
        while(n >= 3) {
        	lst.add(n%3);
        	n = n/3;
        }
        lst.add(n);
        
        int idx = 1;
        for(int i : lst) {
        	answer += i*Math.pow(3, lst.size()-(idx++));
        }
        
        return answer;
    }
}
