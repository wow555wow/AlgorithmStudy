import java.util.*;
class Solution {
    
    /** 201105 큰 수 만들기
    *
    *
    */
    
    
    public String solution(String number, int k) {
        String answer = "";
        
        int startIdx = 0;   //탐색 시작할 인덱스
        int endIdx = k;     //탐색 종료 인덱스
        // 시작인덱스~종료인덱스 안에서 최댓값을 구한다
        
        while(answer.length() < number.length() -k) {   //k만큼 버린다 == 전체길이에서 k를 뺸만큼 남겨야 한다
            
            //최댓값 구하기
            int max=0;
            
            for(int i=startIdx; i<=endIdx; i++) {   //endIdx에 등호 붙이는 이유 : 1번째 수를 구할 때 뒤에는 len-k-1개만 있으면 되니까
                int cur = Character.digit(number.charAt(i), 10);    //진수변환?
                
                //[HINT] TC 10. 999999~에 대한 처리
                if(9 == cur) {  //9가 최댓값이므로 이후로 최댓값을 찾을 필요 없음(최댓값이 여럿인 경우 인덱스가 
                    max = cur;
                    startIdx = i+1; //다음 반복에서는 최댓값(뽑은값)의 다음 값부터 탐색해야 함
                    break;
                }
                
                if(max < cur) {
                    max = cur;
                    startIdx = i+1;
                }
            }
            
            //범위에서 최댓값 찾기가 끝나면 최댓값을 answer에 넣고 endIdx를 증가시킨다
            answer += max;
            max=0;
            endIdx++;
        }
        
        return answer;
    }
}
