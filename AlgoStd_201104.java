import java.util.*;

class Solution {
    
    /** 201104 기능개발
    * 진도가 100일 때 반영 가능
    * 뒤에 있는 기능이 먼저 개발될 수 있음
    *  ㄴ 앞에 있는 기능이 배포될 떄 함께 배포 (연속되어야 배포 가능한건지?
    * 배포는 하루에 한 번, 하루의 끝에
    *
    * 진도 < 100
    * 속도 < 100 (일일 작업량)
    * 
    * progresses.length == speeds.length
    * @param progresses : 배포될 순서로 작업의 진도가 적힌 배열
    * @param speeds : 각 작업의 개발 속도
    * @return : 각 배포마다 몇개의 기능이 배포되는지?
    */
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> releases = new ArrayList<>(); //배포되는 기능의 수 배열
        
        int startRelease = 0;   // 배포 시작 위치
        int releasingJobs = 0;  // 한번에 배포될 작업의 수
        
        while(startRelease < progresses.length) {   // 모든 작업의 배포가 완료될 때 까지 반복
            for(int i=0; i<progresses.length; i++) {    // 하루 일하기 (며칠이 지났는지는 몰라도 됨)
                if(progresses[i] < 100) {   // 미완료 작업
                    progresses[i] += speeds[i]; // 일일 작업량 증가 (100이 되면 더하지 않는다)
                }else { //완료한 작업
                    // 1. 한 번 배포한 작업을 또 배포하지는 않음
                    // 2. 연속되는 작업만 배포
                    
                    // startRelease + releasingJobs : 배포할 작업들 중 가장 마지막 인덱스 + 1 
                    // 연속되는 작업이어야 함께 배포가 가능하므로 연속작업 인덱스의 다음 값이 현재 작업의 인덱스여야 함)
                    if(startRelease <= i && startRelease + releasingJobs == i)  // 배포 예정 작업보다 순서가 작거나 같고 && 연속되는 작업이면*
                        releasingJobs++;    //배포 예정 작업의 수 증가
                }
            }
            
            //하루 일과를 마친 후
            if(0<releasingJobs) {   //배포할 작업이 있으면
                releases.add(releasingJobs);    // 배포 (배포 리스트에 추가)
                startRelease += releasingJobs;  // 배포 시작 작업 idx 증가
                releasingJobs = 0;  // 배포 예정 작업의 수 초기화
            }
        }
        
        // list to arr
        answer = new int[releases.size()];
        int i=0;
        for(Integer release : releases)
            answer[i++] = release;
        
        
        return answer;
    }
}
