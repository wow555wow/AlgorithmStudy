package level1;

public class AlgoStd_201009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        
	        if(0==n) return 0;
	        
	        for(int i=1; i<=n; i++) {
	            if(n%i == 0) answer += i;
	        }
	        
	        return answer;
	    }
	}

}
