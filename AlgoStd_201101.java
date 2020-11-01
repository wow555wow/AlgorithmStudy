import java.util.*;

/**
* Q1. 정수 제곱근 판별
*/
class Solution1 {
    public long solution(long n) {
        long answer = 0;

        double root = Math.sqrt(n);
        if( root == Math.floor(root))
            answer = (long) Math.pow(root+1, 2);
        else answer = -1;



        return answer;
    }
}


/**
* Q2. x만큼 간격이 있는 n개의 숫자
*/
class Solution2 {
    public long[] solution(int x, int n) {
        long[] answer = {};

        answer = new long[n];
        for(int i=0; i<n; i++) {
            answer[i] = (long) x * (i+1);
        }

        return answer;
    }
}
