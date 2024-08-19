import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Place {
		int x, y;

		Place() {}

		public Place(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int n, m;
	static int ans = Integer.MAX_VALUE;
	static List<Place> homeList;
	static List<Place> chickenList;
	static Place[] selectedChicken;

	static int getDist(Place h) {
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			int curDist = Math.abs(h.x - selectedChicken[i].x) + Math.abs(h.y - selectedChicken[i].y);
			if (minDist > curDist) {
				minDist = curDist;
			}
		}

		return minDist;
	}

	static void solve(int start, int depth) {
		if (depth == m) {
			int cityDist = 0;
			for (int i = 0; i < homeList.size(); i++) {
				cityDist += getDist(homeList.get(i));
			}
			if (ans > cityDist) {
				ans = cityDist;
			}
			return;
		}
		for (int i = start; i < chickenList.size(); i++) {
			selectedChicken[depth] = chickenList.get(i);
			solve(i + 1, depth + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);
		chickenList = new ArrayList<>();
		homeList = new ArrayList<>();
		selectedChicken = new Place[m];

		for (int i = 1; i <= n; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int place = Integer.parseInt(split[j]);
				if (place == 1) {
					homeList.add(new Place(j, i));
				} else if (place == 2) {
					chickenList.add(new Place(j, i));
				}
			}
		}
		solve(0, 0);
		System.out.print(ans);

	}

}