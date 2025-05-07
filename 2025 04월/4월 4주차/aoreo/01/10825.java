import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Score> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pQueue.add(new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));    
        }

        while(pQueue.size() > 0) {
            Score score = pQueue.poll();
            System.out.println(score.name);
        }
    }

    static class Score implements Comparable<Score>{
        int korean;
        int english;
        int math;
        String name; 

        Score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Main.Score o) {
            if(this.korean > o.korean) return -1;
            else if(this.korean == o.korean && this.english < o.english) return -1;
            else if(this.korean == o.korean && this.english == o.english && this.math > o.math) return -1;
            else if(this.korean == o.korean && this.english == o.english && this.math == o.math && this.name.compareTo(o.name) < 0) return -1;
            else return 1;
        }

    }
}
