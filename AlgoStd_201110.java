import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //정렬해서 가장 무거운 사람과 가장 가벼운 사람을 짝짓기
        Arrays.sort(people);
        int start=0; //가장 가벼운 사람
        int end=people.length-1; //가장 무거운 사람
        
        while(start<end) {
            if(limit - people[end] < 40 || limit - people[end] - people[start] < 0) { // 한명밖에 태울 수 없음
                end--;
                answer++;
            }else if(limit - people[end] - people[start] >= 0) { // 두명 태울 수 있음(두명이 최대)
                end--;
                start++;
                answer++;
            } // 위 두 조건으로 모든 케이스 커버
            
            if(start==end) { //마지막 한명만 남은 경우
                answer++;
                break;
            }
        
        }
        return answer;
    }
}


/* 더 간단한 풀이
// 한번에 한명씩은 반드시 태우니까 for로 반복당 인덱스를 줄이는것이 더 명시적인 것 같음.
// 전체인원/2 가 최솟값. 전체인원에서 두명씩 태운 횟수를 빼면 보트의 수가 나옴.
public int solution(int[] people, int limit) {
 Arrays.sort(people);
 int i = 0, j = people.length - 1;
 for (; i < j; --j) {
  if (people[i] + people[j] <= limit)
   ++i;
 }
 return people.length - i; 
}
*/
