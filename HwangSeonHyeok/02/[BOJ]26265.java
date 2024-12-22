import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Pair implements Comparable<Pair>{
		String mentor, mentee;

		public Pair(String mentor, String mentee) {
			super();
			this.mentor = mentor;
			this.mentee = mentee;
		}

		

		@Override
		public String toString() {
			return  mentor + " " + mentee;
		}



		@Override
		public int compareTo(Pair o) {
			if(this.mentor.equals(o.mentor)) {
				return o.mentee.compareTo(this.mentee);
			}
			return this.mentor.compareTo(o.mentor);
		}
		
		
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(in.readLine());
		Pair[] pairs = new Pair[n];
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split(" ");
			pairs[i] = new Pair(split[0],split[1]);
		}
		Arrays.sort(pairs);
		for(int i = 0; i<n;i++) {
			System.out.println(pairs[i]);
		}
		

	}

}