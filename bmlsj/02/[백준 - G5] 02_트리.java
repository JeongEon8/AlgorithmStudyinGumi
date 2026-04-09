import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Node {
		int id;
		List<Node> children = new ArrayList<>();
		boolean isDeleted = false;

		Node(int id) {
			this.id = id;
		}
	}

	static int N, M;
	static Node[] nodes;
	static int ans;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input);

		String[] split = br.readLine().split(" ");
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}

		int root = -1;
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(split[i]);
			if (parent == -1) { // 부모 노드
				root = i;
			} else {
				nodes[parent].children.add(nodes[i]);
			}
		}

		int delete = Integer.parseInt(br.readLine());
		nodes[delete].isDeleted = true;
		ans = 0;
		countLeaf(nodes[root]);
		System.out.println(ans);

	}

	static void countLeaf(Node node) {

		if (node.isDeleted) return;
		boolean isLeaf = true;
		for (Node next : node.children) {
			if (!next.isDeleted) {
				countLeaf(next);
				isLeaf = false;
				
			}
		}
		
		if (isLeaf) ans++;
	}
}