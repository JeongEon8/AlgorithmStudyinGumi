import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[][][] arr = new int[201][201][201];
        boolean[][][] visited = new boolean[201][201][201];

        visited[0][0][C] = true;

        Queue<Bucket> queue = new LinkedList<>();
        queue.add(new Bucket(0, 0, C));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        while(queue.size() != 0){
            Bucket bucket = queue.poll();
            // 가능한 가짓수, 
            // a에 있는 걸 b로
            if(bucket.a == 0) pQueue.add(bucket.c);
            if(bucket.a + bucket.b > B) {
                if(visited[bucket.b+bucket.a-B][B][bucket.c] == false) {
                    queue.add(new Bucket(bucket.b+bucket.a-B, B, bucket.c));
                    visited[bucket.b+bucket.a-B][B][bucket.c] = true;
                }
            }else {
                if(visited[0][bucket.a+bucket.b][bucket.c] == false) {
                    queue.add(new Bucket(0, bucket.a+bucket.b, bucket.c));
                    visited[0][bucket.a+bucket.b][bucket.c] = true;
                }
            }
            // a에 있는 걸 c로
            if(bucket.a + bucket.c > C) {
                if(visited[bucket.c+bucket.a-C][bucket.b][C] == false) {
                    queue.add(new Bucket(bucket.c+bucket.a-C, bucket.b, C));
                    visited[bucket.c+bucket.a-C][bucket.b][C] = true;
                }
            }else {
                if(visited[0][bucket.b][bucket.c+bucket.a] == false) {
                    queue.add(new Bucket(0, bucket.b, bucket.c+bucket.a));
                    visited[0][bucket.b][bucket.c+bucket.a] = true;
                }
            }
            // b에 있는 걸 a로
            if(bucket.a + bucket.b > A) {
                if(visited[A][bucket.b+bucket.a-A][bucket.c] == false) {
                    queue.add(new Bucket(A, bucket.b+bucket.a-A, bucket.c));
                    visited[A][bucket.b+bucket.a-A][bucket.c] = true;
                }
            }else {
                if(visited[bucket.a+bucket.b][0][bucket.c] == false) {
                    queue.add(new Bucket(bucket.a+bucket.b, 0, bucket.c));
                    visited[bucket.a+bucket.b][0][bucket.c] = true;
                }
            }
            // b에 있는 걸 c로
            if(bucket.c + bucket.b > C) {
                if(visited[bucket.a][bucket.b+bucket.c-C][C] == false) {
                    queue.add(new Bucket(bucket.a, bucket.b+bucket.c-C, C));
                    visited[bucket.a][bucket.b+bucket.c-C][C] = true;
                }
            }else {
                if(visited[bucket.a][0][bucket.c+bucket.b] == false) {
                    queue.add(new Bucket(bucket.a, 0, bucket.c+bucket.b));
                    visited[bucket.a][0][bucket.c+bucket.b] = true;
                }
            }
            // c에 있는 걸 a로
            if(bucket.a + bucket.c > A) {
                if(visited[A][bucket.b][bucket.c+bucket.a-A] == false) {
                    queue.add(new Bucket(A, bucket.b, bucket.c+bucket.a-A));
                    visited[A][bucket.b][bucket.c+bucket.a-A] = true;
                }
            }else {
                if(visited[bucket.c+bucket.a][bucket.b][0] == false) {
                    queue.add(new Bucket(bucket.c+bucket.a, bucket.b, 0));
                    visited[bucket.c+bucket.a][bucket.b][0] = true;
                }
            }
            // c에 있는 걸 b로
            if(bucket.c + bucket.b > B) {
                if(visited[bucket.a][B][bucket.b+bucket.c-B] == false) {
                    queue.add(new Bucket(bucket.a, B, bucket.b+bucket.c-B));
                    visited[bucket.a][B][bucket.b+bucket.c-B] = true;
                }
            }else {
                if(visited[bucket.a][bucket.c+bucket.b][0] == false) {
                    queue.add(new Bucket(bucket.a, bucket.c+bucket.b, 0));
                    visited[bucket.a][bucket.c+bucket.b][0] = true;
                }
            }
        }
        int size = pQueue.size();
        String answer = "";
        for (int i = 0; i < size; i++) {
            answer += pQueue.poll() + " ";
        }
        System.out.println(answer);
    }

    static class Bucket{
        int a;
        int b;
        int c;

        public Bucket(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
