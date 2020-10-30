package level2;

public class AlgoStd_201030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		solution_2(2, 4, 2, 1);
		solution_2(16, 16, 2, 1);

	}
	
	
	/* ������ȯ ����
	 * 10���� -> n���� ��ȯ : String.toBinaryString ��
	 * n���� -> 10���� ��ȯ : Integer.parseInt(i, n);
	 */
	
	
	/** [3��] n���� ���� : n���� ���ڸ� ���ʷ� ���Ѵ�. �ڸ����� ��� ����
	 * 
	 * elaps : 22:30 ~ 
	 * 
	 * @param n : ����
	 * @param t : �̸� ���� ������ ����(Ʃ�갡 ����)
	 * @param m : ���ӿ� �����ϴ� �ο�
	 * @param p : Ʃ���� ����
	 * @return : Ʃ�갡 ���ؾ� �ϴ� ���ڸ� ���� ���� ���ʷ� ��Ÿ�� ���ڿ� (10~15�� A~F�� ǥ��)
	 */
	public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        //���� ����(���� : �̸� ���� ������ ����)
        int order=0;
        for(int i=0; i<(m*t); i++) {	// �����ο�(Ʃ������) * round ��
        	
        	//������ȯ : n���� ����� �� �������� �������� �����Ѵ�.
        	int decimal = i;
        	String converted = "";
        	while(decimal>0) {
        		
        		// ���ڸ� ���� ó��
        		int rest = decimal%n;
        		if(10 <= rest) {
        			switch(rest) {
    				case(10) : rest = 'A';
    				case(11) : rest = 'B';
    				case(12) : rest = 'C';
    				case(13) : rest = 'D';
    				case(14) : rest = 'E';
        			}
        		}
        		
        		converted = rest + converted;
        		decimal /= n;	//1 ���� 0���� ���� �� �ݺ��� Ż��
        	}
        	
        	for(int j=0; j<converted.length(); j++) {	//������ȯ �� ���� �ڸ�����ŭ �ݺ�
        		if(order%m == p-1) {	// �����ο����� ���� �� Ʃ���� ������ ���� ���
        			answer += converted.charAt(j);
        		}
        		order++;	//���� ����
        	}
        	
        }
        
        return answer;
    }
	
	

	public static String solution_2(int n, int t, int m, int p) {
        String answer = "";
        
        int i=0;	//���� ������
        int order=1;	//���� ���� ������
        while(t > answer.length()) {	// t�� ���� ������ �ݺ�
        	
        	//n���� ���ϱ�
        	int decimal = i++;	//decimal(������ȯ�� ����)�� ���� �� i ����
        	String converted = "";
        	while(0 < decimal) {
        		
        		// ���ڸ� ���� ó��
        		int rest = decimal%n;
        		if(10 >= rest) {
        			switch(rest) {
    				case(10) : rest = 'A';
    				case(11) : rest = 'B';
    				case(12) : rest = 'C';
    				case(13) : rest = 'D';
    				case(14) : rest = 'E';
        			}
        		}
        		
        		converted = rest + converted;
        		decimal /= n;	//1 ���� 0���� ���� �� �ݺ��� Ż��
        	}
        	if(0==converted.length()) converted = "0";	//0�ΰ�� while�� �������� �����Ƿ� �ʱⰪ 0 �ʿ�	
        	System.out.println("������ȯ �Ϸ� :: " + converted);
        	
        	
        	//���� n������ �ϳ��� �����ϸ� Ʃ�� ���� ã��
        	for(int j=0; j<converted.length(); j++) {
        		System.out.println("order[" + order + "] people[" + m + "] tube_order[" + (p) + "]");
        		if(order%m == p) {	// �����ο����� ���� �� Ʃ���� ������ ���� ���
        			answer += converted.charAt(j);
        			System.out.println("answer >>> " + answer);
        			
        			if(t == answer.length()) break;
        		}
        		order++;	//���� ����
        	}
        	
        }
        
        return answer;
	}
}