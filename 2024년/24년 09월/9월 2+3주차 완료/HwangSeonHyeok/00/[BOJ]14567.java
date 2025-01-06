import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static class Subject {
		int num, back, semester;
		List<Integer> next;

		public Subject(int num) {
			this.num = num;
			this.back = 0;
			this.semester = 1;
			this.next = new ArrayList<>();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		Subject[] subjectArr = new Subject[n + 1];
		for (int i = 1; i <= n; i++) {
			subjectArr[i] = new Subject(i);
		}
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);
			subjectArr[from].next.add(to);
			subjectArr[to].back++;
		}
		Queue<Subject> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (subjectArr[i].back == 0) {
				q.add(subjectArr[i]);
			}
		}
		int[] ans = new int[n + 1];
		while (!q.isEmpty()) {
			Subject current = q.poll();
			ans[current.num] = current.semester;
			for (int snum : current.next) {
				subjectArr[snum].back--;
				if (current.semester >= subjectArr[snum].semester) {
					subjectArr[snum].semester = current.semester + 1;
				}
				if (subjectArr[snum].back == 0) {
					q.add(subjectArr[snum]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);

	}

}