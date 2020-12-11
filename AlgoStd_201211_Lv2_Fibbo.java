package level2;

public class AlgoStd_201211_Lv2_Fibbo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlgoStd_201211_Lv2_Fibbo a = new AlgoStd_201211_Lv2_Fibbo();
		
		System.out.println(a.solution_2(3));
	}
	
	// 20-11-10 첫시도
	// 재귀 -> 이미 구한 피보나치를 배열에 저장해서 중복연산 막기 -> bottom up
	// 다이나믹 프로그래밍??
	//https://www.youtube.com/watch?v=vYquumk4nWw&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD
	
	//재귀를 사용한 풀이
	public int solution(int n) {
        int answer = 0;
        
        int fibbo = 0;
        if(n==0) return 0;
        else if(n==1) return 1;
        else if(n>=2) {
            fibbo = solution(n-1) + solution(n-2);	//재귀 쓰면 성능 개구리
        }
        
        if(fibbo < 1234567)
            return fibbo;
        else
            answer = fibbo % 234567;
        
        return answer;
    }
	
	
	/* TC7~ 틀리는 이유 : 오버플로우 때문
	 * [HINT] 피보나치 수는 엄청나게 빠르게 증가합니다. 44번째 피보나치 수만 가도 2,971,215,073로 int 범위를 넘어버립니다.
	 * 		  (모듈러 연산의 성질) 숫자 A, B, C가 있다고 하면 (A + B) % C의 값은 ( ( A % C ) + ( B % C) ) % C와 같다는 성질입니다.
	 * 
	 * 한줄요약: 문제에서 1234567로 나눈 나머지를 정답으로 내놓으라는 것은 문제를 꼰 것이 아니라 int 자료형의 범위 내에 항상 값이 있을 수 있도록 한 배려이며, 
	 * 자료형의 크기에 제한이 있는 언어를 쓸 경우 (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C라는 성질을 이용해서 
	 * 매번 계산 결과에 1234567으로 나눈 나머지를 대신 넣는 것으로 int 범위 내에 항상 값이 존재함을 보장할 수 있다.
	 * 
	 * 결론 : 자료형의 범위를 항상 잘 생각해라
	 * 
	 * cf) 2의 보수 공부하기
	 * 예를 들어서 2,147,483,647을 저장하고 있는 int 변수에 1을 더하면 그 숫자는 2,147,483,648이 아닌, -2,147,483,648이 됩니다
	 * (이는 2의 보수라는 개념으로 인해서 발생하는데, 관심이 있으시면 구글에서 검색해보세요)
	 * 
	 */
	
	//bottom-up 방식(이라고 생각하고 풀어봄)
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
