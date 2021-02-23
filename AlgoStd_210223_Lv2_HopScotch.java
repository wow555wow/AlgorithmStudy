package Lv2;

public class AlgoStd_210223_Lv2_HopScotch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_210223_Lv2_HopScotch a = new AlgoStd_210223_Lv2_HopScotch();
		
//		a.solution(new int[][]{{1,2,3,5}, {5,6,7,8}, {4,3,2,1}});
		a.solution(new int[][] {{4,3,2,1},{2,2,2,1},{6,6,6,4},{8,7,6,5}});
	}
	
	/** [�����ؼ�] dynamic programming ������� Ǯ��� ��. 
	 * 
	 * �Ʒ������� �������� �ִ񰪵��� ���س��� ���� �Ųٷ� �Ž��� �ö󰡴� ���..?
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
	
	
	/** �����Ա�
	 * 
	 *  N x 4 �� 2���� �迭. ĭ���� ����ġ ���� (����ġ : 100 ������ �ڿ���. 1~100)
	 *  ���� �湮�� ���� ���� �࿡���� �湮�� �� ����
	 *  ������ �ִ��� ����
	 *  
	 *  [HINT] �������� ���� �κ��� �Ʒ����� ���� ���� ��� �󿡼� �������� �ִ밪�� ���� ���ԵǾ�� �մϴ�.
	 *  		for loop�� �������� ����, Dynamic programming (DP) ������� �����ؾ� �ð� ���⵵�� �پ��ϴ�.
	 * 
	 * @param land
	 * @return
	 */
	int solution_loop(int[][] land) {
        int answer = 0;

        int idxBfr = -1;	//���� ���� col idx ����
        for(int i=0; i<land.length; i++) {
        	int colMax = 0;	//�� �� �ִ��� ������ ����
        	int idxColMax = -1;
        	for(int j=0; j<4; j++) {
        		if(j == idxBfr) continue;	//���� �࿡�� �湮�� �� ���
        		
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
