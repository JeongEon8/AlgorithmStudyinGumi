import java.util.*;
import java.io.*;


public class Main{
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Map<String, Boolean>m = new HashMap<String,Boolean>();
		List<String>[]list = new ArrayList[51];
		for(int i=0;i<51;i++) {
			list[i]=new ArrayList<String>();
		}
		for(int i=0;i<n;i++) {
			String s= sc.next();
			if(m.get(s)==null) {
				m.put(s, true);	
				list[s.length()].add(s);
			}
		}
		for(int i=0;i<51;i++) {
			if(list[i].size()==0) {
				continue;
			}else if(list[i].size()==1) {
				System.out.println(list[i].get(0));
			}else {
				Collections.sort(list[i]);
				for(int j=0;j<list[i].size();j++) {
					System.out.println(list[i].get(j));
				}
			}
		}
		
	}
}
