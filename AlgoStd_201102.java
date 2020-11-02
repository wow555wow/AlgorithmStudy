import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println("Hello Java");
        //if(0 != s.length() % 2)
            //return 0;
        
        Stack<String> stack = new Stack<>();
        for(String c : s.split("")) {
            if(!stack.isEmpty()) {
                if(stack.peek().equals(c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        
        /*
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty()) {
                char temp = stack.pop();
                if(temp != c) {
                    stack.push(temp);
                }
            }
            stack.push(c);
        }
        */
        
        //answer = stack.isEmpty() ? 1 : 0;
        answer = 0 == stack.size() ? 1 : 0 ;

        return answer;
    }
}
