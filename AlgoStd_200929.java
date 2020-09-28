package level1;

import java.util.Scanner;

public class AlgoStd_200929 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
//        System.out.println("[" + a + ", " + b + "]");
        
        for(int col=0; col<b; col++) {
        	String stars = "";
        	for(int row=0; row<a; row++) 
        		stars += "*";
        		
        	System.out.println(stars);
        }

//        System.out.println(a + b);
    }

}
