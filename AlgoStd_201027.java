package level1;

public class AlgoStd_201027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution3("1D2S#10S"));
	}
	
	// 1S 2D* 3T �̷��� �߶�
	// �ڸ��ֵ鳢�� ����*����*�ɼ� ����
	
	/**
	 * ��Ʈ ���� : 2018 īī�� ����ε� ä��
	 * @param dartResult
	 * @return
	 */
	public static int solution(String dartResult) {
        int answer = 0;
        
//        dartResult.split("[S|D|T|*|#", 1);
//        dartResult.substring(dartResult.indexOf(str));
        
        char[] ca = dartResult.toCharArray();	//charAt(idx)�� ����ϸ� �迭�� �������� �ʾƵ� ��
        
//        for(char c : ca) {
        int score=0;
        int pow=0;
        int[] roundScore = new int[3];	//�ܰ躰 3ȸ��
        // �ɼ�ó��
        for(int i=0; i<ca.length; i++) {
        	if(Character.isDigit(ca[i])) {
        		if("0".equals(ca[i])) continue;
        		else if("1".equals(ca[i])) {
        			score = Character.isDigit(ca[i+1]) ? 10 : 1;	//���� �ڿ� ������ ���� �ѹ��� ���� �Ǿ� ����
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
	 * ��Ʈ ����
	 * 3���� ��ȸ
	 * ���� : 0~10(���ڸ����� ����)
	 * �������� : 1~3����
	 * �ɼ� : * : ��������, �ٷ� �� ���� x2
	 * 		# : �ش� ���� ���̳ʽ�(-)
	 * 
	 * ������ �ʼ�, �ɼ��� ����
	 * 
	 * regex�� �غ��������
	 * 0~10 : 10�� �������� ���� �׳� 1�ڸ� �Ǵ� ���ڸ� ������ ���ð����� ���� : [0-9][0]?[SDT][\*#]
	 * ��������1
	 * ��������1
	 *  ==> 
	 * 
	 * @param dartResult
	 * @return
	 */
	public static int solution_2(String dartResult) {
        int answer = 0;
        
        int[] scoreArray = new int[3];	//3���� ��ȸ
        
//        String[] roundResults = dartResult.split("[0-9][0]?[SDT][*#]?");	//split�ϸ� �ش� ���ڿ��� �����;
//        dartResult.matches // boolean���� ��ġ���θ� ������ �Ф�
//        
//        int idx = 0;
//        for(String roundResult : roundResults) { // �ܰ躰�� ������
////        	for(int i=0; i<roundResult.length(); i++) {
////        		if(Character.isDigit( roundResult.charAt(i) )) {
////        			
////        		}
////        	}
//        	// ���� / ����+�ɼ� ���� ������
//        	roundResult.split("[0-)
//        }
        
        
        
        return answer;
	}
	
	
	//3t
	/*
	 * �� ���ڷ� �ڸ� �� ����/���� �˻��Ͽ� ������� �� ��
	 * '*' �ɼ�ó���� ���� (���� �ܰ� ������ ���� �ʿ�) �ܰ躰 ���� �迭 ���� (���� �ܰ� ���� ������ �־ �ɱ�?)
	 * ���� ����Ͽ� ���� (�Ǵ� �ܰ躰 ����Ͽ� ���� > ���� ����ϴ°� �������
	 */
	public static int solution3(String dartResult) {
        int answer = 0;
        
//        int pastScore = 0;	//���� ������ ����
//        int roundScore = 0;	//���� ������ ����
        int idx = -1; 	//idx�� -1���� �����ϸ� ���ڰ� ���� �� idx�� ������ų �� �ִ�
        int[] score = new int[3];	// ���庰 ����
        
        for(int i=0; i<dartResult.length(); i++) {
        	char curChar = dartResult.charAt(i);
        	System.out.print(curChar);
        	if(Character.isDigit(curChar)) {
        		if('1' == curChar && Character.isDigit(dartResult.charAt(i+1))) {	//���� �ڿ� ������ ���� �Ѱ��� �ð���
        			score[++idx] = 10;
        			i++;	//������ �� 0�� ó������ �ʵ��� �ؾ� ��
        		}else
        			score[++idx] = Integer.parseInt(dartResult.substring(i, i+1));
//        		Character.getNumericValue(ch);	//����: char to num
        		
        	}else {
        		if(-1 < "SDT".indexOf(curChar)) {	//����ó��
            		int power = 1;
            		switch(curChar) {
            		case 'S' : break;
            		case 'D' : power = 2; break;
            		case 'T' : power = 3; break;
            		default :
            		}
            		score[idx] = (int) Math.pow(score[idx], power);
            		
            	}else if(-1 < "*#".indexOf(curChar)) {	//if�� ���� �� ���� 1�� switch�� �ϴ°� ������
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
        
        //���� �հ�
        for(int roundScore : score) {
        	answer += roundScore;
        }
        
        
        return answer;
	}

}
