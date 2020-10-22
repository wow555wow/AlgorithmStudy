package level1;

public class AlgoStd_201022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(solution(5, new int[] {9, 20, 28, 18, 11}, new int [] {30, 1, 21, 17, 28}));
		System.out.println(solution(6, new int[] {46,  33, 33, 22, 31, 50}, new int[] {27, 56, 19, 14, 14, 10}));
		

	}
	
	/** ������� (2018 īī�� ����ε� ä��)
	 * 
	 * 1. �����迭�� �� ���Ҹ� 2������ ���� (0:����, 1:��) < bit�����ϸ� ������ ������ �ʿ����?
	 * 2. ù��° �迭�� �ι�° �迭�� ���� �� (bit����?), ��� ������ ��쿡�� ��¥ ����(|)
	 * 3. ��(#), ����( )�� ���ڿ� �迭�� ���
	 * 
	 * ? 0 <= x <= 2^n -1 : �� ������ �� �ִ¤�����? :: �ڸ��� ���߷���!!
	 * 
	 * **/
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        
        answer = new String[n];
        int[] map = new int[n];	//��¥ ����
        for(int i=0; i<n; i++) {
        	map[i] = arr1[i] | arr2[i];
        	System.out.println("arr1[" + arr1[i] + "] arr2[" + arr2[i] + "] map[" + map[i] + "]");
        	System.out.println("arr1[" + Integer.toBinaryString(arr1[i]) + "] arr2[" + Integer.toBinaryString(arr2[i]) + "] map[" + Integer.toBinaryString(map[i]) + "]");
//        	answer[i] = 0 == arr1[i] | arr2[i] ? ""
//        	answer[i] = String.format("%0" + n + "d", Integer.toBinaryString(map[i]));	// d != String
//        	answer[i] = String.format("%0" + n + "d", Integer.parseInt(String.valueOf(map[i]), 2));	// "63" under radix 2 : ??
//        	answer[i] = String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(map[i])));	// int ������ �Ѿ�� tc2, 6���� ��Ÿ�ӿ��� �߻�
        	answer[i] = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(map[i])));
        	System.out.println("answer[" + answer[i] + "]");
//        	char[] binStr = Integer.toBinaryString(map[i]).toCharArray();
        	char[] binStr = answer[i].toCharArray();
        	for(int j=0; j<n; j++) {
        		binStr[j] = '0' == binStr[j] ? ' ' : '#';
        		System.out.print(binStr[j]);
        	}
        	System.out.println();
        	
        	answer[i] = String.valueOf(binStr);
        	System.out.println(">>>" + answer[i]);
        }
        
        return answer;
    }

}
