package level1;

public class AlgoStd_201119_Lv1_2016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201119_Lv1_2016 c = new AlgoStd_201119_Lv1_2016();
		System.out.println(c.solution(5, 24));
//		System.out.println(c.solution(1, 1));

	}
	
	
	final String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
//	String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
	// 7���� Ȧ���� : 31��, ¦���� : 30��
	// ¦���� ���� : 2��-29��(����)
	// 7�ʰ� Ȧ���� : 30��, ¦���� : 31��
	final int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	/** 2016��
	 * 
	 * 1�� 1�Ͽ��� �Է¹��� ��¥������ ��ĥ ���������� ���ؼ� ���� ���ϱ�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String solution(int a, int b) {
		String answer = "";
		
//		int today = 5;	//���Ϲ迭�� idx, �ʱⰪ 1�� 1�� �ݿ���
//		int convertToDays = (a-1) * dayOfMonth[a-1] + b + 5;
		
		int convertToDays = b+4;	// �� + �ʱⰪ(1�� 1���� idx 5�� FRI��)
		for(int i=0; i<a-1; i++) {
			convertToDays += dayOfMonth[i];
		}
		answer = day[convertToDays % 7];
		
        return answer;
    }

}
