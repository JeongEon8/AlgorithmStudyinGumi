import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Solution {

	static HashMap<String, Integer> hash;
	static int[] parent, size;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int T = Integer.parseInt(input);
		for (int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());

			hash = new HashMap<>();
			parent = new int[2 * F];
			size = new int[2 * F];

			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				size[i] = 1;
			}

			int idx = 0;
			for (int i = 0; i < F; i++) {
				String[] split = br.readLine().split(" ");
				for (int j = 0; j < split.length; j++) {

					// 친구 그래프에 아직 없을 경우, 추가
					if (!hash.containsKey(split[j])) {
						hash.put(split[j], idx++);
					}

				}

				int a = hash.get(split[0]);
				int b = hash.get(split[1]);

				// 네트워크 합치기
				System.out.println(union(a, b));

			}
		}

	}

	static int find(int u) {
		if (parent[u] != u) {
			parent[u] = find(parent[u]);
		}

		return parent[u];
	}

	static int union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a != b) {

			// 항상 a가 대표를 하게 하기 위해 swap
			if (size[a] < size[b]) {
				int tmp = a;
				a = b;
				b = tmp;
			}

			parent[b] = a;
			size[a] += size[b];
		}

		return size[a];
	}

}