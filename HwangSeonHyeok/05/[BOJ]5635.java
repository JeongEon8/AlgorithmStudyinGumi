import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static class Student implements Comparable<Student>{
		String name;
		int y, m, d;
		public Student(String name, int d, int m, int y) {
			super();
			this.name = name;
			this.y = y;
			this.m = m;
			this.d = d;
		}
		@Override
		public int compareTo(Student o) {
			if(this.y==o.y && this.m==o.m) {
				return o.d-this.d;
			}else if(o.y==this.y) {
				return o.m - this.m;
			}
			return o.y-this.y;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Student[] sArr = new Student[n];
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split(" ");
			sArr[i] = new Student(split[0],Integer.parseInt(split[1]),Integer.parseInt(split[2]),Integer.parseInt(split[3]));			
		}
		Arrays.sort(sArr);
		System.out.println(sArr[0].name);
		System.out.println(sArr[n-1].name);

	}

}