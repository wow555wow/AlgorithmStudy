package level1;

public class AlgoStd_201022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(solution(5, new int[] {9, 20, 28, 18, 11}, new int [] {30, 1, 21, 17, 28}));
		System.out.println(solution(6, new int[] {46,  33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10}));
		

	}
	
	/** 비밀지도 (2018 카카오 블라인드 채용)
	 * 
	 * 1. 정수배열의 각 원소를 2진수로 변경 (0:공백, 1:벽) < bit연산하면 이진수 변경이 필요없나?
	 * 2. 첫번째 배열과 두번째 배열의 값을 비교 (bit연산?), 모두 공백인 경우에만 진짜 공백(|)
	 * 3. 벽(#), 공백( )의 문자열 배열로 출력
	 * 
	 * ? 0 <= x <= 2^n -1 : 이 조건은 왜 있는ㄴ거지? :: 자리수 맞추려고!!
	 * 
	 * **/
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        
        answer = new String[n];
        int[] map = new int[n];	//진짜 지도
        for(int i=0; i<n; i++) {
        	map[i] = arr1[i] | arr2[i];
        	System.out.println("arr1[" + arr1[i] + "] arr2[" + arr2[i] + "] map[" + map[i] + "]");
        	System.out.println("arr1[" + Integer.toBinaryString(arr1[i]) + "] arr2[" + Integer.toBinaryString(arr2[i]) + "] map[" + Integer.toBinaryString(map[i]) + "]");
//        	answer[i] = 0 == arr1[i] | arr2[i] ? ""
//        	answer[i] = String.format("%0" + n + "d", Integer.toBinaryString(map[i]));	// d != String
//        	answer[i] = String.format("%0" + n + "d", Integer.parseInt(String.valueOf(map[i]), 2));	// "63" under radix 2 : ??
//        	answer[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(map[i])));	// int 범위를 넘어가서 tc2, 6에서 런타임에러 발생
        	answer[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(map[i])));
        	System.out.println("answer[" + answer[i] + "]");
//        	char[] binStr = Integer.toBinaryString(map[i]).toCharArray();
        	char[] binStr = answer[i].toCharArray();
        	for(int j=0; j<n; j++) {
        		binStr[j] = '0' == binStr[j] ? ' ' : '#';
        		System.out.print(binStr[j]);
        	}
        	System.out.println();
        	
        	answer[i] = String.valueOf(binStr);
        	System.out.println(">>>" + answer[i]);
        }
        
        return answer;
    }

}
