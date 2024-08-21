package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beakjoon1991 {

    static int[][] tree;

    // 전위 순회
    public static void preorder(int node) {
        if (node == -1) return;
        System.out.print((char)(node + 'A'));  // 루트
        preorder(tree[node][0]);  // 왼쪽 자식
        preorder(tree[node][1]);  // 오른쪽 자식
    }

    // 중위 순회
    public static void inorder(int node) {
        if (node == -1) return;
        inorder(tree[node][0]);  // 왼쪽 자식
        System.out.print((char)(node + 'A'));  // 루트
        inorder(tree[node][1]);  // 오른쪽 자식
    }

    // 후위 순회
    public static void postorder(int node) {
        if (node == -1) return;
        postorder(tree[node][0]);  // 왼쪽 자식
        postorder(tree[node][1]);  // 오른쪽 자식
        System.out.print((char)(node + 'A'));  // 루트
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new int[26][2];  // A~Z까지 사용 가능 (최대 26개의 노드)

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int parent = input[0].charAt(0) - 'A';
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            // 왼쪽 자식
            tree[parent][0] = (left == '.') ? -1 : left - 'A';
            // 오른쪽 자식
            tree[parent][1] = (right == '.') ? -1 : right - 'A';
        }

        preorder(0); // 전위 순회
        System.out.println();
        inorder(0); // 중위 순회
        System.out.println();
        postorder(0); // 후위 순회
        System.out.println();
    }
}
