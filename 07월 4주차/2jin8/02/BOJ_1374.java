import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374 {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq = new PriorityQueue<>((l1, l2) -> {
            if (l1.start == l2.start) {
                return Integer.compare(l1.end, l2.end);
            }
            return Integer.compare(l1.start, l2.start);
        });

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Lecture(number, start, end));
        }

        PriorityQueue<Integer> useLecture = new PriorityQueue<>();
        useLecture.offer(pq.poll().end); // N: 1 ~ 100,000
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            int lastTime = useLecture.peek(); // 가장 빨리 끝나는 강의 시간

            // 강의 시작 시간이 lastTime과 같거나 늦으면 같은 강의실 사용 가능
            if (lecture.start >= lastTime) {
                useLecture.poll();
                useLecture.offer(lecture.end);
            } else {
                useLecture.offer(lecture.end);
            }
        }
        System.out.println(useLecture.size());
    }

    static class Lecture {
        int number, start, end;

        public Lecture(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }
}
