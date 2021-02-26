class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx=0;
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                answer += c;
                idx=0;
                continue;
            }
            
            if(idx++ %2 == 0)
                answer += Character.toUpperCase(c);
            else answer += Character.toLowerCase(c);
        }
        
        return answer;
    }
}
