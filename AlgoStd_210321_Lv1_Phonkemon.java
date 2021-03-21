package Lv1;

import java.util.ArrayList;
import java.util.List;

public class AlgoStd_210321_Lv1_Phonkemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** 210321 폰켓몬
	 * 
	 * 오박사님의 폰켓몬들 중 절반을 가져올 수 있음.
	 * 더 많은 종류의 폰켓몬을 가질 수 있도록 
	 * 
	 * 1. 오박사가 가진 폰켓몬의 전체 종류 파악 > 중복제거 (list.contains 사용)
	 * 2. 1을 n/2와 비교해서 둘중 큰거 리턴하면 될듯?
	 * 
	 * @param nums
	 * @return 가장 많은 종류의 폰켓몬을 가질 수 있는 경우의 폰켓몬 종류 수;
	 */
	public int solution(int[] nums) {
        int answer = nums.length/2;
        
        List<Integer> distinct = new ArrayList<>();
        
        for(int i : nums) {
        	if(!distinct.contains(i))
        		distinct.add(i);
        	if(distinct.size() >= answer)
        		return answer;
        }
        answer = distinct.size();
        
        return answer;
    }

}
