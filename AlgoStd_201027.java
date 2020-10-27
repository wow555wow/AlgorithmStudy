package level1;

public class AlgoStd_201027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 1S 2D* 3T 이렇게 잘라서
	// 자른애들끼리 숫자*문자*옵션 연산
	
	public static int solution(String dartResult) {
        int answer = 0;
        
//        dartResult.split("[S|D|T|*|#", 1);
//        dartResult.substring(dartResult.indexOf(str));
        
        char[] ca = dartResult.toCharArray();
        
//        for(char c : ca) {
        int score=0;
        int pow=0;
        // 옵션처리
        for(int i=0; i<ca.length; i++) {
        	if(Character.isDigit(ca[i])) {
        		if("0".equals(ca[i])) continue;
        		else if("1".equals(ca[i])) {
        			score = Character.isDigit(ca[i]) ? 10 : 1;
        		}else score = Integer.parseInt(String.valueOf(ca[i]));
        			
        	}else if("SDT".indexOf(ca[i]) > -1) {
        		if("S".equals(ca[i])) pow = 1;
        		else if("D".equals(ca[i])) pow = 2;
        		else if("T".equals(ca[i])) pow = 3;
        		
        		score = (int) Math.pow(score, pow);
        	}else if("*#".indexOf(ca[i]) > -1) {
        		
        	}
        }
        
        return answer;
    }

}
