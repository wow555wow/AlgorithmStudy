package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class AlgoStd_201208_Lv2_Camouflage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** 위장(해시)
	 * 왜 해시인가?? > 종류별 조합수를 알고있어야하나? 이미 length로 알고있는데?
	 * 설마 hashMap 써서 Hash인건 아니겠지
	 * 
	 * 1. 종류 고르기 : 종류C1 + ... 종류C종류
	 * 2. 종류 내 의상 고르기 : 의상C1
	 * 
	 * [HINT] (한 옷의 종류수 + 1(안입는경우의수))* (한 옷의 종류수 + 1(안입는경우의수)) -(아무것도 안 입는경우의수)
	 *  ㄴ 그냥 경우의수였는데 조합 웅앵대며 내 꾀에 내가 넘어감
	 *  동시에 일어나는 경우의 수 : 곱한다 (곱의법칙 : m * n) >> 모자 * 상의 * 하의 * 겉옷 
	 *  동시에 일어나지 않는 경우의 수 : 더한다 (합의법칙 : m + n) >> 벌거벗었는데 동시에 옷을 입었을 수는 없음
	 *  https://m.blog.naver.com/sbssbi69/220060435293 (경우의수 선생님)
	 * 
	 * <제한조건>
	 * 의상 최소 1개는 걸쳐야 함 (벌거벗은건 조합으로 안침) > 종류C0은 제외
	 * 1 <= clothes.length <= 30
	 * 의상 이름에 대한 조건을 주는 이유가 있는걸까?
	 * 
	 * @param clothes 소유한 의상 {이름 : 종류} 아 왜 종류가 뒤야
	 * @return 전체 조합의 수 리턴
	 */
	public int solution(String[][] clothes) {
        int answer = 0;
        
//        for(int i=0; i<clothes.length; i++) {	//종류 조합 (1개 걸칠지 n개 걸칠지)
//        	for(int j=0; j<clothes.length; j++) {	//조합에 대한 커버가 안됨
//        		answer += clothes[j].length;	// 종류 내 의상 고르기
//        	}
//        }
        
//        //종류C1
//        for(int i=0; i<clothes.length; i++) {	// 종류 조합 구하기
//        	answer += clothes[i].length;
//        }
        
        //clothes 배열을 HashMap에 옮겨 담기
        List<String> tempList;
        HashMap<String, List<String>> closet = new HashMap<>();	//value를 List 말고 가짓수(int)로 하는게 공간복잡도가 작음
        for(int i=0; i<clothes.length; i++) {
        	if(!closet.containsKey(clothes[i][1])) {
        		tempList = new ArrayList<String>();
//        		tempList.add(clothes[i][0]);
//        		closet.put(clothes[i][1], tempList);
        	}else {
        		tempList = closet.get(clothes[i][1]);
//        		tempList.add(clothes[i][0]);
//        		closet.put(clothes[i][1], tempList);
        	}
        	tempList.add(clothes[i][0]);
    		closet.put(clothes[i][1], tempList);
        }
        
        //조합을..어떻게 구해야해...
        /*
         * nC1 = n
         * nC2 = n!/(n-r)! >> {1, 2}...{1,n}, {2,3}...{2,n},...{n-1, n}
         * (ㄴ 이중 for문으로 커버가능)
         * nC3 >> {1, 2, 3}, {1, 2, 4}... 삼중for문은 좀 에바 아닌가
         * nCn = 1 
         */
        
        //[HINT] (한 옷의 종류수 + 1(안입는경우의수))* (한 옷의 종류수 + 1(안입는경우의수)) -(아무것도 안 입는경우의수)
        
        //Iterator 사용하면 초기값 밖에서 설정 가능(closet.values().iterator().next())
        for(Entry<String, List<String>> entry : closet.entrySet()) {
        	if(0 == answer) {
        		answer = entry.getValue().size() + 1;
        	}else {
        		answer *= entry.getValue().size() + 1;
        	}
        }
        
        if(answer >= 0) answer -= 1;	//벌거벗은경우
        
        return answer;
    }

}
