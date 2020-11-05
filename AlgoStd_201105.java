import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int startIdx = 0;
        int endIdx = k;
        
        while(answer.length() < number.length() -k) {
            int max=0;
            
            for(int i=startIdx; i<=endIdx; i++) {
                int cur = Character.digit(number.charAt(i), 10);    //진수변환?
                
                if(9 == cur) {
                    max = cur;
                    startIdx = i+1;
                    break;
                }
                
                if(max < cur) {
                    max = cur;
                    startIdx = i+1;
                }
            }
            
            answer += max;
            max=0;
            endIdx++;
        }
        
        return answer;
    }
}
