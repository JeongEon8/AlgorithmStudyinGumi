import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
	public static StringBuilder sb;

	public static class Node {
		char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Node[] tree = new Node[26];

		for (int i = 0; i < tree.length; i++) {
			tree[i] = new Node((char) ('A' + i));
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parentData = st.nextToken().charAt(0);
			char leftData = st.nextToken().charAt(0);
			char rightData = st.nextToken().charAt(0);

			int parentIdx = parentData - 'A';

			if (leftData != '.') {
				tree[parentIdx].left = tree[leftData - 'A'];
			}

			if (rightData != '.') {
				tree[parentIdx].right = tree[rightData - 'A'];
			}
		}

		preorder(tree[0]);
		sb.append('\n');
		inorder(tree[0]);
		sb.append('\n');
		postorder(tree[0]);

		System.out.println(sb);
	}

	public static void preorder(Node node) {
		if (node != null) {
			sb.append(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			sb.append(node.data);
			inorder(node.right);
		}
	}

	public static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			sb.append(node.data);
		}
	}
}