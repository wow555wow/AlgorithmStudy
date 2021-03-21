package Lv1;

public class AlgoStd_210321_Lv1_GCD_LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlgoStd_210321_Lv1_GCD_LCM a = new AlgoStd_210321_Lv1_GCD_LCM();
		a.solution(3, 12);
	}
	
	/** 210321 최대공약수와 최소공배수
	 * 
	 * 인자 두 수의 최대공약수와 최소공배수 구해서 배열에 담아 리턴
	 * 
	 * 최소공배수 : 두 수의 곱 / 최대공약수
	 * 최대공약수 구하기
	 *  1) 2부터 둘 중 작은 수까지 큰 수를 나눠보기 : O(n)
	 *  2) 유클리드 호제법 : 두 수의 GCD는 큰 수를 작은 수로 나눈 나머지와 작은수의 GCD와 같ㄷㅏ?
	 *   GCD(A,B) = GCD(B, A%B)
	 *   if(A%B == 0) => GCD = B
	 *   else GCD(B, A%B)
	 *   
	 * 
	 * 1. 인자 중 큰 수 판별
	 * 2. 유클리드 호제법으로 GCD 구하기
	 * 3. GCD로 LCM 구하기
	 * 
	 * @param n
	 * @param m
	 * @return [GCD, LCM]
	 */
	public int[] solution(int n, int m) {
        int[] answer = {};
        int gcd, lcm;
        
        if(n==m)
        	return new int[] {n, n};
        
        int dividend=0, divisor=0;	//인자의 범위는 자연수인가?
        if(n>m) { dividend=n; divisor=m; }
        else { dividend=m; divisor=n; }
        
        int quotient = -1;
        while(quotient != 0) {
        	quotient = dividend%divisor;
        	
        	dividend = divisor;
        	divisor = quotient;
        }
        gcd = dividend;
        lcm = n*m / gcd;
        
        answer = new int[] {gcd, lcm};
//        System.out.println("ANSER[" + gcd + ", " + lcm + "]");
        return answer;
    }

}
