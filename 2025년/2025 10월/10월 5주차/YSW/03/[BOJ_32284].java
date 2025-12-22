import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_32284 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] stringArr = br.readLine().split(" ");
		int N = Integer.parseInt(stringArr[0]);
		int M = Integer.parseInt(stringArr[1]);
		stringArr = br.readLine().split(" ");
		int a = Integer.parseInt(stringArr[0]);
		int b = Integer.parseInt(stringArr[1]);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i < a) {
					sb.append("S");
				}else if(i==a) {
					if(j <= b) {
						sb.append("E");
					}else {
						sb.append("W");
					}
				}else {
					sb.append("N");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
