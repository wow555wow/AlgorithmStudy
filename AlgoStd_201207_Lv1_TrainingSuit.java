package level1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_201207_Lv1_TrainingSuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201207_Lv1_TrainingSuit a = new AlgoStd_201207_Lv1_TrainingSuit();
		a.solution_2(5, new int[] {2, 4}, new int[] {3});

	}
	
	
	/** 체육복 (Greedy)
	 * 
	 * 근처에 있는 학생들만 생각해서 Greedy인가?
	 * 
	 * 1. 잃어버린 애 근처에 여벌가져온애 있는지 확인
	 * 2. 여벌가져온애 근처에 잃어버린애가 있는지 확인
	 * 누가 더 많은지는 알 수 없을듯
	 * 
	 * [HINT] 여벌+분실 학생은 reserve에서 미리 제외?
	 * 
	 * 한 명 이상 잃어버렸고, 여벌이 있음
	 * 
	 * @param n 전체 학생 수 (2 <= n <= 30)
	 * @param lost 도난당한 학생 배열
	 * @param reserve 여벌체육복 가져온 학생
	 * @return
	 */
	public int solution_2(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
//		List<Integer> listReserve = new ArrayList<Integer>();
//		for(int i=0; i<reserve.length; i++) {
//			listReserve.add(reserve[i]);
//		}
		
		List<Integer> listLost = new ArrayList<Integer>();
		for(int i=0; i<lost.length; i++) {
			listLost.add(lost[i]);
		}
		
		//여벌을 도난당한 학생을 미리 제거해줘야 함
		for(int i=0; i<reserve.length; i++) {
			if(listLost.contains(reserve[i])) {
				//여벌을 도난당했으므로 reserve에서 삭제, lost에서 삭제
				listLost.remove(listLost.indexOf(reserve[i]));
				reserve[i] = -1;
//				continue;
			}
		}
		
		for(int i=0; i<reserve.length; i++) {	
			if(listLost.contains(reserve[i]-1)) {
				listLost.remove(listLost.indexOf(reserve[i]-1));
			}else if(listLost.contains(reserve[i]+1)) {
				listLost.remove(listLost.indexOf(reserve[i]+1));
			}else {
				continue;
			}
			reserve[i] = -1;	//빌려줬으므로 여벌 학생 목록에서 제외
			// 제외 시 0로 치환하면 reserve[i]+1 하는 경우에 1이 되어 유효값이 되므로 -1로 치환
		}
		
		answer = n - listLost.size();
		
		return answer;
	}

}
