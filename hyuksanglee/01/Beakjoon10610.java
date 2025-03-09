package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beakjoon10610 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] N = in.readLine().split(""); 
       
        
        Arrays.sort(N); 

      
        if (!N[0].equals("0") ) {
            System.out.println("-1");
            return;
        }

        
        String result ="";
        int sum = 0;
        for (String c : N) {
        	result = c+result;
            sum += Integer.parseInt(c); 
        }

        
        
        if (sum % 3 != 0) {
            System.out.println("-1");
            return;
        }

        
        System.out.println(result);

	}

}
