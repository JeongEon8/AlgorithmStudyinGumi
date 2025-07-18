
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		int N = Integer.parseInt(split[0]); // 국가 수
		int K = Integer.parseInt(split[1]); // 등수를 알고 싶은 국가

		int[][] country = new int[N][4];
		for (int t = 0; t < N; t++) {
			split = br.readLine().split(" ");
			int idx = Integer.parseInt(split[0]) - 1;

			country[idx][0] = idx + 1;
			for (int i = 1; i <= 3; i++) {
				country[idx][i] = Integer.parseInt(split[i]);
			}

		}

		
		// 정렬
		Arrays.sort(country, (o1, o2) -> {
		    if (o1[1] != o2[1]) return o2[1] - o1[1]; // 금
		    if (o1[2] != o2[2]) return o2[2] - o1[2]; // 은
		    return o2[3] - o1[3];                     // 동
		});
		
	
		int rank = 1;
		for(int i = 0; i < N; i++) {
			
			if (i > 0) {
				if (country[i][1] == country[i - 1][1] &&
						country[i][2] == country[i-1][2] &&
						country[i][3] == country[i-1][3] ) {
					// 이전 국가와 메달 수가 같을 때
				} else {
					rank = i + 1;
				}
			}
			
			if (country[i][0] == K) {
				System.out.println(rank);
				break;
			}
		}

	}

}
