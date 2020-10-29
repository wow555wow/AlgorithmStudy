import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);	//오름차순 정렬
        
        int sum=0;
        for(int i : d) {
        	if(budget >= sum+i) {
                sum += i;
                answer++;
            }
        	else break;
        }
        
        return answer;
    }
}

// 가장 작은 수부터 차례로 넣는게 정답이었는데 아닐거라고 생각해서 헤맸음
