import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> meetings = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");

			int st = Integer.parseInt(split[0]);
			int et = Integer.parseInt(split[1]);

			meetings.add(new int[] { st, et });

		}

		Collections.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1])
					return o1[1] - o2[1]; // 끝나는 시간을 기준으로 오름차순
				else
					return o1[0] - o2[0];
			}
		});

		int last = 0, cnt = 0;
		
		for(int[] meet: meetings) {
			if (last <= meet[0]) {
				last = meet[1];
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
