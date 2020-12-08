package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class AlgoStd_201208_Lv2_Camouflage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** ����(�ؽ�)
	 * �� �ؽ��ΰ�?? > ������ ���ռ��� �˰��־���ϳ�? �̹� length�� �˰��ִµ�?
	 * ���� hashMap �Ἥ Hash�ΰ� �ƴϰ���
	 * 
	 * 1. ���� ���� : ����C1 + ... ����C����
	 * 2. ���� �� �ǻ� ���� : �ǻ�C1
	 * 
	 * [HINT] (�� ���� ������ + 1(���Դ°���Ǽ�))* (�� ���� ������ + 1(���Դ°���Ǽ�)) -(�ƹ��͵� �� �Դ°���Ǽ�)
	 *  �� �׳� ����Ǽ����µ� ���� ���޴�� �� �ҿ� ���� �Ѿ
	 *  ���ÿ� �Ͼ�� ����� �� : ���Ѵ� (���ǹ�Ģ : m * n) >> ���� * ���� * ���� * �ѿ� 
	 *  ���ÿ� �Ͼ�� �ʴ� ����� �� : ���Ѵ� (���ǹ�Ģ : m + n) >> ���Ź����µ� ���ÿ� ���� �Ծ��� ���� ����
	 *  https://m.blog.naver.com/sbssbi69/220060435293 (����Ǽ� ������)
	 * 
	 * <��������>
	 * �ǻ� �ּ� 1���� ���ľ� �� (���Ź����� �������� ��ħ) > ����C0�� ����
	 * 1 <= clothes.length <= 30
	 * �ǻ� �̸��� ���� ������ �ִ� ������ �ִ°ɱ�?
	 * 
	 * @param clothes ������ �ǻ� {�̸� : ����} �� �� ������ �ھ�
	 * @return ��ü ������ �� ����
	 */
	public int solution(String[][] clothes) {
        int answer = 0;
        
//        for(int i=0; i<clothes.length; i++) {	//���� ���� (1�� ��ĥ�� n�� ��ĥ��)
//        	for(int j=0; j<clothes.length; j++) {	//���տ� ���� Ŀ���� �ȵ�
//        		answer += clothes[j].length;	// ���� �� �ǻ� ����
//        	}
//        }
        
//        //����C1
//        for(int i=0; i<clothes.length; i++) {	// ���� ���� ���ϱ�
//        	answer += clothes[i].length;
//        }
        
        //clothes �迭�� HashMap�� �Ű� ���
        List<String> tempList;
        HashMap<String, List<String>> closet = new HashMap<>();	//value�� List ���� ������(int)�� �ϴ°� �������⵵�� ����
        for(int i=0; i<clothes.length; i++) {
        	if(!closet.containsKey(clothes[i][1])) {
        		tempList = new ArrayList<String>();
//        		tempList.add(clothes[i][0]);
//        		closet.put(clothes[i][1], tempList);
        	}else {
        		tempList = closet.get(clothes[i][1]);
//        		tempList.add(clothes[i][0]);
//        		closet.put(clothes[i][1], tempList);
        	}
        	tempList.add(clothes[i][0]);
    		closet.put(clothes[i][1], tempList);
        }
        
        //������..��� ���ؾ���...
        /*
         * nC1 = n
         * nC2 = n!/(n-r)! >> {1, 2}...{1,n}, {2,3}...{2,n},...{n-1, n}
         * (�� ���� for������ Ŀ������)
         * nC3 >> {1, 2, 3}, {1, 2, 4}... ����for���� �� ���� �ƴѰ�
         * nCn = 1 
         */
        
        //[HINT] (�� ���� ������ + 1(���Դ°���Ǽ�))* (�� ���� ������ + 1(���Դ°���Ǽ�)) -(�ƹ��͵� �� �Դ°���Ǽ�)
        
        //Iterator ����ϸ� �ʱⰪ �ۿ��� ���� ����(closet.values().iterator().next())
        for(Entry<String, List<String>> entry : closet.entrySet()) {
        	if(0 == answer) {
        		answer = entry.getValue().size() + 1;
        	}else {
        		answer *= entry.getValue().size() + 1;
        	}
        }
        
        if(answer >= 0) answer -= 1;	//���Ź������
        
        return answer;
    }

}
