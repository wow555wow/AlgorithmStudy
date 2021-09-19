class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long curPrice = price;
        
        while (count > 1) {
            curPrice += price * count;
            count--;
        }
        
        
        if(curPrice > money)
            answer = curPrice - money;
        else answer = 0;

        return answer;
    }
}
