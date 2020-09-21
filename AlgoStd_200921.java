package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlgoStd_200921 {

	public static void main(String[] args) {

		System.out.println("[q1_sol] :: " + q1_sol("aqdfA"));
	}
	
	/** Q1. ���ڿ� ������������ ��ġ�ϱ�
	 * ���� ��ҹ��� ����, z>a, �ҹ���>�빮�� */
//	public String q1(String s) {	//Ʋ��
//		
//		String answer = "";
//		char[] arr = s.toCharArray();
////		char[] arr = new char[s.length()];
////		for(int i=0; i<s.length(); i++)
////			arr[i] = s.charAt(i);
//		
//		//selection sort
//		int indexMax; char temp;
//		for(int i=0; i<s.length()-1; i++) {
//			indexMax = i;
//			for(int j=i+1; j<s.length(); j++) {
//				if(arr[j] > arr[indexMax])
//					indexMax = j;
//			}
//			
//			temp = arr[indexMax];
//			arr[indexMax] = arr[i];
//			arr[i] = arr[indexMax];
//			
//			answer += arr[i];
//			if(i == s.length()-2)
//				answer += arr[i+1];
//		}
//		return answer;
//	}
	
	public static String q1_sol(String s) {
		String[] sa = s.split("");
		Arrays.sort(sa);	//�������� ����
		Arrays.sort(sa, Collections.reverseOrder());	//�������� ����
		
		return String.join("", sa);
	}
	
	/** Q2. ���ڿ� �ٷ�� �⺻
	 * ���ڿ� ���̰� 4 Ȥ�� 6�̰� ���ڷθ� �����Ǿ� �ִ��� Ȯ�� (s�� ���� 1-8) */
	public boolean q2(String s) {
		
		if(s.length() == 4 || s.length() == 6) {
			char[] arr = s.toCharArray();
			for(char c : arr) {
				if(c < (char) '0' || c > (char) '9')	//Character.isDigit(char c) << ���ڿ���Ȯ���Լ�
					return false;
			}
		}else 
			return false;
		
		return true;
	}
	
	public boolean q2_sol1(String s) {
		if(s.length() == 4 || s.length() == 6) {
			try {
				int x = Integer.parseInt(s);	//parseDoble�� ���� �߻��Ѵٰ� ��. s�� ���� == 1-8 �̶�� ������ �ʿ��� �����ε�.
				return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}else
			return false;
	}
	
	public boolean q2_sol2(String s) {
		if(s.length() == 4 || s.length() == 6)
			return s.matches("(^[0-9]*$)");	//���Խ��� �̿��� Ǯ��
		return false;
	}
	
	public boolean q2_sol3(String s) {
		return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
	}

	
	/** Q3. ���ڿ� �� ������� �����ϱ� 
	 * �ҹ��� ���ĺ����� �̷���� ���ڿ��� index �������� ����, ���� ��� ����������� ���
	 * 1 <= strings.length <= 50
	 */
//	public String[] q3(String[] strings, int n) {
//		// index ���� ���� ���� �� �������� ����
////		Arrays.sort(char[] a, int fromIndex, int toIndex);
//		
//		
//		for(int i=0; i<strings.length; i++) {
//			
//		}
//	}
	
//	public String[] q3_sol1(String strings, int n) {	// �ؼ� �� �ۼ�
//		// ���������� ������ �� index ���� ����
//	}
	
	public String[] q3_sol2(String[] strings, int n) {	//���۸��� ����
		// index ��ġ�� ���ڸ� ���ڿ��� �ٿ� ������ �� index ���� ���� �� ������
		String[] answer = {};
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0; i<strings.length; i++) {
			arr.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(arr);
		
		answer = new String[arr.size()];
		for(int i=0; i<arr.size(); i++)
			answer[i] = arr.get(i).substring(1);
		return answer;
	}
}
