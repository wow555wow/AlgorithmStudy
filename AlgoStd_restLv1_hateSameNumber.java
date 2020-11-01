package level1;

import java.util.*;

public class AlgoStd_restLv1_hateSameNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(new int[] {1, 1, 3, 3, 0, 1, 1}));

	}
	
	public static int[] solution(int []arr) {
        int[] answer = {};
        
//        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++) {
        	if(0==i)
        		list.add(arr[i]);
        	else if(arr[i-1] != arr[i])
                list.add(arr[i]);
        }
        
//        answer = list.toArray(new Integer[0]);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
//        	System.out.println("i:" + i + ", list.get(i): " + list.get(i));
        }

        return answer;
    }

}
