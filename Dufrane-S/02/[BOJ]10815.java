import java.util.*;
import java.io.*;

public class Main
{
	static String [] two = {"c=", "c-", "d-", "lj", "nj", "s=", "dz=", "z=" };
	
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer,Boolean>map = new HashMap<>();
		for(int i=0;i<N;i++){
		    map.put(Integer.parseInt(st.nextToken()),true);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
		    if(null!=map.get(Integer.parseInt(st.nextToken()))){
		        System.out.print("1 ");
		    }else{
		        System.out.print("0 ");
		    }
		}
		
	}
}
