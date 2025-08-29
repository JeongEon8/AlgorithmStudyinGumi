
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Set<String> visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            visited = new HashSet<>();
            int n = Integer.parseInt(br.readLine());

            List<Node> stores = new ArrayList<>();
            String[] split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            Node start = new Node(x, y);

            for (int i = 0; i < n; i++) {
                split = br.readLine().split(" ");
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);

                stores.add(new Node(x, y));
            }

            split = br.readLine().split(" ");
            x = Integer.parseInt(split[0]);
            y = Integer.parseInt(split[1]);
            Node dest = new Node(x, y);
            move(start, dest, stores);
        }

    }

    static void move(Node start, Node dest, List<Node> stores) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start.x + "," + start.y);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int dis = Math.abs(curr.x - dest.x) + Math.abs(curr.y - dest.y);

            if (dis <= 1000) {
                System.out.println("happy");
                return;
            }

            for (Node store : stores) {
                dis = Math.abs(curr.x - store.x) + Math.abs(curr.y - store.y);
                if (!visited.contains(store.x + "," + store.y) && dis <= 1000) {
                    visited.add(store.x + "," + store.y);
                    queue.offer(store);
                }
            }

        }

        System.out.println("sad");
    }

}