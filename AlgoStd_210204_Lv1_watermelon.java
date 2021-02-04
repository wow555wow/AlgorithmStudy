class Solution {
    
    String even = "수";
    String odd = "박";
    
    public String solution(int n) {
        String answer = "";
        
        for(int i=0; i<n; i++) {
            if(0 == i%2)
                answer += even;
            else answer += odd;
        }
        
        return answer;
    }
}
