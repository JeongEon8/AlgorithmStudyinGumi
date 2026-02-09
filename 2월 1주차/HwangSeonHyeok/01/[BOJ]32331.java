import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int num, score;

		public Student(int num, int score) {
			super();
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			return Integer.compare(this.score, o.score);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int minNum = 2024000000;
		List<Student> candidateStudents = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		int studentNum = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		Student hanyang = new Student(studentNum, score);
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			studentNum = Integer.parseInt(st.nextToken());
			score = Integer.parseInt(st.nextToken());
			if (studentNum >= minNum) {
				candidateStudents.add(new Student(studentNum, score));
			}
		}
		Collections.sort(candidateStudents);
		int candidateNum = candidateStudents.size();
		if (candidateNum >= m) {
			int candidateScore = candidateStudents.get(candidateNum - m).score;
			int predictScore = Math.max(y - (x - candidateScore), 0) + candidateScore;
			int hanayngMax = hanyang.score + y;
			if (predictScore > hanayngMax) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				System.out.println(Math.max(predictScore - hanyang.score, 0));
			}

		} else {
			System.out.println("YES");
			System.out.println(0);
		}

	}

}