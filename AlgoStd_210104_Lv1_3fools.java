import java.util.*;


class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        //수포자들의 찍는방식
        int[] std1 = new int[] {1, 2, 3, 4, 5};
        int[] std2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        //수포자 정답 갯수
        int score1 = 0; int score2 = 0; int score3 = 0;
        //수포자 답지 순환용 인덱스 
        int idx1 = 0; int idx2 = 0; int idx3 = 0;
        //정답 확인
        for(int i : answers) {
            if(i == std1[idx1++])
                score1++;
            if(i == std2[idx2++])
                score2++;
            if(i == std3[idx3++])
                score3++;
            
            //idx 초기화
            if(idx1 == std1.length)
                idx1 = 0;
            if(idx2 == std2.length)
                idx2 = 0;
            if(idx3 == std3.length)
                idx3 = 0;
        }
        
        //최댓값 구하기
        int max = Math.max(score1, score2);
        max = Math.max(max, score3);
        
        //최고득점자 알아내기
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = new int[] {score1, score2, score3};
        for(int i=0; i<arr.length; i++) {
            if(max == arr[i])
                list.add(i+1);
        }
        
        answer = new int[list.size()];
        int idx = 0;
        for(int i : list) {
            answer[idx++]= i;
        }
        
        /*
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
        for(int i=0; i<answers.length; i++) {
        	
        	//홀짝구분
        	boolean isOdd = i % 2 == 0 ? false : true;
        	
        	//정답비교
        	if(answers[i] == std1[index1++])
        		score.put(1, score.get(1)+1 );	//수포자1 점수 증가
        	if(answers[i] == (isOdd ? std2[index2++] : std2[0]))
        		score.put(2, score.get(2)+1 );	//수포자2 점수 증가
        	if(answers[i] == (isOdd ? std3[index3++] : std3[index3]))
        		score.put(3, score.get(3)+1 );	//수포자3 점수 증가
        	
        	//찍는 방식 index처리
        	if(index1 == 5) index1 = 0;
        	if(index2 == 5) index2 = 1;
        	if(index3 == 5) index3 = 0;
        }
        
        //고득점자 순서대로 정렬
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(score.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));	//value기준 내림차순 정렬
        
        //동점자 판별
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
        
        for(int i : answer) {
        	System.out.print(i + " ");
        }
        */
        
        return answer;
    }
}
