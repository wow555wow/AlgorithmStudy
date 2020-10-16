class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] sa = String.valueOf(x).split("");
        
        int sum = 0;
        for(String s : sa) {
            sum += Integer.parseInt(s);
        }
        
        if( 0 != (x%sum) ) answer = false;
        
        return answer;
    }
}
