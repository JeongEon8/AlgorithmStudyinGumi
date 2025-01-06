import java.util.*;
import java.io.*;


public class Main{
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = 666;
		int answer=1;
		
		while(true) {
			String test=Integer.toString(num);
			if(test.contains("666") && answer==n) {break;
			}else if(test.contains("666")) {
				answer++;
				num++;
			}else {
				num++;
			}
		
		}
		System.out.println(num);
	}
}
