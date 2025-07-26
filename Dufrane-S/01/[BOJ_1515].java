import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int i=1;
		int idx=0;
		
        while(s.length()!=idx){
            String now = i+"";
            for(int j = 0;j<now.length();j++){
                if(now.charAt(j)==s.charAt(idx)){
                    idx++;
                }
                if(idx==s.length()){
                    System.out.println(i);
                
                    return;
                }
            }
            i++;    
        }
		System.out.println(i);
	}
}
