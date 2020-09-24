package level1;

public class AlgoStd_200925 {

	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}
	
	/* 가운데 글자 가져오기 */
	public static String solution(String s) {
        String answer = "";
        
        int centerIdx = (s.length() -1) / 2;
        answer = s.length() % 2 == 0 ? s.substring(centerIdx, centerIdx+2) : s.substring(centerIdx, centerIdx+1);
        
        return answer;
    }

}
