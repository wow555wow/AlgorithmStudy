import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");
        
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') { //스택이 비어있는데 peek() 하면 런타임 에러 발생하는 듯.
            	stack.pop();
            }else {
            	stack.push(s.charAt(i));
            }
        }
        
        answer = stack.size() == 0 ? true : false;

        return answer;
    }
}
