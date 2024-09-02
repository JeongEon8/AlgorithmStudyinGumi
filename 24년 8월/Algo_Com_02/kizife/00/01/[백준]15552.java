import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sum = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sum.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
		}
		br.close();
		System.out.println(sum);
		
		
	}

}
