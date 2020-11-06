package level1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_201106_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution_2(513));	//124224 (HINT)

	}
	
	
	
	/** 201106 124 ������ ����
	 * 
	 * 3���� ������ �� ����.
	 * ó���� 0/1/2 -> 1/2/4 �� ��ȯ�ؼ� ������ �� +1 �Ϸ��� ������
	 * 3������ 1/2�� �帧�� ���� 0�� �ø����� �� ó�����ָ� �� �� ���ٴ� ������ �����.
	 * 
	 * 1. 3���� ��ȯ
	 * 2. 0 -> 4 ��ȯ, �ø��� ó��
	 * 
	 * 
	 * ������ȯ : n���� ���� �������� ���� ����
	 *  �� �ø����� 0 ������ �� ����
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static String solution(int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        //3���� ���ϱ�
        int remain = 0;	//������
        int round = 0;	//�ø���
        while(0 < n) {
        	
        	remain = n%3;
        	n /= 3;
        	
        	if(0 != round) {
        		remain--;
        		if(0 == remain) {
        			if(0 == n) break;
        			remain = 2;
//        			round = 1 ;	//����
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
	 * �ٸ� ����� Ǯ�� 
	 *  1. �������� stack�� �����鼭 ������ȯ (�������� ������ �ϹǷ�)
	 *  2. �������� 0�� ������ �� -1 (�ø��� -1ó��)
	 *  	+ �������� 4�� �ֱ�
	 * 
	 */
	
	
	//������ó���� ���� �ݺ������� �Ұ� �ƴ϶� �� �����Ҷ� �־��ָ� �Ǵ°ſ���
	// StringBuilder ���� ����� �� ������ �޸� ������ ���� ������? O(log3 n)���� ������ �Ѵٰ� ��
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
	 * StringBuilder ������� �ʰ� 1ms�� ���� ����
	 * 
	 public String solution(int n) {
	     String[] num = {"4","1","2"};
	     String answer = "";
	
	     while(n > 0){
	         answer = num[n % 3] + answer;
	         n = (n - 1) / 3;	// n-1�� ���ذ� �ȵ�
	     }
	     return answer;
  	 }
	 */
	
	
	/*
	 * ��ͷε� Ǯ�̰� ������
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
