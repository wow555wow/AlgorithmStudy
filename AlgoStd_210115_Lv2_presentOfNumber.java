package Lv2;

public class AlgoStd_210115_Lv2_presentOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int n) {
        int answer = 1;
        
        if(2 > n) return 1;	// 1, 2는 연속된 두 수 이상으로 만들 수 없음
        
        int divisor = 2;
        while(divisor <= n/2) {	//증명 어떻게 하지
        	if(0 != (n % divisor)) {	//나누어 떨어지면 연속하는 두 수로 만들 수 없음
//            	if(n == n + (n+1)) // 수열 어떻게 구해
        		
        		//재귀로 어떻게 할수없을까..
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
