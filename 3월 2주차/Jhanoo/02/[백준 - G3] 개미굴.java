import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        TreeMap<String, Node> child = new TreeMap<>();
    }

    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Node cur = root;
            for (int j = 0; j < K; j++) {
                String food = st.nextToken();

                cur.child.putIfAbsent(food, new Node());
                cur = cur.child.get(food);
            }
        }

        dfs(root, 0);
        System.out.print(sb);
    }

    static void dfs(Node node, int depth) {
        for (Map.Entry<String, Node> entry : node.child.entrySet()) {
            sb.append("--".repeat(depth)).append(entry.getKey()).append("\n");
            dfs(entry.getValue(), depth + 1);
        }
    }
}