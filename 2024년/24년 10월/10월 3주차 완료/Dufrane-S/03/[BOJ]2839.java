import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = Integer.parseInt(s);
		
		//ArrayList<Integer>box =new ArrayList(); 
		int list[]= new int [5000];
		for(int i=0;i<5000;i++) {
			list[i]=999999;
		}
		list[2]=1;
		list[4]=1;
		for(int i=3;i<n;i++) {
			if(list[i-3]!=999999 && list[i-3]+1<list[i]) {
				list[i]=list[i-3]+1;
			}
			if(i-5>=0&&list[i-5]!=999999 && list[i-5]+1<list[i]) {
				list[i]=list[i-5]+1;
			}
		}
		/*for(int i=0;i<n;i++) {
			System.out.println(i+1+" : " + list[i]);	
		}*/
		if(list[n-1]==999999) {
			System.out.println(-1);
		}else {
			System.out.println(list[n-1]);	
		}
		
	}
	
}
