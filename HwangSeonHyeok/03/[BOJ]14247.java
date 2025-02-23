import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Tree implements Comparable<Tree> {
		int start, grow;

		@Override
		public int compareTo(Tree o) {
			return this.grow - o.grow;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Tree[] trees = new Tree[n];
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			trees[i] = new Tree();
			trees[i].start = Integer.parseInt(split[i]);
		}
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			trees[i].grow = Integer.parseInt(split[i]);
		}
		Arrays.sort(trees);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += trees[i].start + trees[i].grow * i;
		}
		System.out.println(ans);
	}

}