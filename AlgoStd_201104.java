import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> releases = new ArrayList<>();
        
        int startRelease = 0;
        int releasingJobs = 0;
        
        while(startRelease < progresses.length) {
            for(int i=0; i<progresses.length; i++) {
                if(progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }else {
                    if(startRelease <= i && startRelease + releasingJobs == i)
                        releasingJobs++;
                }
            }
            
            if(0<releasingJobs) {
                releases.add(releasingJobs);
                startRelease += releasingJobs;
                releasingJobs = 0;
            }
        }
        
        answer = new int[releases.size()];
        int i=0;
        for(Integer release : releases)
            answer[i++] = release;
        
        
        return answer;
    }
}
