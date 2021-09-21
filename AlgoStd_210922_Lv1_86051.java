class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        answer = 0;
        boolean isContained = false;
        for(int i=0; i<=9; i++) {
            for(int v : numbers) {
                if(i==v) {
                    isContained = true;
                    break;
                }
            }
            if(isContained) isContained = false;
            else {
                answer += i;
            }
        }
        return answer;
    }
}
