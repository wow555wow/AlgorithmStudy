class Solution {
    
    String WM_EVEN = "수";
    String WM_ODD = "박";
    
    public String solution(int n) {
        String answer = "";
        
        for(int i=0; i<n; i++) {
            if(0 == i%2)
                answer += WM_EVEN;
            else answer += WM_ODD;
        }
        
        return answer;
    }
}
