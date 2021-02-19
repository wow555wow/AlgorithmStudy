package prg;

public class std_210219_1_primeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		std_210219_1_primeNumber s = new std_210219_1_primeNumber();
		System.out.println(s.solution(10));
		
	}
	
	// 시간초과 (전수조사)
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
	
	// 1~n 사이의 숫자 중 소수의 갯수를 반환 (1은 소수아님,  2 <= n <= 1M
	public int solution_(int n) {
		int answer = 0;
		
		if( n <=3 ) return n-1;
		else answer = 2;	// 4 이상인 경우 기본 (2,3)을 가짐. 1은 소수가 아님
		
		//짝수는 2를 약수로 가지므로 소수가 될 수 없음. 홀수만 검사
		
		
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
	
	
	//(시간초과) 인자가 소수인지 판별 : n의 절반까지만 확인
	
	public boolean isPrime(int n) {
		if(n < 1) return false;
		else if(n <= 3) return true;
		else if(n % 2 == 0) return false;	//2 이외 짝수는 소수가 될 수 없음 (약수로 2를 가짐)
		else if(n > 3) {
//			for(int i=2; i< (n/2); i++) {	//[HINT] 자기자신을 제외하고 절반을 초과하는 숫자에서 나눴을때 나머지가 0이되는 숫자는 나올수가 없다
			for(int i=2; i<= Math.sqrt(n); i++) {	//[HINT] 약수를 가지는 수는 1~sqrt(n)의 범위에서 약수들의 짝 중 하나를 가진다. 
				if( (n % i) == 0 ) return false; 
			}
		}
		
		return true;
	}

}
