package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlgoStd_200923 {

	public static void main(String[] args) {

	}
	
	/** 모의고사(완전탐색) 
	 * 정답[]을 파라미터로 받아 가장 많이 맞힌 사람을 배열에 담아 리턴(동점자 있는 경우 오름차순 정렬)
	 * 수포자는 세 명 뿐
	 * 
	 * @param answers
	 * @return
	 */
	public int[] solution(int[] answers) {
        int[] answer = {};
        
        //점수
        Map<Integer, Integer> score = new HashMap<Integer, Integer>();
        score.put(1, 0);
        score.put(2, 0);
        score.put(3, 0);
        
        // 찍는 방식
        int[] std1 = {1, 2, 3, 4, 5};
        int[] std2 = {2, 1, 3, 4, 5};	// index 짝수인경우 2, 홀수인경우 1-5 순차
        int[] std3 = {3, 1, 2, 4, 5};	// index 짝수인경우 값변경, 홀수인경우 이전 값 그대로 사용 
        
        //채점
        int index1 = 0;		// 수포자1의 배열인덱스 증가용
        int index2 = 1;	// 짝수번호 문제에 사용할 답안을 std2[0]에 저장, 1-4 인덱스만 사용
        int index3 = 0;
//        boolean isOdd = false;	//홀짝 구분	:: 어디에 놓는게 성능에 더 좋은걸까?
        for(int i=0; i<answers.length; i++) {
        	
        	//홀짝구분
        	boolean isOdd = i % 2 == 0 ? false : true;
        	
        	//정답비교
        	if(answers[i] == std1[index1++])
        		score.put(1, score.get(1)+1 );	//수포자1 점수 증가
        	if(answers[i] == (isOdd ? std2[index2++] : std2[0]))
        		score.put(2, score.get(2)+1 );	//수포자2 점수 증가
        	if(answer[i] == (isOdd ? std3[index3++] : std3[index3]))
        		score.put(3, score.get(3)+1 );	//수포자3 점수 증가
        	
        	//찍는 방식 index처리
        	if(index1 == 5) index1 = 0;
        	if(index2 == 5) index2 = 1;
        	if(index3 == 5) index3 = 0;
        }
        
        // 최고득점자 판별
//        int winner = score.get(1) >= score.get(2) ? score.get(1) : score.get(2);
//        winner = winner >= score.get(3) ? winner : score.get(3);
        
        //고득점자 순서대로 정렬
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(score.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));	//value기준 내림차순 정렬
        
        
        
        //동점자 확인 (득점순으로 정렬한것이므로 그냥 순서대로 넣으면 된다..하지만 이건 수포자가 3명이라 가능한 방법..)
//        if(entries.get(0) == entries.get(1)) {
//        	if(entries.get(0) == entries.get(2)) {
//        		answer = new int[] {entries.get(0).getKey(), entries.get(1).getKey(), entries.get(2).getKey()};
//        	}else {
//        		answer = new int[] {entries.get(0).getKey(), entries.get(1).getKey()};
//        	}
//        	Arrays.sort(answer);	//동점자 오름차순 정렬
//        }else {
//        	answer = new int[] {entries.get(0).getKey()};
//        }
        
//        answer = new int[] {score1, score2, score3};
        
        int sameScore = 1;
        if(entries.get(0).getValue() == entries.get(1).getValue()) {
            if(entries.get(0).getValue() == entries.get(2).getValue()) 
                sameScore = 3;
            else sameScore = 2;
        }
        answer = new int[sameScore];
        for(int i=0; i<sameScore; i++)
            answer[i] = entries.get(i).getKey();
        Arrays.sort(answer);
        
        
        return answer;
    }

	
	/*
	 * 처음에는 score를 int변수 3개로 쓰려고 했는데 점수주인이랑 매핑할때 직접매핑 해줘야해서 좀..아닌거같아서 맵으로 변경함
	 */
}
