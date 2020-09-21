package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlgoStd_200921 {

	public static void main(String[] args) {

		System.out.println("[q1_sol] :: " + q1_sol("aqdfA"));
	}
	
	/** Q1. 문자열 내림차순으로 배치하기
	 * 영문 대소문자 정렬, z>a, 소문자>대문자 */
//	public String q1(String s) {	//틀림
//		
//		String answer = "";
//		char[] arr = s.toCharArray();
////		char[] arr = new char[s.length()];
////		for(int i=0; i<s.length(); i++)
////			arr[i] = s.charAt(i);
//		
//		//selection sort
//		int indexMax; char temp;
//		for(int i=0; i<s.length()-1; i++) {
//			indexMax = i;
//			for(int j=i+1; j<s.length(); j++) {
//				if(arr[j] > arr[indexMax])
//					indexMax = j;
//			}
//			
//			temp = arr[indexMax];
//			arr[indexMax] = arr[i];
//			arr[i] = arr[indexMax];
//			
//			answer += arr[i];
//			if(i == s.length()-2)
//				answer += arr[i+1];
//		}
//		return answer;
//	}
	
	public static String q1_sol(String s) {
		String[] sa = s.split("");
		Arrays.sort(sa);	//오름차순 정렬
		Arrays.sort(sa, Collections.reverseOrder());	//내림차순 정렬
		
		return String.join("", sa);
	}
	
	/** Q2. 문자열 다루기 기본
	 * 문자열 길이가 4 혹은 6이고 숫자로만 구성되어 있는지 확인 (s는 길이 1-8) */
	public boolean q2(String s) {
		
		if(s.length() == 4 || s.length() == 6) {
			char[] arr = s.toCharArray();
			for(char c : arr) {
				if(c < (char) '0' || c > (char) '9')	//Character.isDigit(char c) << 숫자여부확인함수
					return false;
			}
		}else 
			return false;
		
		return true;
	}
	
	public boolean q2_sol1(String s) {
		if(s.length() == 4 || s.length() == 6) {
			try {
				int x = Integer.parseInt(s);	//parseDoble은 오류 발생한다고 함. s의 길이 == 1-8 이라는 조건이 필요한 이유인듯.
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}else
			return false;
	}
	
	public boolean q2_sol2(String s) {
		if(s.length() == 4 || s.length() == 6)
			return s.matches("(^[0-9]*$)");	//정규식을 이용한 풀이
		return false;
	}
	
	public boolean q2_sol3(String s) {
		return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
	}

	
	/** Q3. 문자열 내 마음대로 정렬하기 
	 * 소문자 알파벳으로 이루어진 문자열을 index 기준으로 정렬, 같은 경우 사전순서대로 출력
	 * 1 <= strings.length <= 50
	 */
//	public String[] q3(String[] strings, int n) {
//		// index 문자 기준 정렬 후 사전순서 정렬
////		Arrays.sort(char[] a, int fromIndex, int toIndex);
//		
//		
//		for(int i=0; i<strings.length; i++) {
//			
//		}
//	}
	
//	public String[] q3_sol1(String strings, int n) {	// 해설 후 작성
//		// 사전순서로 선정렬 후 index 기준 정렬
//	}
	
	public String[] q3_sol2(String[] strings, int n) {	//구글링한 내용
		// index 위치의 문자를 문자열에 붙여 정렬한 뒤 index 문자 삭제 후 재정렬
		String[] answer = {};
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0; i<strings.length; i++) {
			arr.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(arr);
		
		answer = new String[arr.size()];
		for(int i=0; i<arr.size(); i++)
			answer[i] = arr.get(i).substring(1);
		return answer;
	}
}
