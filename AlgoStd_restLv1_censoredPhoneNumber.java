package level1;

public class AlgoStd_restLv1_censoredPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(String phone_number) {
        String answer = "";
        
        int lenBefore4 = phone_number.length()-4;
        for(int i=0; i<lenBefore4; i++) {
            answer += "*";
        }
        answer += phone_number.substring(lenBefore4, phone_number.length());
        
        
        return answer;
    }

}
