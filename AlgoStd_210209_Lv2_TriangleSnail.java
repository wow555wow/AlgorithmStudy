package Lv2;

public class AlgoStd_210209_Lv2_TriangleSnail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlgoStd_210209_Lv2_TriangleSnail a = new AlgoStd_210209_Lv2_TriangleSnail();
		a.print(a.solution(4));
		

	}
	
	public void print(int[] arr) {
		System.out.print("[");
		for(int i=0; i<arr.length; i++)
			System.out.print("," + arr[i]);
		System.out.print("]");
	}
	
	
	public int[] solution(int n) {
		int param = n;
        int[] answer = {};
//        System.out.println("N[" + n + "]");
        
        // �ﰢ�������� ���� : n + (n-1) + (n-2) + ... �ؼ� 0�ɶ����� �����ָ� ��
        int lenOfSnail = 0;
//        int temp = n;	//���� n�� �ٷ� ���� ���� ����.. n�� 0���� ���� �ؿ��� ��������..
        while(n>0) {
        	lenOfSnail += n--;
        }
//        System.out.println("** len of Snail :: " + lenOfSnail );
        n = param;	//������ �ٽ� �־��ֱ�
        
        int[][] mat = new int[n][n];	//���� n, �غ� n�� �ﰢ���� ���� �迭 (�밢������ ���� ���ݸ� �� ����)
        int row = 0; int col = 0;	//�迭 �ε���
        int val = 1;	//��ĭ�� ���� ��
//        int len = 0;	//�ݺ��� ����� ���� : �ﰢ������ ���̸�ŭ ä��� �ݺ��� Ż��
//        System.out.println( String.format("mat.len[%d], row[%d], col[%d]", mat.length, row, col) );
        
        // 1) �ﰢ ������ ä���
    	// (0,0)���� ����
    	// 1. row�� n�� �ɶ����� row�� 1 ������Ų��
    	// 2. row�� n�� �Ǹ� col�� n�� �ɶ����� col�� 1 ������Ų��
    	// 3. col�� n�� �Ǹ� row, col ��� 1�� ���ҽ�Ų��.
    	// 4. (0,0)�� �Ǳ� ���� ���缭 �ٽ� row�� n-1���� ������Ų�� (���� �ݺ�)
        
        int flag = 0; 	// 0:row ���� / 1:col ���� / 2:row,col ����
        while(val <= lenOfSnail) {	// ������ ���̸�ŭ �� ä��� ����
        	if(0 == mat[row][col])	//����ִ� ĭ���� ���� �ִ´�!
        		mat[row][col] = val++;	//ArrayIndexOutOfBoundsException ��? > ������ n���� �����߱� ����..��
//        	System.out.println( String.format("(%d, %d) : [%d]", row, col, mat[row][col]) );
        	
        	switch(flag) {
        	case 0 :	// row ����
        		row++;
        		if(row == n || 0 != mat[row][col]) {
        			flag++;	// ���� ���� ����
        			row--;	//n���� �۾ƾ��ϹǷ� ����
        		}
        		break;
        	case 1 : 	// col ����
        		col++;
        		if(col == n || 0 != mat[row][col]) {
        			flag++;	// ���� ���� ����
        			col--;	//n���� �۾ƾ� �ϹǷ� ����
        		}
        		break;
        	case 2 : 	// row, col ����
        		row--; col--;
        		if(0 != mat[row][col]) {	//�ʱⰪ�� �ƴ� ��� (�̹� �湮�� ���)
        			flag = 0;	// ���� ���� ���� (row ����)
        			row++; col++;	//����
        			n--;	//������ ���� �� ä�����Ƿ� n�� ���ҽ��� �������ٿ� �ٽ� �湮���� �ʵ��� ��
        		}
        	}
//        	System.out.println("flag :: " + flag);
        	// ��������.. > len ����
        }
        n = param;	//�����ߴ� n�� ����
        
        System.out.println("===============");
        // 2) ä�� �����̸� ���������� ������� answer�� �ֱ�
        answer = new int[lenOfSnail];
        int idx = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<=i; j++) {	// (0,0) -> (1,0),(1,1) -> (2,0),(2,1),(2,2)...
        		answer[idx++] = mat[i][j];

//            	System.out.println( String.format("(%d, %d) : [%d]", i, j, mat[i][j]) );
        	}
        }
        
        return answer;
    }
}
