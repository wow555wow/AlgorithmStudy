package prg;

public class std_210219_1_primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		std_210219_1_primeNumber s = new std_210219_1_primeNumber();
		System.out.println(s.solution(10));
		
	}
	
	// �ð��ʰ� (��������)
	public int solution_timeout(int n) {
        int answer = 0;
        
        if(n < 2) return 0;
        else {
        	for(int i=2; i<=n; i++) {
        		boolean isPrime = true;
            	for(int j=2; j<i; j++) {
            		if(i % j == 0) {
            			isPrime = false;
            			break;
            		}
            	}
            	if(isPrime) answer++;
            }
        }
        
        return answer;
    }
	
	// 1~n ������ ���� �� �Ҽ��� ������ ��ȯ (1�� �Ҽ��ƴ�,  2 <= n <= 1M
	public int solution_(int n) {
		int answer = 0;
		
		if( n <=3 ) return n-1;
		else answer = 2;	// 4 �̻��� ��� �⺻ (2,3)�� ����. 1�� �Ҽ��� �ƴ�
		
		//¦���� 2�� ����� �����Ƿ� �Ҽ��� �� �� ����. Ȧ���� �˻�
		
		
		return answer;
	}
	
	public int solution(int n) {
		int answer = 0;
		
		for(int i=2; i<=n; i++) {
			if(isPrime(i)) { 
				answer++;
//				System.out.println(i);
			}
		}
		
		return answer;
	}
	
	
	//(�ð��ʰ�) ���ڰ� �Ҽ����� �Ǻ� : n�� ���ݱ����� Ȯ��
	
	public boolean isPrime(int n) {
		if(n < 1) return false;
		else if(n <= 3) return true;
		else if(n % 2 == 0) return false;	//2 �̿� ¦���� �Ҽ��� �� �� ���� (����� 2�� ����)
		else if(n > 3) {
//			for(int i=2; i< (n/2); i++) {	//[HINT] �ڱ��ڽ��� �����ϰ� ������ �ʰ��ϴ� ���ڿ��� �������� �������� 0�̵Ǵ� ���ڴ� ���ü��� ����
			for(int i=2; i<= Math.sqrt(n); i++) {	//[HINT] ����� ������ ���� 1~sqrt(n)�� �������� ������� ¦ �� �ϳ��� ������. 
				if( (n % i) == 0 ) return false; 
			}
		}
		
		return true;
	}

}
