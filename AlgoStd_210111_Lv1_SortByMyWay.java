import java.util.*;

class Solution { 
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        if(n == 0) {
            Arrays.sort(strings); //바로 리턴하면 converting err (void cannot convert to string[])
            answer = strings.clone();
        }else if(n > 0) {
            for(int i=0; i<strings.length-1; i++) {
                for(int j=i+1; j<strings.length; j++) { //초기값 잘줘라
                    char c1 = strings[i].charAt(n);
                    char c2 = strings[j].charAt(n);
                    
                    if(c1 > c2) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                        
                        //i= -1;  //0번 인덱스부터 다시 정렬
                    }else if(c1 == c2) {
                        if(strings[i].compareTo(strings[j])>0) {
                            String temp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = temp;
                            
                            
                        }
                    }
                }
            }
            answer = strings.clone();
        }
        //strings.clone / Arrays.copyOf(arr, len); //배열복사하기
        return answer;
    }
}
