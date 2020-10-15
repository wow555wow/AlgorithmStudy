package level1;

public class AlgoStd_201015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(121));

	}
	
	
	public static long solution(long n) {
        long answer = 0;
        
//        try{
        	
//        	System.out.println(Math.sqrt(n));
//        	System.out.println(String.valueOf(Math.sqrt(n)));
//        	System.out.println();
        	
        	double root = Math.sqrt(n);
        	
        	if(0 == Double.compare(root, Math.round(root)) ) {
        		answer = Integer.parseInt(String.valueOf(Math.round(root)));
        		return (long) Math.pow(answer+1, 2);
        	}else return -1L;
        	
        	
//        	int i = Integer.parseInt( String.valueOf(Math.sqrt(n)) );
//        	System.out.println(">>" + i);
//        	answer = (long) Math.pow(i+1, 2);
//        }catch(Exception e) {
//            return -1L;
//        }
        
//        return answer;
    }

}
