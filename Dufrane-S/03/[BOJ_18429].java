import java.util.*;
import java.io.*;
public class Main
{
	static int weight = 500;
	static int answer= 0;
	static int minus;
	static int [] kits;
	static int n;
	static boolean [] done;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		kits = new int[n];
		done = new boolean[n];
		minus = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
		    kits[i]=Integer.parseInt(st.nextToken());;
		}
		dfs(0);
		System.out.println(answer);
	}
	static void dfs(int depth) {
		if(depth==n) {
			answer++;
			return;
		}
		
		weight-=minus;
		for(int i=0; i<n; i++) {
		    if(!done[i]){
		        weight+=kits[i];
    		    if(weight>=500) {
    				done[i]=true;
    				dfs(depth+1);
    				done[i]=false;
    			}    
    			weight-=kits[i];
		    }
		}
		weight+=minus;
	}
}
