import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Road implements Comparable<Road> {
		int a, b, width;

		public Road(int a, int b, int width) {
			this.a = a;
			this.b = b;
			this.width = width;
		}

		@Override
		public int compareTo(Road o) {

			return o.width - this.width;
		}

	}

	static int[] parent;

	static int findParent(int idx) {
		if (parent[idx] == idx) {
			return idx;
		}
		return parent[idx] = findParent(parent[idx]);
	}

	static boolean setGroup(int a, int b) {
		int aRoot = findParent(parent[a]);
		int bRoot = findParent(parent[b]);
		if (aRoot == bRoot) {
			return false;
		} else {
			parent[bRoot] = aRoot;
			return true;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int p = Integer.parseInt(split[0]);
		int w = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		int start = Integer.parseInt(split[0]);
		int end = Integer.parseInt(split[1]);
		Road[] roads = new Road[w];
		for (int i = 0; i < w; i++) {
			split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int width = Integer.parseInt(split[2]);
			roads[i] = new Road(a, b, width);
		}
		Arrays.sort(roads);
		parent = new int[p];
		for (int i = 1; i < p; i++) {
			parent[i] = i;
		}
		for (Road road : roads) {
			int a = road.a;
			int b = road.b;
			if (setGroup(a, b)) {
				if (findParent(start) == findParent(end)) {
					System.out.println(road.width);
					break;
				}
			}
		}

	}

}