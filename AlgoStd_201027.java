package level1;

public class AlgoStd_201027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution3("1D2S#10S"));
	}
	
	// 1S 2D* 3T 이렇게 잘라서
	// 자른애들끼리 숫자*문자*옵션 연산
	
	/**
	 * 다트 게임 : 2018 카카오 블라인드 채용
	 * @param dartResult
	 * @return
	 */
	public static int solution(String dartResult) {
        int answer = 0;
        
//        dartResult.split("[S|D|T|*|#", 1);
//        dartResult.substring(dartResult.indexOf(str));
        
        char[] ca = dartResult.toCharArray();	//charAt(idx)를 사용하면 배열을 선언하지 않아도 됨
        
//        for(char c : ca) {
        int score=0;
        int pow=0;
        int[] roundScore = new int[3];	//단계별 3회뿐
        // 옵션처리
        for(int i=0; i<ca.length; i++) {
        	if(Character.isDigit(ca[i])) {
        		if("0".equals(ca[i])) continue;
        		else if("1".equals(ca[i])) {
        			score = Character.isDigit(ca[i+1]) ? 10 : 1;	//숫자 뒤에 무조건 문자 한번은 오게 되어 있음
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
	
	
	// 2t
	/**
	 * 다트 게임
	 * 3번의 기회
	 * 점수 : 0~10(두자리수도 가능)
	 * 점수제곱 : 1~3제곱
	 * 옵션 : * : 지금점수, 바로 앞 점수 x2
	 * 		# : 해당 점수 마이너스(-)
	 * 
	 * 제곱은 필수, 옵션은 선택
	 * 
	 * regex로 해보고싶은데
	 * 0~10 : 10에 집착하지 말고 그냥 1자리 또는 두자리 정수가 들어올것으로 생각 : [0-9][0]?[SDT][\*#]
	 * 고정문자1
	 * 가변문자1
	 *  ==> 
	 * 
	 * @param dartResult
	 * @return
	 */
	public static int solution_2(String dartResult) {
        int answer = 0;
        
        int[] scoreArray = new int[3];	//3번의 기회
        
//        String[] roundResults = dartResult.split("[0-9][0]?[SDT][*#]?");	//split하면 해당 문자열이 사라짐;
//        dartResult.matches // boolean으로 일치여부만 리턴함 ㅠㅠ
//        
//        int idx = 0;
//        for(String roundResult : roundResults) { // 단계별로 나누기
////        	for(int i=0; i<roundResult.length(); i++) {
////        		if(Character.isDigit( roundResult.charAt(i) )) {
////        			
////        		}
////        	}
//        	// 점수 / 제곱+옵션 으로 나누기
//        	roundResult.split("[0-)
//        }
        
        
        
        return answer;
	}
	
	
	//3t
	/*
	 * 각 문자로 자른 뒤 숫자/문자 검사하여 점수계산 할 것
	 * '*' 옵션처리를 위해 (이전 단계 점수에 연산 필요) 단계별 점수 배열 선언 (이전 단계 점수 변수만 있어도 될까?)
	 * 총점 계산하여 리턴 (또는 단계별 계산하여 리턴 > 총점 계산하는게 쉬울듯함
	 */
	public static int solution3(String dartResult) {
        int answer = 0;
        
//        int pastScore = 0;	//이전 라운드의 점수
//        int roundScore = 0;	//현재 라운드의 점수
        int idx = -1; 	//idx를 -1부터 시작하면 숫자가 나올 때 idx를 증가시킬 수 있다
        int[] score = new int[3];	// 라운드별 점수
        
        for(int i=0; i<dartResult.length(); i++) {
        	char curChar = dartResult.charAt(i);
        	System.out.print(curChar);
        	if(Character.isDigit(curChar)) {
        		if('1' == curChar && Character.isDigit(dartResult.charAt(i+1))) {	//숫자 뒤에 무조건 문자 한개는 올것임
        			score[++idx] = 10;
        			i++;	//다음에 올 0을 처리하지 않도록 해야 함
        		}else
        			score[++idx] = Integer.parseInt(dartResult.substring(i, i+1));
//        		Character.getNumericValue(ch);	//참조: char to num
        		
        	}else {
        		if(-1 < "SDT".indexOf(curChar)) {	//제곱처리
            		int power = 1;
            		switch(curChar) {
            		case 'S' : break;
            		case 'D' : power = 2; break;
            		case 'T' : power = 3; break;
            		default :
            		}
            		score[idx] = (int) Math.pow(score[idx], power);
            		
            	}else if(-1 < "*#".indexOf(curChar)) {	//if로 나눌 것 없이 1개 switch로 하는게 나은듯
            		if('*' == curChar) {
            			if(0 != idx)
            				score[idx-1] *= 2;
            			score[idx] *= 2;
            		}else if('#' == curChar) {
            			score[idx] *= -1;
            		}
            	}
        	}
        }
        
        //점수 합계
        for(int roundScore : score) {
        	answer += roundScore;
        }
        
        
        return answer;
	}

}
