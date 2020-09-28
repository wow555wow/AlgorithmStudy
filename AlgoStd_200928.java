package level1;

public class AlgoStd_200928 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("AB", 1));
		System.out.println(solution("z", 1));
		System.out.println(solution("Z", 10));
		System.out.println(solution("a B z", 4));
		System.out.println(solution("a BZ", 20));
		System.out.println(solution("y X Z", 4));
		System.out.println(solution(". h z", 20));
	}
	
	public static String solution(String s, int n) {
        String answer = "";
        
        char[] caesar = new char[s.length()];
        int i=0;
        for(char c : s.toCharArray()) {
        	char moved;
            if(Character.isAlphabetic(c)) {	//대문자가 소문자가 될 수 있음
            	moved = (char) (c + n);
            	if((Character.isUpperCase(c) && moved > 'Z' )|| moved > 'z') {
            		moved -= 26;
//            	}else {
            		
            	}
//            	moved = (char) (c + n);
//            	if(!Character.isAlphabetic(moved))
//            		moved -= 26;
            }
//            	moved = c;
            else {
            	moved = c;
//            	moved = (char) (c + n);
//            	if((moved > 'Z' && moved < 'a') || moved > 'z') {
//            		moved -= 26;
//            	}
            }
            caesar[i++] = moved;
        }
        answer = String.valueOf(caesar);
        return answer;
    }

}
