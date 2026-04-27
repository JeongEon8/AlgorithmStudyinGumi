import java.awt.Point;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.y < p2.y) return -1;
                else if(p1.y == p2.y) {
                    return p1.x - p2.x;
                } else return 1;
            }
        });


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(pq.size() > 0) {
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.println(sb);
        
    }
}
