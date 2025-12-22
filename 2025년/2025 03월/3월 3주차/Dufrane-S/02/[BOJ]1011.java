import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b  = Integer.parseInt(st.nextToken());
		    int n = b-a;
		    System.out.println(logic(n));
		}
	}
	static int logic (int n){
	    int i = 1;
	    int answer = 0;
	    while(n>i*2){
	        answer +=2;
	        n-=i*2;
	        i++;
	    }
	    if(n>i){
	        answer+=2;
	    }else if(n==0){
	        
	    }else{
	        answer++;
	    }
	    return answer;
	}
}
