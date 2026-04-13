import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Book> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            map.put(str, map.getOrDefault(str,0)+1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Book(entry.getKey(), entry.getValue()));
        }
        
        System.out.println(pq.poll().name);
        
    }

    static class Book implements Comparable<Book>{
        String name;
        int cnt;

        public Book(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Book o) {
            if(this.cnt < o.cnt) return 1;
            else if(this.cnt == o.cnt) {
                return this.name.compareTo(o.name);
            }
            else return -1;
        }
        
    }
}
