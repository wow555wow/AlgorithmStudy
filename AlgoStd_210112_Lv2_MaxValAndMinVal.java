class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sa = s.split(" ");
        int min=Integer.parseInt(sa[0]); int max=min;
        int cur;
        for(int i=1; i<sa.length; i++) {
            cur = Integer.parseInt(sa[i]);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }
        
        answer = String.valueOf(min) + " " + String.valueOf(max);
        
        return answer;
    }
}
