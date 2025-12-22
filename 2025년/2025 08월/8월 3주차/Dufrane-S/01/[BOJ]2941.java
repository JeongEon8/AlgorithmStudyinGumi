import java.util.*;
import java.io.*;

public class Main
{
	static String [] two = {"c=", "c-", "d-", "lj", "nj", "s=", "dz=", "z=" };
	
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		split(s);
		
		System.out.println(answer);
	}
	static void split(String s){
	    for(String goal : two){
	        if(s.indexOf(goal)!=-1){
	            int point = s.indexOf(goal);
	            String a = s.substring(0,point);
	            String b = s.substring(point+goal.length(),s.length());
	            answer+=1;
	            split(a);
	            split(b);
	            return;
	        }
	    }
	    answer+=s.length();
	    
	    
	}
}
