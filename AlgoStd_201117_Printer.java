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
	
	
	/** ������ (�켱����ť)
	 * �켱������ ���� ���� �������� ����Ѵ�
	 * 
	 * !!! ��� Ǯ������ ������ ���� �Ѵ�
	 * !!! edge point �Фи� ã�´�
	 * !!! ������ �ڵ带 �ۼ����� �ʴ´�!!!
	 * 
	 * 1. array�� �켱������ ���� ������ �迭�ε����� �־��ش�
	 * 2. �ε��� ������� ����Ѵ�
	 * 3. location�� ������ �迭�� ���° �ε����� ����ִ��� ã�´�
	 * 
	 * �ѤѤ�
	 * idx�� �켱�������� ���� �����־�� �ҰͰ���
	 * �ƴϸ� �켱������� idx�� ������ �迭/list�� �ʿ���
	 * 
	 * 1. �ѹ� loop ���鼭 �켱���� �� �����ϱ� : O(n)
	 * 2. �켱�������� ���̸鼭 �����ϸ鼭 ��� : O(n?)
	 * 3.
	 * 
	 * 
	 * �켱����ť > heap���� ����
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
        Arrays.sort(sorted);	//��������
        int idx = priorities.length - 1;	//sorted�� �ε���, ū������ ��
        
        //�� ���� ���ϸ鼭 ����, idx �˻��ؼ� location�̸� ����
        while(idx >= 0) {
            for(int i=0; i<priorities.length; i++) {	//�񱳹����� ���̰� ������ ������ (���� ���⵵ �Ƹ��� O(n^2))
                if(sorted[idx] == priorities[i]) {
                    if(location == i) return sorted.length - idx;
                    /* ��¼��� ����
                    int temp = priorities[idx];
                    priorities[idx] = priorities[i];
                    priorities[i] = temp;
                    */
                    priorities[i] = 0;	//�켱���� ���� 1~9
                    
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
		
		//ȿ���� ������
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
        
        int first = 0;  //���� ���� 
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
