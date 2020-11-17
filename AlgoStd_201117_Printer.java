package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AlgoStd_201117_Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/** 프린터 (우선순위큐)
	 * 우선순위가 가장 높은 문서부터 출력한다
	 * 
	 * !!! 어떻게 풀이할지 정리를 먼저 한다
	 * !!! edge point ㅠㅠ를 찾는다
	 * !!! 무작정 코드를 작성하지 않는다!!!
	 * 
	 * 1. array에 우선순위가 높은 순으로 배열인덱스를 넣어준다
	 * 2. 인덱스 순서대로 출력한다
	 * 3. location이 정렬한 배열에 몇번째 인덱스에 들어있는지 찾는다
	 * 
	 * ㅡㅡㅡ
	 * idx와 우선순위값을 같이 갖고있어야 할것같다
	 * 아니면 우선순위대로 idx를 정렬한 배열/list가 필요함
	 * 
	 * 1. 한번 loop 돌면서 우선순위 값 정렬하기 : O(n)
	 * 2. 우선순위값을 줄이면서 값비교하면서 출력 : O(n?)
	 * 3.
	 * 
	 * 
	 * 우선순위큐 > heap으로 구현
	 * 
	 * @param priorities
	 * @param location
	 * @return
	 */
	public int solution_3(int[] priorities, int location) {
		
		/*
        int[][] sorted = new int[priorities.length][2];
		
		int idx = 0;
		while(idx < priorities.length) {
			int max = 0;
			int maxIdx = 0;
			for(int i=0; i<priorities.length; i++) {
				if(max < priorities[i]) {
					max = priorities[i];
					maxIdx = i;
				}
			}
			
			if(location == maxIdx) return ++idx;
			
//			list.add(arg0)
			sorted[idx][0] = max;
			sorted[idx][1] = maxIdx;
		}
        */
        
        int[] sorted = new int[priorities.length];
        for(int i=0; i<priorities.length; i++)
            sorted[i] = priorities[i];
        Arrays.sort(sorted);	//오름차순
        int idx = priorities.length - 1;	//sorted용 인덱스, 큰값부터 비교
        
        //두 값을 비교하면서 삭제, idx 검사해서 location이면 리턴
        while(idx >= 0) {
            for(int i=0; i<priorities.length; i++) {	//비교범위를 줄이고 싶은데 못했음 (현재 복잡도 아마도 O(n^2))
                if(sorted[idx] == priorities[i]) {
                    if(location == i) return sorted.length - idx;
                    /* 출력순서 꼬임
                    int temp = priorities[idx];
                    priorities[idx] = priorities[i];
                    priorities[i] = temp;
                    */
                    priorities[i] = 0;	//우선순위 범위 1~9
                    
                    idx--;
                }
            }
        }
		
		return -1;
		
		
//		return 0;
	}
	
	
	
	
	
	public int solution_2(int[] priorities, int location) {
		
//		List<Integer[]> list = new ArrayList<>();
		int[][] sorted = new int[priorities.length][2];
		
		//효율성 쓰레기
		int idx = 0;
		while(idx < priorities.length) {
			int max = 0;
			int maxIdx = 0;
			for(int i=0; i<priorities.length; i++) {
				if(max < priorities[i]) {
					max = priorities[i];
					maxIdx = i;
				}
			}
			
			if(location == maxIdx) return ++idx;
			
//			list.add(arg0)
			sorted[idx][0] = max;
			sorted[idx][1] = maxIdx;
		}
		
		return 0;
	}
	
	public int solution_1(int[] priorities, int location) {
        int answer = 0;
        
        int first = 0;  //가장 먼저 
        int highest = priorities[0];
        for(int idx=0; idx<priorities.length; idx++) {
            if(highest < priorities[idx]) {
                highest = priorities[idx];
                first = idx;
            }
        }
        //System.out.println(first + "," + highest);
        if(location - first >= 0) {
            return location - first + 1;
        }else {
            return priorities.length - first + location + 1;
        }
        
        //return answer;
    }
	

}
