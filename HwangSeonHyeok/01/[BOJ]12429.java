import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static Food[] foods;
    static class Food implements Comparable<Food>{
        int p, s;

        public Food(int p, int s) {

            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(Food o) {
            return this.p-o.p;
        }
    }

    static class Time implements Comparable<Time>{
        int aliveTime;
        boolean[] eaten;

        public Time(int aliveTime, boolean[] eaten) {
            this.aliveTime = aliveTime;
            this.eaten = eaten;
        }

        @Override
        public int compareTo(Time o) {
            return this.aliveTime-o.aliveTime;
        }
    }

    static int solve(){
        PriorityQueue<Time> pq = new PriorityQueue();
        pq.add(new Time(0, new boolean[n]));
        int idx = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            Time current = pq.poll();
            if(current.aliveTime>ans){
                ans = current.aliveTime;
            }
            while(idx<n&&foods[idx].p<current.aliveTime){
                idx++;
            }
            for(int i = idx; i<n;i++){
                if(!current.eaten[i]){
                    boolean[] newEaten = new boolean[n];
                    for(int j = 0; j<n;j++){
                        newEaten[j] = current.eaten[j];
                    }
                    newEaten[i] = true;
                    pq.add(new Time(current.aliveTime+foods[i].s,newEaten));
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(in.readLine());
        for(int tc = 1; tc<=t;tc++){
            n = Integer.parseInt(in.readLine());
            foods = new Food[n];
            for(int i = 0; i<n;i++){
                String[] split = in.readLine().split(" ");
                int p = Integer.parseInt(split[0]);
                int s = Integer.parseInt(split[1]);
                foods[i] = new Food(p,s);
            }
            Arrays.sort(foods);
            int ans = solve();
            sb.append("Case #").append(tc).append(": ").append(ans).append('\n');
        }
        System.out.println(sb);

    }
}