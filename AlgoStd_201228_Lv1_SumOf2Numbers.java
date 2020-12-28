import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        ArrayList<Integer> sumComb = new ArrayList<Integer>();
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(!sumComb.contains(sum))
                    sumComb.add(sum);
                }
        }
        
        int[] answer = new int[sumComb.size()];
        for(int i=0; i<sumComb.size(); i++)
            answer[i] = sumComb.get(i);
        
        Arrays.sort(answer);
            
//        int[] answer = {};
        return answer;
    }
}
