package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AlgoStd_201019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(118372));

	}
	
	public static long solution(long n) {
		long answer = 0;
		
        char[] ca = String.valueOf(n).toCharArray();
//        Arrays.sort(ca, Collections.reverseOrder());
//        Arrays.sort(ca, new Comparator<int>() {
//
//			@Override
//			public int compare(char arg0, char arg1) {
//				// TODO Auto-generated method stub
//				return arg1 - arg0;
//			}
//		});
        answer = Long.parseLong(String.valueOf(ca));
        
        return answer;
    }

	
	///2t
	/*
	 * ���� n�� �ڸ������ �����
	 * �����ϰ�
	 * �ٽ� ���ڷ� ���� ����
	 */
	public static long solution2(long n) {
		
		String[] sa = String.valueOf(n).split("");
		Arrays.sort(sa, Collections.reverseOrder());
		
		String converted ="";
		for(String s : sa)
			converted += s;

		return Long.parseLong(converted);
	}
	
	
	/* �ٸ� ����� Ǯ��
	 *  ������������ �ؼ��� �� �ȵ�..
	 */
	String res = "";
	public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
	
	/*
	 * �� �� ���� �� �������� ���ڿ� ���ϱ�(StringBuilder.reverse() ���)
	 * 10���� �����鼭 ���� ���ڿ��� ���ؼ� ���ڸ� �迭�� ���� (Vector �����...)
	 * 
	 */
}
