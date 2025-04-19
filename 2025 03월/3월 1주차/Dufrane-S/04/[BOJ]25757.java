import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		char m = st.nextToken().charAt(0);
		Map<String,Integer>map = new HashMap<>();
		int count =0;
		for(int i=0;i<n;i++){
		    String now = br.readLine();
		    if(map.get(now)==null){
		        map.put(now,1);
		        count++;
		    }
		}
		int p=0;
		if(m=='Y'){
		    p=1;
		}else if(m=='F'){
		    p=2;
		}else if(m=='O'){
		    p=3;
		}
		int answer = count/p;
		System.out.println(answer);
	}
}
