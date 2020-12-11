package level2;

public class AlgoStd_201211_Lv2_Fibbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlgoStd_201211_Lv2_Fibbo a = new AlgoStd_201211_Lv2_Fibbo();
		
		System.out.println(a.solution_2(3));
	}
	
	// 20-11-10 ù�õ�
	// ��� -> �̹� ���� �Ǻ���ġ�� �迭�� �����ؼ� �ߺ����� ���� -> bottom up
	// ���̳��� ���α׷���??
	//https://www.youtube.com/watch?v=vYquumk4nWw&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD
	
	//��͸� ����� Ǯ��
	public int solution(int n) {
        int answer = 0;
        
        int fibbo = 0;
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n>=2) {
            fibbo = solution(n-1) + solution(n-2);	//��� ���� ���� ������
        }
        
        if(fibbo < 1234567)
            return fibbo;
        else
            answer = fibbo % 234567;
        
        return answer;
    }
	
	
	/* TC7~ Ʋ���� ���� : �����÷ο� ����
	 * [HINT] �Ǻ���ġ ���� ��û���� ������ �����մϴ�. 44��° �Ǻ���ġ ���� ���� 2,971,215,073�� int ������ �Ѿ�����ϴ�.
	 * 		  (��ⷯ ������ ����) ���� A, B, C�� �ִٰ� �ϸ� (A + B) % C�� ���� ( ( A % C ) + ( B % C) ) % C�� ���ٴ� �����Դϴ�.
	 * 
	 * ���ٿ��: �������� 1234567�� ���� �������� �������� ��������� ���� ������ �� ���� �ƴ϶� int �ڷ����� ���� ���� �׻� ���� ���� �� �ֵ��� �� ����̸�, 
	 * �ڷ����� ũ�⿡ ������ �ִ� �� �� ��� (A + B) % C �� ( ( A % C ) + ( B % C) ) % C��� ������ �̿��ؼ� 
	 * �Ź� ��� ����� 1234567���� ���� �������� ��� �ִ� ������ int ���� ���� �׻� ���� �������� ������ �� �ִ�.
	 * 
	 * ��� : �ڷ����� ������ �׻� �� �����ض�
	 * 
	 * cf) 2�� ���� �����ϱ�
	 * ���� �� 2,147,483,647�� �����ϰ� �ִ� int ������ 1�� ���ϸ� �� ���ڴ� 2,147,483,648�� �ƴ�, -2,147,483,648�� �˴ϴ�
	 * (�̴� 2�� ������� �������� ���ؼ� �߻��ϴµ�, ������ �����ø� ���ۿ��� �˻��غ�����)
	 * 
	 */
	
	//bottom-up ���(�̶�� �����ϰ� Ǯ�)
	public int solution_2(int n) {
		int answer = 0;
		
		int[] fibbo = new int[n+1];
		
		fibbo[0] = 0;
		fibbo[1] = 1;
		for(int i=2; i<=n; i++) {
			fibbo[i] = fibbo[i-1] + fibbo[i-2];
		}
		
		answer = fibbo[n] % 1234567;
		
		return answer;
	}
	
	
	public int solution_3(int n) {
		int answer = 0;
		
		int divisor = 1234567;
		
		int[] restOfFibbo =  new int[n+1];
		
		restOfFibbo[0] = 0;
		restOfFibbo[1] = 1;
		for(int i=2; i<=n; i++) {
			restOfFibbo[i] = restOfFibbo[i-1] + restOfFibbo[i-2];
			
			if(restOfFibbo[i] > divisor) {
				restOfFibbo[i] = (restOfFibbo[i-1] % divisor + restOfFibbo[i-2] % divisor ) % divisor;
			}
		}
		
		answer = restOfFibbo[n];
		return answer;
	}

}
