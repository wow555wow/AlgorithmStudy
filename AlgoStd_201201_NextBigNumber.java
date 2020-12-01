package level2;

public class AlgoStd_201201_NextBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201201_NextBigNumber a = new AlgoStd_201201_NextBigNumber();
		System.out.println(a.solution(78));

	}
	
	
	/** Lv2. 다음 큰 숫자
	 * 
	 * n보다 크고, 2진수 변환 시 1의 갯수가 n과 같아야 함.
	 * 이 중 가장 작은 수
	 * 
	 * 1을 어떻게 자리바꿈 해줘야 할지?
	 * 
	 * 단순하게 가자
	 * 숫자 증가시키면서 1의 갯수 검사하기
	 * 
	 * 78(1001110) -> 83(1010011)
	 * 
	 * @param n
	 * @return
	 */
	public int solution(int n) {
        int answer = 0;
        
        int target = 0;
//        String converted = String.valueOf(Integer.toBinaryString(n));
        String converted = Integer.toBinaryString(n);	//자동변환됨
        for(int i=0; i<converted.length(); i++) {
        	if('1' == converted.charAt(i))
        		target++;
        }
//        Integer.bitCount(n);	//n을 binary로 변환 후 1의 숫자를 반환함. #34-#38 라인 치환 가능
        
        int cnt = 0;
        while(true) {
        	converted = String.valueOf(Integer.toBinaryString(++n));
        	
        	for(int i=0; i<converted.length(); i++) {
            	if('1' == converted.charAt(i))
            		cnt++;
            }
        	
//        	System.out.println("target: " + target + ", cnt: " + cnt);
        	if(target == cnt)
        		break;
//        		return n;
        	cnt=0;
        }
        
        answer = n;
        return answer;
    }

	
	
	//bit연산자를 사용한 풀이
	public int nextBigNumber(int n) {
		int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}
