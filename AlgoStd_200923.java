package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlgoStd_200923 {

	public static void main(String[] args) {

	}
	
	/** ���ǰ��(����Ž��) 
	 * ����[]�� �Ķ���ͷ� �޾� ���� ���� ���� ����� �迭�� ��� ����(������ �ִ� ��� �������� ����)
	 * �����ڴ� �� �� ��
	 * 
	 * @param answers
	 * @return
	 */
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        //����
        Map<Integer, Integer> score = new HashMap<Integer, Integer>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);
        
        // ��� ���
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 3, 4, 5};	// index ¦���ΰ�� 2, Ȧ���ΰ�� 1-5 ����
        int[] std3 = {3, 1, 2, 4, 5};	// index ¦���ΰ�� ������, Ȧ���ΰ�� ���� �� �״�� ��� 
        
        //ä��
        int index1 = 0;		// ������1�� �迭�ε��� ������
        int index2 = 1;	// ¦����ȣ ������ ����� ����� std2[0]�� ����, 1-4 �ε����� ���
        int index3 = 0;
//        boolean isOdd = false;	//Ȧ¦ ����	:: ��� ���°� ���ɿ� �� �����ɱ�?
        for(int i=0; i<answers.length; i++) {
        	
        	//Ȧ¦����
        	boolean isOdd = i % 2 == 0 ? false : true;
        	
        	//�����
        	if(answers[i] == std1[index1++])
        		score.put(1, score.get(1)+1 );	//������1 ���� ����
        	if(answers[i] == (isOdd ? std2[index2++] : std2[0]))
        		score.put(2, score.get(2)+1 );	//������2 ���� ����
        	if(answer[i] == (isOdd ? std3[index3++] : std3[index3]))
        		score.put(3, score.get(3)+1 );	//������3 ���� ����
        	
        	//��� ��� indexó��
        	if(index1 == 5) index1 = 0;
        	if(index2 == 5) index2 = 1;
        	if(index3 == 5) index3 = 0;
        }
        
        // �ְ������ �Ǻ�
//        int winner = score.get(1) >= score.get(2) ? score.get(1) : score.get(2);
//        winner = winner >= score.get(3) ? winner : score.get(3);
        
        //������� ������� ����
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(score.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));	//value���� �������� ����
        
        
        
        //������ Ȯ�� (���������� �����Ѱ��̹Ƿ� �׳� ������� ������ �ȴ�..������ �̰� �����ڰ� 3���̶� ������ ���..)
//        if(entries.get(0) == entries.get(1)) {
//        	if(entries.get(0) == entries.get(2)) {
//        		answer = new int[] {entries.get(0).getKey(), entries.get(1).getKey(), entries.get(2).getKey()};
//        	}else {
//        		answer = new int[] {entries.get(0).getKey(), entries.get(1).getKey()};
//        	}
//        	Arrays.sort(answer);	//������ �������� ����
//        }else {
//        	answer = new int[] {entries.get(0).getKey()};
//        }
        
//        answer = new int[] {score1, score2, score3};
        
        int sameScore = 1;
        if(entries.get(0).getValue() == entries.get(1).getValue()) {
            if(entries.get(0).getValue() == entries.get(2).getValue()) 
                sameScore = 3;
            else sameScore = 2;
        }
        answer = new int[sameScore];
        for(int i=0; i<sameScore; i++)
            answer[i] = entries.get(i).getKey();
        Arrays.sort(answer);
        
        
        return answer;
    }

	
	/*
	 * ó������ score�� int���� 3���� ������ �ߴµ� ���������̶� �����Ҷ� �������� ������ؼ� ��..�ƴѰŰ��Ƽ� ������ ������
	 */
}
