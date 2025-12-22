import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회원 수
        
        PriorityQueue<Member> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pQueue.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        while(pQueue.size() != 0){
            Member m = pQueue.poll();
            System.out.println(m.age + " " +m.name);
        }
    }

    static class Member implements Comparable<Member>{
        int idx;
        int age;
        String name;

        public Member(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Main.Member o) {
            if(this.age < o.age) return -1;
            else if(this.age == o.age) {
                if(this.idx < o.idx) return -1;
                else return 1;
            }
            else return 1;
        }
    }
}
