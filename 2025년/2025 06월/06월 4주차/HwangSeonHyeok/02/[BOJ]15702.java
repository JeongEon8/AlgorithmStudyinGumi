import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Student implements Comparable<Student> {
		int num, score;

		public Student(int student, int score) {
			super();
			this.num = student;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			if (this.score == o.score) {
				return this.num - o.num;
			}
			return o.score - this.score;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[] questionPoints = new int[n];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			questionPoints[i] = Integer.parseInt(split[i]);
		}
		Student[] students = new Student[m];
		for (int i = 0; i < m; i++) {
			split = in.readLine().split(" ");
			int score = 0;
			for (int j = 1; j <= n; j++) {
				if (split[j].equals("O")) {
					score += questionPoints[j - 1];
				}
			}
			students[i] = new Student(Integer.parseInt(split[0]), score);
		}
		Arrays.sort(students);
		System.out.println(students[0].num + " " + students[0].score);

	}

}