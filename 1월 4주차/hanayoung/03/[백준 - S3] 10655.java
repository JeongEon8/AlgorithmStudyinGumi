import java.awt.Point;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        Point[] points = new Point[N];
        int[][] visited = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        visited[1][0] = Math.abs(points[1].y - points[0].y) + Math.abs(points[1].x - points[0].x);
        visited[2][0] = Math.abs(points[2].y - points[1].y) + Math.abs(points[2].x - points[1].x) + visited[1][0];
        visited[2][1] = Math.abs(points[2].y - points[0].y) + Math.abs(points[2].x - points[0].x);

        for(int i = 3; i < N; i++) {
            int dist = Math.abs(points[i].y - points[i-1].y) + Math.abs(points[i].x - points[i-1].x);
            visited[i][1] = Math.min(visited[i-1][1] + dist, 
        visited[i-2][0]+ Math.abs(points[i].y - points[i-2].y) + Math.abs(points[i].x - points[i-2].x));
            visited[i][0] = visited[i-1][0] + dist;
        }

        System.out.println(Math.min(visited[N-1][1], visited[N-1][0]));
    }
}
