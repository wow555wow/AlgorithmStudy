class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long longNum = (long) num;
        while(longNum != 1) {
            if(answer == 500) return -1;
            if(0 == longNum % 2) longNum = longNum / 2;
            else longNum = (longNum * 3) + 1;
            answer++;
        }
        
        return answer;
    }
}
