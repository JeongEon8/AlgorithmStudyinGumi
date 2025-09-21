import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_11651 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Location[] locations = new Location[N];

		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split(" ");
			int x = Integer.parseInt(strArr[0]);
			int y = Integer.parseInt(strArr[1]);
			Location location = new Location(x, y);
			locations[i] = location;
		}
		Arrays.sort(locations, Comparator.comparing((Location l) -> l.y).thenComparing(l -> l.x));

		for (int i = 0; i < N; i++) {
			sb.append(locations[i].x + " " + locations[i].y + "\n");
		}

		System.out.println(sb.toString());
	}
}