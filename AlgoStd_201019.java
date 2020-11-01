package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AlgoStd_201019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(118372));

	}
	
	public static long solution(long n) {
		long answer = 0;
		
        char[] ca = String.valueOf(n).toCharArray();
//        Arrays.sort(ca, Collections.reverseOrder());
//        Arrays.sort(ca, new Comparator<int>() {
//
//			@Override
//			public int compare(char arg0, char arg1) {
//				// TODO Auto-generated method stub
//				return arg1 - arg0;
//			}
//		});
        answer = Long.parseLong(String.valueOf(ca));
        
        return answer;
    }

	
	///2t
	/*
	 * 정수 n을 자릿수대로 나누어서
	 * 정렬하고
	 * 다시 숫자로 만들어서 리턴
	 */
	public static long solution2(long n) {
		
		String[] sa = String.valueOf(n).split("");
		Arrays.sort(sa, Collections.reverseOrder());
		
		String converted ="";
		for(String s : sa)
			converted += s;

		return Long.parseLong(converted);
	}
	
	
	/* 다른 사람의 풀이
	 *  무슨뜻인지도 해석이 잘 안됨..
	 */
	String res = "";
	public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
	
	/*
	 * 이 외 정렬 후 역순으로 문자열 더하기(StringBuilder.reverse() 사용)
	 * 10으로 나누면서 몫을 문자열에 더해서 숫자를 배열로 변경 (Vector 사용함...)
	 * 
	 */
}
