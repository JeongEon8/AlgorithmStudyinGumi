import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

static class Edge implements Comparable<Edge> {

    int index;
    double distance;

    public Edge() {

    }

    public Edge(int index, double distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance > o.distance) return 1;
        else return -1;
    }

}

public static void main(String args[]) throws Exception {

    System.setIn(new FileInputStream("input_1251.txt"));
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(bf.readLine());

    int T = Integer.parseInt(st.nextToken()); // 테케 개수

    for (int test_case = 1; test_case <= T; test_case++) {
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); // 섬 개수

        Point[] islands = new Point[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) { // 각 섬의 x좌표
            islands[i] = new Point(Integer.parseInt(st.nextToken()), 0);
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) { // 각 섬의 y좌표
            islands[i].y = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        double E = Double.parseDouble(st.nextToken()); // 세율

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(0, 0));

        double total = 0.0;

        while (queue.size() != 0) {
            Edge curEdge = queue.poll();
            int index = curEdge.index;
            if(visited[index] == true) continue;
            visited[index] = true;
            total += E * Math.pow(curEdge.distance, 2);
            int size = queue.size();
            for (int i = 0; i < N; i++) {
                if (visited[i] == false) {
                    Edge nextEdge = new Edge();
                    nextEdge.index = i;
                    nextEdge.distance = Math.sqrt(Math.pow(islands[i].x - islands[index].x, 2) + Math.pow(islands[i].y - islands[index].y, 2));
                    queue.add(nextEdge);
                }
            }
            if (queue.size() == size) {
                queue.clear();
            }
        }

        System.out.println("#" + test_case+" "+Math.round(total));

    }
}
}
