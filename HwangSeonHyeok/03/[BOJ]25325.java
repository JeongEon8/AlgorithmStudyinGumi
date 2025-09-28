import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static class Student implements Comparable<Student> {
		String name;
		int popularity;

		public Student(String name) {
			this.name = name;
			this.popularity = 0;
		}

		public void increase() {
			this.popularity++;
		}

		@Override
		public int compareTo(Student o) {
			if (this.popularity != o.popularity) {
				return o.popularity - this.popularity;
			} else {
				return this.name.compareTo(o.name);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		Map<String, Integer> map = new TreeMap<>();
		Student[] students = new Student[n];
		for (int i = 0; i < n; i++) {
			String name = st.nextToken();
			map.put(name, i);
			students[i] = new Student(name);
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				String name = st.nextToken();
				students[map.get(name)].increase();
			}
		}
		Arrays.sort(students);
		StringBuilder sb = new StringBuilder();
		for (Student s : students) {
			sb.append(s.name).append(" ").append(s.popularity).append('\n');
		}
		System.out.println(sb);
	}

}