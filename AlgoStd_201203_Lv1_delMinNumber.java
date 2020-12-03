package level1;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoStd_201203_Lv1_delMinNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	
	//�������� : ���� 1 �̻�, �迭 �� ���� ���ڴ� ����
	// [HINT] �迭 �� ���ҵ��� ������ �ٲ�� �ȵ� 
	public int[] solution(int[] arr) {
        int[] answer = {};
        
        //������ �迭�� �� �迭�� ���(�迭�� ���Ұ� 1���� ���) �迭�� -1�� ��� ����
        if(arr.length == 1) return new int[] {-1};
        
//        Arrays.sort(arr);	//�������� ����
//        
//        answer = new int[arr.length-1];
//        int idx = 0;
//        for(int i=arr.length-2; i>=0; i--)
//        	answer[idx++] = arr[i];
        
        answer = new int[arr.length-1];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
        	if(min > arr[i])
        		min = arr[i];
        }
        
        return answer;
    }
	
	
	public int[] solution_2(int[] arr) {
		int[] answer = {};
		
		//������ �迭�� �� �迭�� ���(�迭�� ���Ұ� 1���� ���) �迭�� -1�� ��� ����
        if(arr.length == 1) return new int[] {-1};
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
        	if(min > arr[i])
        		min = arr[i];
        }
        
        answer = new int[arr.length-1];
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
        	if(min == arr[i]) continue;
        	
        	answer[idx++] = arr[i]; 
        }
		
		return answer;
	}
	
	
	// Collcetions.min(). List.remove�� ����� Ǯ��
	public int[] solution_others(int[] arr) {
	      if (arr.length == 1) {
	            arr[0] = -1;
	            return arr;
	        } else {
	            ArrayList<Integer> arrayList = new ArrayList<Integer>();
	            for (int a : arr) {
	                arrayList.add(a);
	            }
	            Integer minimum = Collections.min(arrayList);
	            arrayList.remove(minimum);
	            int[] resultArray = new int[arr.length - 1];
	            for (int i = 0; i < arrayList.size(); ++i) {
	                resultArray[i] = arrayList.get(i);
	            }
	            return resultArray;
	        }
	  }

}
