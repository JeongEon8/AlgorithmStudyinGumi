import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = Integer.parseInt(s);
		
		ArrayList<Integer>box =new ArrayList(); 
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) {
				box.add(a);	
			}else if(!box.isEmpty() && a==0){
				box.remove(box.size()-1);
			}
		}
		int sum=0;
		for(int i=0;i<box.size();i++) {
			sum+=box.get(i);
		}
		System.out.println(sum);
	}
}
