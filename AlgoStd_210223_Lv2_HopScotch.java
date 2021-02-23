package Lv2;

public class AlgoStd_210223_Lv2_HopScotch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_210223_Lv2_HopScotch a = new AlgoStd_210223_Lv2_HopScotch();
		
//		a.solution(new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}});
		a.solution(new int[][] {{4,3,2,1},{2,2,2,1},{6,6,6,4},{8,7,6,5}});
	}
	
	/** [문제해설] dynamic programming 기법으로 풀어야 함. 
	 * 
	 * 아래서부터 현재경로의 최댓값들을 구해놓고 위로 거꾸로 거슬러 올라가는 방식..?
	 * 
	 * @param land
	 * @return
	 */
	int solution(int[][] land) {
		int answer = 0;
		
		int idxBfr = -1;
		for(int i=land.length-2; i>=0; i--) {
			for(int j=0; j<4; j++) {
				
			}
		}
		
		return answer;
	}
	
	
	/** 땅따먹기
	 * 
	 *  N x 4 의 2차원 배열. 칸마다 가중치 존재 (가중치 : 100 이하의 자연수. 1~100)
	 *  현재 방문한 열을 다음 행에서는 방문할 수 없음
	 *  점수의 최댓값을 리턴
	 *  
	 *  [HINT] 문제에서 빠진 부분은 아래에서 위로 가는 경로 상에서 구해지는 최대값을 역시 포함되어야 합니다.
	 *  		for loop로 구현하지 말고, Dynamic programming (DP) 기법으로 구현해야 시간 복잡도가 줄어듭니다.
	 * 
	 * @param land
	 * @return
	 */
	int solution_loop(int[][] land) {
        int answer = 0;

        int idxBfr = -1;	//이전 행의 col idx 보관
        for(int i=0; i<land.length; i++) {
        	int colMax = 0;	//행 내 최댓값을 보관할 변수
        	int idxColMax = -1;
        	for(int j=0; j<4; j++) {
        		if(j == idxBfr) continue;	//이전 행에서 방문한 열 통과
        		
        		colMax = Math.max(colMax, land[i][j]);
        		if(colMax == land[i][j]) idxColMax = j;
        	}
        	idxBfr = idxColMax;
        	answer += colMax;
        	System.out.println("sum[" + answer + "] colMax[" + colMax + "], idxBfr[" + idxBfr + "]");
        }

        return answer;
    }

}
