import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1225 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case);
			int t = Integer.parseInt(in.readLine());
			String[] line = in.readLine().split(" ");
			int[] nums = new int[8];
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				nums[i] = Integer.parseInt(line[i]);
				q.add(nums[i]);
			}

			int minus = 1;
			do {
				int tmp = q.poll();
				tmp -= minus;
				if (tmp <= 0) {
					q.add(0);
					break;
				} else {
					q.add(tmp);
				}
				minus += 1;
				if (minus == 6)
					minus = 1;
			} while (true);
			
			for (int i : q) {
				sb.append(" "+ i);
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

}