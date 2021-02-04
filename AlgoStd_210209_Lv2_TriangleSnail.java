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
        
        // 삼각달팽이의 길이 : n + (n-1) + (n-2) + ... 해서 0될때까지 더해주면 됨
        int lenOfSnail = 0;
//        int temp = n;	//인자 n을 바로 갖다 쓰지 말기.. n을 0으로 만들어서 밑에서 에러났음..
        while(n>0) {
        	lenOfSnail += n--;
        }
//        System.out.println("** len of Snail :: " + lenOfSnail );
        n = param;	//원래값 다시 넣어주기
        
        int[][] mat = new int[n][n];	//높이 n, 밑변 n인 삼각형을 위한 배열 (대각선으로 나눈 절반만 쓸 것임)
        int row = 0; int col = 0;	//배열 인덱스
        int val = 1;	//빈칸에 넣을 값
//        int len = 0;	//반복문 종료용 변수 : 삼각달팽이 길이만큼 채우면 반복문 탈출
//        System.out.println( String.format("mat.len[%d], row[%d], col[%d]", mat.length, row, col) );
        
        // 1) 삼각 달팽이 채우기
    	// (0,0)에서 시작
    	// 1. row가 n이 될때까지 row만 1 증가시킨다
    	// 2. row가 n이 되면 col이 n이 될때까지 col만 1 증가시킨다
    	// 3. col이 n이 되면 row, col 모두 1씩 감소시킨다.
    	// 4. (0,0)이 되기 전에 멈춰서 다시 row를 n-1까지 증가시킨다 (이후 반복)
        
        int flag = 0; 	// 0:row 증가 / 1:col 증가 / 2:row,col 감소
        while(val <= lenOfSnail) {	// 달팽이 길이만큼 다 채우면 종료
        	if(0 == mat[row][col])	//비어있는 칸에만 값을 넣는다!
        		mat[row][col] = val++;	//ArrayIndexOutOfBoundsException 왜? > 위에서 n값을 조작했기 때문..ㅎ
//        	System.out.println( String.format("(%d, %d) : [%d]", row, col, mat[row][col]) );
        	
        	switch(flag) {
        	case 0 :	// row 증가
        		row++;
        		if(row == n || 0 != mat[row][col]) {
        			flag++;	// 증가 패턴 변경
        			row--;	//n보다 작아야하므로 원복
        		}
        		break;
        	case 1 : 	// col 증가
        		col++;
        		if(col == n || 0 != mat[row][col]) {
        			flag++;	// 증가 패턴 변경
        			col--;	//n보다 작아야 하므로 원복
        		}
        		break;
        	case 2 : 	// row, col 감소
        		row--; col--;
        		if(0 != mat[row][col]) {	//초기값이 아닌 경우 (이미 방문한 경우)
        			flag = 0;	// 증가 패턴 변경 (row 증가)
        			row++; col++;	//원복
        			n--;	//마지막 줄을 다 채웠으므로 n을 감소시켜 마지막줄에 다시 방문하지 않도록 함
        		}
        	}
//        	System.out.println("flag :: " + flag);
        	// 종료조건.. > len 증가
        }
        n = param;	//조작했던 n값 원복
        
        System.out.println("===============");
        // 2) 채운 달팽이를 위에서부터 순서대로 answer에 넣기
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
