package Lv2;

public class AlgoStd_210115_Lv2_presentOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int n) {
        int answer = 1;
        
        if(2 > n) return 1;	// 1, 2�� ���ӵ� �� �� �̻����� ���� �� ����
        
        int divisor = 2;
        while(divisor <= n/2) {	//���� ��� ����
        	if(0 != (n % divisor)) {	//������ �������� �����ϴ� �� ���� ���� �� ����
//            	if(n == n + (n+1)) // ���� ��� ����
        		
        		//��ͷ� ��� �Ҽ�������..
            }
        	divisor++;
        }
        
        return answer;
    }
	
	
	public int solution2(int n) {
		int answer = 0;
		
		int sum = 0;
		int idx = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
			if(sum == n) {
				answer++;
				i=++idx;
				sum=0;
			}else if(sum > n) {
				i=++idx;
				sum=0;
			}
		}
		
		return answer;
	}

}
