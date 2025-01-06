package beakjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Sw5658 {

	static Queue<String>[] arr = new Queue[4];
	Queue<String> qu = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {

			Set<Integer> set = new HashSet<>();

			String[] line = in.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			int n = N / 4;
			for (int i = 0; i < 4; i++) {
				arr[i] = new LinkedList<>();
			}

			// 숫자 입력 받아 배열에 넣기
			line = in.readLine().split("");
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < n; j++) {
					arr[i].offer(line[j + (i * n)]);

				}
			}

			// 번호 경우의 수 만큼 돌리기
			for (int k = 0; k < n; k++) {

				// 번호 한번 돌리기
				for (int i = 0; i < 4; i++) {
					arr[i].offer(arr[(i + 1) % 4].poll());
				}

				// 한줄의 수를 int롤 변형하여 set에 담기
				for (int i = 0; i < 4; i++) {
					String str = "";
					for (int j = 0; j < n; j++) {
						String tmp = arr[i].poll();
						str += tmp;
						arr[i].offer(tmp);
					}
					set.add(Integer.parseInt(str, 16));
					
				}

			}
			
			
			int [] result = new int[set.size()];
			int index = 0;
			
			for(Integer num : set) {
				result[index++] = num;
			}
			
			Arrays.sort(result);
			
		
			System.out.println("#"+(t+1)+" "+result[set.size()-K]);
			


		}

	}

}
