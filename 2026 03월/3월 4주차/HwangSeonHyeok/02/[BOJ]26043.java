import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Student {
		int num, likeMenu;

		public Student(int num, int likeMenu) {
			super();
			this.num = num;
			this.likeMenu = likeMenu;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Queue<Student> q = new ArrayDeque<Student>();
		List<Integer> happy = new ArrayList<>();
		List<Integer> unHappy = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) {
				int num = Integer.parseInt(st.nextToken());
				int like = Integer.parseInt(st.nextToken());
				q.add(new Student(num, like));
			} else {
				int menu = Integer.parseInt(st.nextToken());
				Student nextStudent = q.poll();
				if (nextStudent.likeMenu == menu) {
					happy.add(nextStudent.num);
				} else {
					unHappy.add(nextStudent.num);
				}
			}
		}
		List<Integer> hungry = new ArrayList<>();
		for (Student s : q) {
			hungry.add(s.num);
		}
		Collections.sort(happy);
		Collections.sort(unHappy);
		Collections.sort(hungry);
		StringBuilder sb = new StringBuilder();
		if (happy.isEmpty()) {
			sb.append("None");
		}
		for (int num : happy) {
			sb.append(num).append(" ");
		}
		sb.append('\n');
		if (unHappy.isEmpty()) {
			sb.append("None");
		}
		for (int num : unHappy) {
			sb.append(num).append(" ");
		}
		sb.append('\n');
		if (hungry.isEmpty()) {
			sb.append("None");
		}
		for (int num : hungry) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);

	}

}