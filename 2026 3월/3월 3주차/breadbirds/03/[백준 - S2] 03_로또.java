import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int s[];
	static int combi[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			
			s = new int [k];
			combi = new int[6];
			for(int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
		
	}
	private static void dfs(int idx, int start) {
		if(idx == 6) { //만약에 6개를 다 뽑으면 멈추고 출력할거임
			for(int answer : combi) {
				System.out.print(answer+" ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < k; i++) {
			combi[idx] = s[i];
			dfs(idx+1, i+1);
		}
		
	}

}