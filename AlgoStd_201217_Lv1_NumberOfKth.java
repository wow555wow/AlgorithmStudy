package level1;

import java.util.Arrays;

public class AlgoStd_201217_Lv1_NumberOfKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AlgoStd_201217_Lv1_NumberOfKth a = new AlgoStd_201217_Lv1_NumberOfKth();
		a.solution(new int[] {1,5,2,6,3,7,4}, new int[][] {{2,5,3},{4,4,1},{1,7,3}});
	}
	
	
	public int[] solution_0(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer= new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] temp= new int[commands[i][1] - commands[i][0]];
            int idx=0;
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                temp[idx++] = commands[i][j];
            }
            answer[i] = temp[commands[i][2]];
            
            
        }
        
        return answer;
    }

	
	public int[] solution_(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer= new int[commands.length];
        for(int i=0; i<commands.length; i++) {
        	int start = commands[i][0]-1;
        	int end = commands[i][1];
//        	System.out.print("[" + start + ", " + end + "]");
//            int[] temp= new int[commands[i][1] - commands[i][0]];
            int[] temp= new int[end - start];
            int idx=0;
            for(int j=start; j<end; j++) {
//                temp[idx++] = commands[i][j];
//            	System.out.print("[" + commands[i][j] + "]");
//                temp[idx] = array[commands[i][j]-1];
            	temp[idx] = array[j];
//            	System.out.println(i + ", " + j + ", " + temp[idx]);
                idx++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
            
            
        }
        
        return answer;
    }
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        answer= new int[commands.length];
        for(int i=0; i<commands.length; i++) {
        	int start = commands[i][0]-1;
        	int end = commands[i][1];
            int[] temp= new int[end - start];
            int idx=0;
            for(int j=start; j<end; j++) {
            	temp[idx++] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
            
            
        }
        
        return answer;
    }
}
