package level1;

import java.util.Stack;

public class AlgoStd_201012 {

	public static void main(String[] args) {

		// ����
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(1);
		s.push(2);
		
//		// Q1. stack�� ����ִ� ��� pop�ϸ� ���� ���� ���ñ�? : �ȳ����� exception
//		System.out.println(">>>" + s.pop() );
//		System.out.println(">>>" + s.pop() );	//EmptyStackException
		
//		// Q2. stack�� first/last elem
//		System.out.println(s.firstElement());	//���� �ٴڿ� �ִ� �� (���� ó���� ���� ��)
//		System.out.println(s.lastElement());	//���� ���� �ִ� �� (���� �������� ���� ��)
//		System.out.println(s.peek());	//stack�� ����� ��(pop�ϸ� ���� ��)
		
//		// Q3. stack.empty()<Stack> �� stack.isEmpty()<Vector> �� ���� ? (Vector�� ����Ŭ����) >> �������Ϸ� ��ġ�ض� (����-jad �˻�)
//		System.out.println(s.empty());
//		System.out.println(s.isEmpty());
		
		
		// run
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		
		int result = solution(board, moves);
		System.out.println( ">>> Answer :: " + result );
		
	}
	
	
	/** ũ���� �����̱� ���� (2019 īī�� ������ �ܿ� ���Ͻ�)
	 * 
	 *  args[0] : board[][] : ������ ����ִ� 2���� �迭
	 *  args[1] : moves[] : ũ���� �۵���ġ�� ��� �迭 
	 * 
	 *  return : ���� ������ ����
	 *  
	 *  ���� ������ �����ؼ� ���̸� ������. 1ȸ ���� �� ���� 2�� ����
	 *  ������ ������ �ƹ� �ϵ� ����
	 *  
	 *  !!! �ٱ��Ͽ� ���� �� board���� ���� ���� ����� �� !!! 
	 *  
	 *  cf. ��¹��� ���� ��� ���� �����ϴ� ��� ����
	 *  
	 *  20-10-09 22:10 ~  20-10-10 00:53 (2h 40m)
	 */
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int moveCnt = 0;	//�α��
        
        Stack<Integer> stack = new Stack<Integer>();	// ���� ���� �ٱ���
        
        // �����̱�
        for(int move : moves) {	//ũ���� �۵�
        	for(int i=0; i<board.length; i++) {	//�迭 ����̸�ŭ �ݺ��ϸ� �Ʒ��� Ž��
        		int current = board[i][move-1]; // board[i][move-1] :: ũ���� ��ġ, ���� �õ��� ������ ���� (move : 1~n �̹Ƿ� -1 �Ѵ�)
//        		System.out.println("row[" + i + "] :: cur[" + current + "]");
        		
        		if(0 == current) continue;	// ������̹Ƿ� ���� �� Ž��
        		
        		if(!stack.empty() && stack.peek() == current) {	//�ٱ��ϰ� ������� �ʰ�, peek�� ������ ���� ��� pop (�ݺ��ϸ� �ȵ� �ѹ� ��Ʈ���� ��(���� �� ��Ʈ�� ������ ����))
        			answer += 2;	//1ȸ ��Ʈ�� �� 2���� ������ ���� ����� (������ ����, �ٱ����� ���� ���� �ִ� ����)
    				stack.pop();	//�ٱ��� ���� ���� ���� ����
//    				System.out.println(">> pop [" + current + "] from Stack");
    				
        		} else {	// �ٱ��ϰ� ����ְų�, �ٱ��� ���� ���� ������ ���� ���� ��� push
        			stack.push(current);	//ũ�������� ���� ������ �ٱ��Ͽ� �ִ´�
//            		System.out.println(">> push [" + current + "] to Stack");
        		}
        		
        		board[i][move-1] = 0;	// �����̱� ��迡�� ���� ���� ����
        		break;	//�����̱� ����� ���� ���� �ִ� ������ ������ ���� ũ���� �۵� Ƚ���� �� �� ���̹Ƿ� �� �ݺ��� �����Ѵ�.
        	}
//        	System.out.println("==== moveCnt[" + ++moveCnt + "]");
//        	
//        	String stackElems = "";
//        	for(int s : stack)
//        		stackElems += s + " ";
//        	System.out.println("Current Stack [" + stackElems + "], answer[" + answer + "]");
        }
        
        return answer;
    }
	
	
	public static int solution_pop(int[][] board, int[] moves) {
        int answer = 0;
        
        // ���ɻ� ���� ������??
        Stack<Integer> stack = new Stack<Integer>();	// ���� ���� �ٱ���
//        List<Integer> bucket = new LinkedList<Integer>();
        
        int rows = board.length;	//�迭 ����� (cf. ��������: nxn �迭�̹Ƿ� �����==������)
        
        // �����̱�
//        int tail = 0;	//�ٱ����� ���� ���� �ִ� ����
//        int current = 0;	//���� �õ��� ������ ����
        for(int move : moves) {	//ũ���� �۵�
        	for(int i=0; i<rows; i++) {	//�迭 ����̸�ŭ �ݺ��ϸ� Ž��
        		int current = board[i][move-1]; // board[i][move-1] :: ũ���� ��ġ, ���� �õ��� ������ ���� (move : 1~n �̹Ƿ� -1 �Ѵ�)
        		System.out.println("row[" + i + "] :: cur[" + current + "]");
        		
        		if(0 == current) continue;	// ������̹Ƿ� ���� �� Ž��
        		
        		// ������ �ִ� ��� 
        		if(stack.isEmpty())	//stack�� ����ִ� ��� �ٷ� stack�� push
        			stack.push(current);	
        		else {	//���ÿ� ���� �ִ� ��� ���� ���� ���� ���Ͽ� ���� ������ ��� ��Ʈ���� �ٸ� ��� stack�� �ִ´�
        			int tail = stack.pop();	//�ٱ����� ���� ���� �ִ� ����
        			
        			// ���� ���� ��Ʈ���� (�ٸ� ������ ���ö����� ���)
        			while(tail == current) {
        				answer += 2;	//1ȸ ��Ʈ�� �� 2���� ������ ���� ����� (current , tail)
        				
        				if(stack.isEmpty()) break;	// �ٱ��Ͽ� ������ ������ ���� ��Ʈ���� ����
        				tail = stack.pop();	// �ٱ��Ͽ� ������ ������ ���� ���� pop	<<< Q1
        			}
        			
        			stack.push(tail);	// �ٱ��� ���� ������ ���´� ������ �ٽ� �־���
        			stack.push(current);	//���� ���� ������ �ٱ��Ͽ� �ִ´�
        		}
        		
//        		for( : stack.iterator()) {	//�ݺ��� ������ �𸣰ھ� �� ��
//        			
//        		}
        	}
        }
        
        
        return answer;
    }
	
	
	/*
	 * Stack, LinkedList ��� > �������� �ٱ��� �����
	 * 
	 * cf 1. ������ �迭�� ���� : arr.length == ���� ����, arr[n].length == ���� ����
	 * 
	 */

}
