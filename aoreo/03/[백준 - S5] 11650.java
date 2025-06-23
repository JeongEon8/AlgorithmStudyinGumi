import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Coord> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pQueue.add(new Coord(x, y));
        }

        while(pQueue.size() != 0) {
            Coord coord = pQueue.poll();

            System.out.println(coord.x+" "+coord.y);
        }
    }

    static class Coord implements Comparable<Coord>{
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coord o) {
            if(this.x < o.x) return -1;
            else if(this.x == o.x && this.y < o.y) return -1;
            else return 1;
        }
    }
}
