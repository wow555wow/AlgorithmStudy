package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class AlgoStd_200922 {

	public static void main(String[] args) {

	}
	
	/** 나누어 떨어지는 숫자 배열 */
	public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> aliquots = new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i] % divisor == 0)
        		aliquots.add(arr[i]);
        }
        
        if(aliquots.isEmpty())
        	return new int[] {-1};
        	
//        aliquot.toArray(answer);
        answer = new int[aliquots.size()];
        int i=0;
        for(int aliquot : aliquots) {
        	answer[i++] = aliquot;
        }
        
        Arrays.sort(answer);
        return answer;
    }

}
