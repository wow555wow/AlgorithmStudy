package level1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_201207_Lv1_TrainingSuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201207_Lv1_TrainingSuit a = new AlgoStd_201207_Lv1_TrainingSuit();
		a.solution_2(5, new int[] {2, 4}, new int[] {3});

	}
	
	
	/** ü���� (Greedy)
	 * 
	 * ��ó�� �ִ� �л��鸸 �����ؼ� Greedy�ΰ�?
	 * 
	 * 1. �Ҿ���� �� ��ó�� ���������¾� �ִ��� Ȯ��
	 * 2. ���������¾� ��ó�� �Ҿ�����ְ� �ִ��� Ȯ��
	 * ���� �� �������� �� �� ������
	 * 
	 * [HINT] ����+�н� �л��� reserve���� �̸� ����?
	 * 
	 * �� �� �̻� �Ҿ���Ȱ�, ������ ����
	 * 
	 * @param n ��ü �л� �� (2 <= n <= 30)
	 * @param lost �������� �л� �迭
	 * @param reserve ����ü���� ������ �л�
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
		
		//������ �������� �л��� �̸� ��������� ��
		for(int i=0; i<reserve.length; i++) {
			if(listLost.contains(reserve[i])) {
				//������ �����������Ƿ� reserve���� ����, lost���� ����
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
			reserve[i] = -1;	//���������Ƿ� ���� �л� ��Ͽ��� ����
			// ���� �� 0�� ġȯ�ϸ� reserve[i]+1 �ϴ� ��쿡 1�� �Ǿ� ��ȿ���� �ǹǷ� -1�� ġȯ
		}
		
		answer = n - listLost.size();
		
		return answer;
	}

}
