import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weight) {
        int answer = 0;
        
        int weight_sum = 0;
        int[] circleQueue = new int[bridge_length];
        int queueIdx = 0;
        
        for(int i=0; i<truck_weight.length; ){
            int nextTruck = 0;
            if(++answer < bridge_length) {
                if(weight >= weight_sum + truck_weight[i]) {
                nextTruck = truck_weight[i++];
            }
            circleQueue[queueIdx++] = nextTruck;
            queueIdx %= bridge_length;
            weight_sum += nextTruck;
                
                /*
                if(weight >= weight_sum + truck_weight[i]) {
                    circleQueue[queueIdx++] = truck_weight[i];
                    queueIdx %= bridge_length;
                    weight_sum += truck_weight[i++];
                }
                */
                continue;
            }
            
            weight_sum -= circleQueue[queueIdx];
            
            //int nextTruck = 0;
            if(weight >= weight_sum + truck_weight[i]) {
                nextTruck = truck_weight[i++];
            }
            circleQueue[queueIdx++] = nextTruck;
            queueIdx %= bridge_length;
            weight_sum += nextTruck;
        }
        
        answer += bridge_length;
        
        
        return answer;
    }
}
