import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1248 {

	static int V, E;
	static int[] findParent;
	static ArrayList<Integer>[] findChildren;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int child1 = Integer.parseInt(st.nextToken());
			int child2 = Integer.parseInt(st.nextToken());
			
			// 초기화
			findParent = new int[V + 1]; // 부모를 저장하는 배열
			findChildren = new ArrayList[V + 1]; // 자식들을 저장하는 리스트
			for (int i = 0; i <= V; i++) {
				findChildren[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				findParent[c] = p;
				findChildren[p].add(c);
			}

			// 공통 조상 찾기
			int parent = findCommonParent(child1, child2);
			// 공통 조상의 서브 트리 개수 찾기
			int subTree = 0;
			if (parent == 1) // 루트 노드면 전체 노드가 서브 트리에 포함됨
				subTree = V;
			else
				subTree = getSubTree(parent);

			sb.append("#").append(t).append(" ").append(parent).append(" ").append(subTree).append("\n");
		}
		System.out.println(sb);
	}

	// 서브 트리 개수 세기
	static int getSubTree(int parent) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(parent);

		int total = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			total++;

			for (int i = 0; i < findChildren[now].size(); i++) {
				queue.offer(findChildren[now].get(i));
			}
		}
		return total;
	}

	// 공통 조상 찾기
	static int findCommonParent(int child1, int child2) {
		ArrayList<Integer> parent1 = new ArrayList<>();
		ArrayList<Integer> parent2 = new ArrayList<>();
		findParents(parent1, child1);
		findParents(parent2, child2);

		for (int i = 0; i < parent1.size(); i++) {
			int p1 = parent1.get(i);
			for (int j = 0; j < parent2.size(); j++) {
				if (p1 == parent2.get(j)) {
					return p1;
				}
			}
		}
		return 1;
	}

	static void findParents(ArrayList<Integer> parent, int child) {
		while (true) {
			int p = findParent[child];
			parent.add(p);
			child = p;

			if (p == 1)
				break;
		}
	}
}
