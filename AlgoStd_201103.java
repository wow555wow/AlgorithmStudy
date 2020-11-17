import java.util.*;
class Solution {
    
    /** 201103 다리를 지나는 트럭
    *
    * 동시에 2트럭이 지나갈 수는 없고, 1초 뒤에 지나갈 수 있음
    * 트럭에게는 순서가 있음. 순서대로 다리를 지나야 함
    *
    * 1. 트럭 배열을 돌면서
    * 2. 다리 하중과 트럭 무게를 비교
    *  2-1. 다리 하중과 같으면 지금 트럭만
    *  2-2. 다리 하중보다 작으면 >> 지금트럭+다음트럭 무게와 최대하중 비교
    *   2-2-1. 다리하중보다 작으면 >> 지금트럭+다음트럭+다다음트럭 무게와 최대하중 비교 (반복)
    *  최대하중에 가까워질 때까지 트럭을 다리로 보내고 (다리길이도 생각해)
    *
    * 무게체크 시점
    *  1. 트럭이 다리에 진입할 때
    *  2. 1초가 지나 다음 트럭이 다리에 진입할 때
    *  3. 트럭이 다리에서 나갈 때
    *
    * Queue > 인터페이스만 정의되어 있어서 선택해서 새로 구현해 줘야 함.
    *  priorityQueue(우선순위큐), deque(앞뒤 모두에서 꺼낼 수 있음 : stack과 queue로 모두 사용 가능)
    *
    * @param bridge_length
    * @param weight
    * @param truck_weigth
    * @return 모든 트럭이 다리를 건너는데 걸리는 최단시간
    */
    
    public int solution(int bridge_length, int weight, int[] truck_weight) {
        int answer = 0; //소요시간
        
        int weight_sum = 0; //다리 위에 올라간 트럭들의 무게 합
        int[] circleQueue = new int[bridge_length]; // 다리 위(트럭을 올릴 공간, 다리 길이만큼 정의), 원형큐 사용하여 길이 고정함.
        int queueIdx = 0;   //트럭을 넣을 큐의 인덱스
        
        /*
        * 1. 큐가 다 차기 전까지는 넣는다 (근데 무게체크도 해야 함)
        * 2. 큐가 다 차면 버리면서 넣는다 (근데 무게체크도 해야 함)
        * 3. 더 넣을 트럭이 없으면 버리기만 한다
        *
        */
        
        for(int i=0; i<truck_weight.length; ){  //트럭이 모두 다리를 지날 때까지 반복
            
            /*
            int nextTruck = 0;  //다음에 다리를 지날 트럭의 무게, 최대하중에 다다라서 다음에 트럭이 올 수 없는 경우는 0으로 표시한다 (무게가 없음 0)
            if(++answer < bridge_length) {  // 반복시마다 시간증가, 시간이 다리길이보다 적게 지난 때에는 다리에 트럭을 넣기만 할 수 있음 (1. 큐가 다 차기 전까지는 넣기만 한다)
                if(weight >= weight_sum + truck_weight[i]) {    // 무게체크 : 다리의 최대하중 >= 현재 다리 위 트럭의 무게합 + 다음에 올 트럭의 무게
                    nextTruck = truck_weight[i++];  // 다리 최대하중보다 작으면 다음에 올 트럭의 무게를 더해줌
                }
            circleQueue[queueIdx++] = nextTruck;    // 큐의 현재 위치에 올라올 트럭을 넣고, 인덱스 증가(다음에 바로 넣을 수 있도록 준비)
            queueIdx %= bridge_length;  // 원형큐 인덱스처리. 큐의 길이로 나눈 나머지를 인덱스로 사용.
            weight_sum += nextTruck;    // 다리 위 트럭 무게 총합에 올라올 트럭의 무게를 더해줌
               
            continue;
            }
            */
            
            // 2. 큐가 다 차면 버리면서 넣는다 : 다리길이가 2일 때 2초가 지난 상황. 근데 왜 먼저 빼지? 3초일때 빠지는거 아닌가? 큐인덱스랑 잘 엮어서 생각해봐
            // 시간이 2흘렀을때 큐인덱스는 1. 들어있는게 없어서 뺄 것도 없기 때문에 등호가 있는 경우에도 상관이 없었던 듯. 등호가 빠지는게 맞는 조건인 것 같다.
            // 트럭이 다리길이에 다다랐을 때 > 트럭의 빼기와 올리기가 동시에 일어난다. 다음에 올려주려면 빼는걸 먼저 해줘야 함. (이부분 헷갈리는데 다시 생각해보자)
            //if(++answer >= bridge_length) { // 반복시마다 시간증가(1초에서 시작, 다리에 올리는 순간 1초가 지나므로), 시간이 다리길이만큼 지난 뒤에는 트럭을 다리 위에서 꺼낼 수 있다.
            
            // 2. 큐가 다 차면 버리면서 넣는다
            if(++answer > bridge_length) {  // 반복시마다 시간증가(1초에서 시작, 다리에 올리는 순간 1초가 지나므로), 시간이 다리길이만큼 지난 뒤에는 트럭을 다리 위에서 꺼낼 수 있다.
                //다리를 다 지나면 트럭은 무조건 내려야만 함.
                weight_sum -= circleQueue[queueIdx];    // 다리 위 트럭 무게 총합에서 현재 위치(다음에 트럭 넣을 자리 == 다리에 끝에 다다라서 내려야 할 트럭이 있는 자리)의 트럭을 꺼낸다
                // 원형큐라 뺄 트럭의 인덱스에 다음 트럭을 올릴 것이므로 따로 배열에서 빼는 연산은 수행하지 않음
            }
            
            // 다리 위에 트럭 올리기
            int nextTruck = 0;  //다음에 다리를 지날 트럭의 무게, 최대하중에 다다라서 다음에 트럭이 올 수 없는 경우는 0으로 표시한다 (무게는 없지만 빈공간으로 자리는 차지해야 함)
            if(weight >= weight_sum + truck_weight[i]) {    // 무게체크 : 다리의 최대하중 >= 현재 다리 위 트럭의 무게합 + 다음에 올 트럭의 무게
                nextTruck = truck_weight[i++];  // 다리 최대하중보다 작으면 다음에 올 트럭의 무게를 더해줌
            }
            circleQueue[queueIdx++] = nextTruck;    // 큐의 현재 위치에 올라올 트럭을 넣고, 인덱스 증가(다음에 바로 넣을 수 있도록 준비)
            queueIdx %= bridge_length;  // 원형큐 인덱스처리. 큐의 길이로 나눈 나머지를 인덱스로 사용.
            weight_sum += nextTruck;    // 다리 위 트럭 무게 총합에 올라올 트럭의 무게를 더해줌
        }   // 마지막 트럭이 다리에 올라가는 순간 반복 종료
        
        answer += bridge_length;    // 이후 마지막 트럭이 다리를 다 지나기만 하면 되므로 > 다리길이만큼의 시간이 지나면 모든 트럭이 다리를 지나게 됨
        
        
        return answer;
    }
}