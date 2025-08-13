import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String s = br.readLine();
	    Deque<Character>dq;
	    do{
	        dq = new ArrayDeque<>();
	        boolean yes = true;
	        for(int i=0;i<s.length();i++){
	            char now =s.charAt(i);
	            if(now=='['||now=='('){
	                dq.addLast(now);
	            }else if(now==']'){
	                if(dq.isEmpty()){
	                    yes=false;
	                    break;
	                }
	                char last = dq.pollLast();
	                if(last!='['){
	                    yes=false;
	                    break;
	                }
	            }else if(now==')'){
	                if(dq.isEmpty()){
	                    yes=false;
	                    break;
	                }
	                char last = dq.pollLast();
	                if(last!='('){
	                    yes=false;
	                    break;
	                }
	            }
	        }
	        if(!dq.isEmpty())yes=false;
	        if(yes){
	            System.out.println("yes");    
	        }else{
	            System.out.println("no");    
	        }
	        s = br.readLine();
	    }while(!s.equals("."));
		
		
	}
}
