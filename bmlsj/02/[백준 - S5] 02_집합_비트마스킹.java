import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 
 * 1 ~ 20 까지의 수이므로 비트 마스킹으로 충분
 * set & (1 << (x - 1))의 결과는 1, 2, 4, 8, ..., 2^19 중 하나
*  따라서 == 1 조건은 x == 1일 때만 참이고, 나머지는 전부 실패
 */
public class 집합_비트마스킹_11723 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		int set = 0; // 00000000000000000000
		for (int i = 0; i < M; i++) {

			String[] split = br.readLine().split(" ");

			String cmd = split[0];
			int x = 0;
			if (split.length > 1) {
				x = Integer.parseInt(split[1]);
			}

			switch (cmd) {
			case "add":
				set |= 1 << (x - 1);
				break;
			case "remove":
				set &= ~(1 << (x - 1));
				break;
			case "check":
				bw.write((set & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
				break;

			case "toggle": // set ^= (1 << (x - 1));
				if ((set & (1 << (x - 1))) != 0) { // 있으면
					set &= ~(1 << (x - 1)); // 제거
				} else {
					set |= (1 << (x - 1)); // 추가
				}
				break;
			case "all":
				set = (1 << 20) - 1;
				break;
			case "empty":
				set = 0;
				break;
			default:
				break;

			}
		}
		bw.flush();

	}

}
