package level1;

import java.util.Stack;

public class AlgoStd_201012 {

	public static void main(String[] args) {

		// 공부
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(1);
		s.push(2);
		
//		// Q1. stack이 비어있는 경우 pop하면 무슨 값이 나올까? : 안나오고 exception
//		System.out.println(">>>" + s.pop() );
//		System.out.println(">>>" + s.pop() );	//EmptyStackException
		
//		// Q2. stack의 first/last elem
//		System.out.println(s.firstElement());	//가장 바닥에 있는 애 (제일 처음에 넣은 애)
//		System.out.println(s.lastElement());	//가장 위에 있는 애 (제일 마지막에 넣은 애)
//		System.out.println(s.peek());	//stack의 꼭대기 값(pop하면 나올 애)
		
//		// Q3. stack.empty()<Stack> 와 stack.isEmpty()<Vector> 의 차이 ? (Vector가 상위클래스) >> 디컴파일러 설치해라 (마켓-jad 검색)
//		System.out.println(s.empty());
//		System.out.println(s.isEmpty());
		
		
		// run
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		
		int result = solution(board, moves);
		System.out.println( ">>> Answer :: " + result );
		
	}
	
	
	/** 크레인 인형뽑기 게임 (2019 카카오 개발자 겨울 인턴십)
	 * 
	 *  args[0] : board[][] : 인형이 들어있는 2차원 배열
	 *  args[1] : moves[] : 크레인 작동위치가 담긴 배열 
	 * 
	 *  return : 터진 인형의 개수
	 *  
	 *  같은 인형이 연속해서 쌓이면 터진다. 1회 폭발 시 인형 2개 터짐
	 *  인형이 없으면 아무 일도 안함
	 *  
	 *  !!! 바구니에 담을 때 board에서 인형 삭제 해줘야 함 !!! 
	 *  
	 *  cf. 출력문이 많은 경우 제출 실패하는 경우 있음
	 *  
	 *  20-10-09 22:10 ~  20-10-10 00:53 (2h 40m)
	 */
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
//        int moveCnt = 0;	//로깅용
        
        Stack<Integer> stack = new Stack<Integer>();	// 인형 뽑은 바구니
        
        // 인형뽑기
        for(int move : moves) {	//크레인 작동
        	for(int i=0; i<board.length; i++) {	//배열 행길이만큼 반복하며 아래로 탐색
        		int current = board[i][move-1]; // board[i][move-1] :: 크레인 위치, 현재 시도에 가져올 인형 (move : 1~n 이므로 -1 한다)
//        		System.out.println("row[" + i + "] :: cur[" + current + "]");
        		
        		if(0 == current) continue;	// 빈공간이므로 다음 행 탐색
        		
        		if(!stack.empty() && stack.peek() == current) {	//바구니가 비어있지 않고, peek의 인형과 같은 경우 pop (반복하면 안됨 한번 터트리면 끝(위에 더 터트릴 인형이 없음))
        			answer += 2;	//1회 터트릴 때 2개의 인형이 같이 사라짐 (꺼내온 인형, 바구니의 제일 위에 있던 인형)
    				stack.pop();	//바구니 제일 위의 인형 버림
//    				System.out.println(">> pop [" + current + "] from Stack");
    				
        		} else {	// 바구니가 비어있거나, 바구니 가장 위의 인형과 같지 않은 경우 push
        			stack.push(current);	//크레인으로 뽑은 인형을 바구니에 넣는다
//            		System.out.println(">> push [" + current + "] to Stack");
        		}
        		
        		board[i][move-1] = 0;	// 인형뽑기 기계에서 뽑은 인형 삭제
        		break;	//인형뽑기 기계의 가장 위에 있는 인형을 꺼내고 나면 크레인 작동 횟수를 다 한 것이므로 행 반복을 종료한다.
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
        
        // 성능상 뭐가 나을지??
        Stack<Integer> stack = new Stack<Integer>();	// 인형 뽑은 바구니
//        List<Integer> bucket = new LinkedList<Integer>();
        
        int rows = board.length;	//배열 행길이 (cf. 제한조건: nxn 배열이므로 행길이==열길이)
        
        // 인형뽑기
//        int tail = 0;	//바구니의 가장 위에 있는 인형
//        int current = 0;	//현재 시도에 가져올 인형
        for(int move : moves) {	//크레인 작동
        	for(int i=0; i<rows; i++) {	//배열 행길이만큼 반복하며 탐색
        		int current = board[i][move-1]; // board[i][move-1] :: 크레인 위치, 현재 시도에 가져올 인형 (move : 1~n 이므로 -1 한다)
        		System.out.println("row[" + i + "] :: cur[" + current + "]");
        		
        		if(0 == current) continue;	// 빈공간이므로 다음 행 탐색
        		
        		// 인형이 있는 경우 
        		if(stack.isEmpty())	//stack이 비어있는 경우 바로 stack에 push
        			stack.push(current);	
        		else {	//스택에 값이 있는 경우 제일 위의 값과 비교하여 같은 인형인 경우 터트리고 다른 경우 stack에 넣는다
        			int tail = stack.pop();	//바구니의 가장 위에 있는 인형
        			
        			// 같은 인형 터트리기 (다른 인형이 나올때까지 계속)
        			while(tail == current) {
        				answer += 2;	//1회 터트릴 때 2개의 인형이 같이 사라짐 (current , tail)
        				
        				if(stack.isEmpty()) break;	// 바구니에 인형이 없으면 인형 터트리기 종료
        				tail = stack.pop();	// 바구니에 인형이 있으면 다음 인형 pop	<<< Q1
        			}
        			
        			stack.push(tail);	// 바구니 가장 위에서 꺼냈던 인형을 다시 넣어줌
        			stack.push(current);	//새로 뽑은 인형을 바구니에 넣는다
        		}
        		
//        		for( : stack.iterator()) {	//반복자 아직도 모르겠어 ㅎ ㅠ
//        			
//        		}
        	}
        }
        
        
        return answer;
    }
	
	
	/*
	 * Stack, LinkedList 사용 > 인형뽑은 바구니 만들기
	 * 
	 * cf 1. 이차원 배열의 길이 : arr.length == 행의 길이, arr[n].length == 열의 길이
	 * 
	 */

}
