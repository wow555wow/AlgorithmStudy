package level2;

public class AlgoStd_2010105_Lv2_QuadCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** 21-01-05 Lv2. ���� ���� �� ���� ����
	 * 
	 * 1 > 2 > 4 > ������ ������� �ϱ�?
	 * 
	 * @param arr
	 * @return
	 */
	public int[] solution(int[][] arr) {
        int[] answer = {};
        
        int r=0; int c=0;
        boolean compressible = true;
        int[] lastQuadCompIdx = new int[2];
        int lastQuadSize = 2;
        int quad = 0;
        while(true) {	//��ü ������� (1 > 2 > 4 > ...)
        	
        	while() {	//�ܰ躰 ������� (1�ܰ�)
        		
        	}
            
            /*
            if(!this.quadComp(arr, r, c, lastQuadSize)) compressible = false;
            
            switch(++quad) {
//            case 1 : r += 2; break;
//            case 2 : r -= 2; c += 2; break;
//            case 3 : r += 2; break;
            case 1 : r += lastQuadSize; break;
            case 2 : r -= lastQuadSize; c += lastQuadSize; break;
            case 3 : r += lastQuadSize; break;
            case 4 : 
            	if(compressible) {
            		
            		lastQuadSize *= 2;
            	}
                    // ���ÿ� ��ǥ �־����? �� false �Ǹ� ������ϳ�?
            }
            */
        }
        
        return answer;
    }
    
    private boolean quadComp(int[][] arr, int row, int col, int quadSize) {
        if( (arr[row][col] == arr[row][col+quadSize]) && arr[row][col] == arr[row+quadSize][col] && arr[row][col] == arr[row+quadSize][col+quadSize] ) {
            arr[row][col+quadSize] = -1;
            arr[row+quadSize][col] = -1;
            arr[row+quadSize][col+quadSize] = -1;
            return true;
        }
        return false;
    }
    
    //4ĭ �������
//    private boolean quadComp(int[][] arr, int row, int col) {
//        if( (arr[row][col] == arr[row][col+1]) && arr[row][col] == arr[row+1][col] && arr[row][col] == arr[row+1][col+1] ) {
//            arr[row][col+1] = -1;
//            arr[row+1][col] = -1;
//            arr[row+1][col+1] = -1;
//            return true;
//        }
//        return false;
//    }

}
