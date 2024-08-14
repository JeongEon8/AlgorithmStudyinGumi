import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution {
 
    static class Node {
        int left = 0, right = 0, parent = 0;
 
        Node() {
        }
 
        void addChild(int n) {
            if (left == 0) {
                this.left = n;
            } else {
                this.right = n;
            }
        }
 
        void setParent(int parent) {
            this.parent = parent;
        }
 
        boolean isRoot() {
            return this.parent == 0;
        }
 
    }
 
    static Node[] tree;
    static boolean[] visited;
 
    static int ancestor, size;
 
    static void findAncestor(int n1, int n2) {
        Node current = tree[n1];
        visited[n1] = true;
        while (!current.isRoot()) {
            visited[current.parent] = true;
            current = tree[current.parent];
        }
 
        if (visited[n2]) {
            ancestor = n2;
            return;
        } else {
            current = tree[n2];
            while (!current.isRoot()) {
                if (visited[current.parent]) {
                    ancestor = current.parent;
                    return;
                }
                current = tree[current.parent];
            }
        }
 
        return;
    }
 
    static void calSize(Node current) {
        size++;
        if (current.left != 0) {
            calSize(tree[current.left]);
        }
        if (current.right != 0) {
            calSize(tree[current.right]);
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            String[] split = in.readLine().split(" ");
 
            int V = Integer.parseInt(split[0]);
            int E = Integer.parseInt(split[1]);
            int n1 = Integer.parseInt(split[2]);
            int n2 = Integer.parseInt(split[3]);
 
            tree = new Node[V + 1];
            for (int i = 0; i <= V; i++) {
                tree[i] = new Node();
            }
            visited = new boolean[V + 1];
            size = 0;
 
            split = in.readLine().split(" ");
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(split[i * 2]);
                int child = Integer.parseInt(split[i * 2 + 1]);
                tree[parent].addChild(child);
                tree[child].setParent(parent);
            }
 
            findAncestor(n1, n2);
            calSize(tree[ancestor]);
 
            sb.append("#" + tc + " " + ancestor + " " + size + "\n");
        }
        System.out.println(sb);
    }
 
}