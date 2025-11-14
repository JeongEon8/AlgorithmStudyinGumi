import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int n, m;

	static class Person implements Comparable<Person> {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		n = Integer.parseInt(input);
		Person[] arr = new Person[n];
		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			arr[i] = new Person(Integer.parseInt(split[0]), split[1]);
		}
		
		Arrays.sort(arr);

		for (Person p : arr) {
			System.out.println(p.age + " " + p.name);
		}

	}

}
