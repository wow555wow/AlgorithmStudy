class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
          String s = String.valueOf(n);
        s = new StringBuffer(s).reverse().toString();
        
        int i=0;
        answer = new int[s.length()];
        for(String rs : s.split("")) {
            answer[i++] = Integer.parseInt(rs);
        }
        
        return answer;
    }
}
