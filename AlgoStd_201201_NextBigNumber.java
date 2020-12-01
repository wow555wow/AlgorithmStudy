package level2;

public class AlgoStd_201201_NextBigNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_201201_NextBigNumber a = new AlgoStd_201201_NextBigNumber();
		System.out.println(a.solution(78));

	}
	
	
	/** Lv2. ���� ū ����
	 * 
	 * n���� ũ��, 2���� ��ȯ �� 1�� ������ n�� ���ƾ� ��.
	 * �� �� ���� ���� ��
	 * 
	 * 1�� ��� �ڸ��ٲ� ����� ����?
	 * 
	 * �ܼ��ϰ� ����
	 * ���� ������Ű�鼭 1�� ���� �˻��ϱ�
	 * 
	 * 78(1001110) -> 83(1010011)
	 * 
	 * @param n
	 * @return
	 */
	public int solution(int n) {
        int answer = 0;
        
        int target = 0;
//        String converted = String.valueOf(Integer.toBinaryString(n));
        String converted = Integer.toBinaryString(n);	//�ڵ���ȯ��
        for(int i=0; i<converted.length(); i++) {
        	if('1' == converted.charAt(i))
        		target++;
        }
//        Integer.bitCount(n);	//n�� binary�� ��ȯ �� 1�� ���ڸ� ��ȯ��. #34-#38 ���� ġȯ ����
        
        int cnt = 0;
        while(true) {
        	converted = String.valueOf(Integer.toBinaryString(++n));
        	
        	for(int i=0; i<converted.length(); i++) {
            	if('1' == converted.charAt(i))
            		cnt++;
            }
        	
//        	System.out.println("target: " + target + ", cnt: " + cnt);
        	if(target == cnt)
        		break;
//        		return n;
        	cnt=0;
        }
        
        answer = n;
        return answer;
    }

	
	
	//bit�����ڸ� ����� Ǯ��
	public int nextBigNumber(int n) {
		int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}
