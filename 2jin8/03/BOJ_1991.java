import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1991 {

    static int N, M = 26;
    static int[] degree = new int[M];
    static HashMap<Integer, Node> trees = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        // 알파벳 순으로 주어준다고 했지 상위 노드부터 준다고는 안했음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String[] nodes = br.readLine().split(" ");
            char parent = nodes[0].charAt(0);
            char left = nodes[1].charAt(0);
            char right = nodes[2].charAt(0);

            if (left != '.') degree[left - 'A']++;
            if (right != '.') degree[right - 'A']++;

            trees.put(parent - 'A', new Node(left, right));
        }

        // 루트 노드 찾기
        int root = -1;
        for (int i = 0; i < M; i++) { // i: char - 'A'
            if (degree[i] == 0) {
                root = i;
                break;
            }
        }

        preOrder(root);
        sb.append("\n");

        inOrder(root);
        sb.append("\n");

        postOrder(root);
        sb.append("\n");

        System.out.println(sb);
    }

    static void preOrder(int root) { // M - L - R
        // Root
        sb.append((char) (root + 'A'));

        Node node = trees.get(root);

        // Left
        if (node.l != '.') preOrder(node.l - 'A');

        // Right
        if (node.r != '.') preOrder(node.r - 'A');
    }

    static void inOrder(int root) { // L - M - R
        Node node = trees.get(root);

        // Left
        if (node.l != '.') inOrder(node.l - 'A');

        // Root
        sb.append((char) (root + 'A'));

        // Right
        if (node.r != '.') inOrder(node.r - 'A');
    }

    static void postOrder(int root) { // L - R - M
        Node node = trees.get(root);

        // Left
        if (node.l != '.') postOrder(node.l - 'A');

        // Right
        if (node.r != '.') postOrder(node.r - 'A');

        // Root
        sb.append((char) (root + 'A'));
    }

    static class Node {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
