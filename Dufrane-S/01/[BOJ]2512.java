import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] yesans = new int[N];
        for (int i = 0; i < N; i++) {
            yesans[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());


        int start=0;
        int end = total;

        int answer=0;
        boolean test=false;
        int sum=0;
        for (int yesan : yesans) {
            sum += yesan;
            answer = Math.max(answer, yesan);
        }
        if(sum>total)test=true;

        if (test) {
            while(start<end) {
                int now = (start + end) / 2;
                sum=0;
                for (int yesan : yesans) {
                    sum += Math.min(now, yesan);
                }
                if(sum<total){
                    start=now+1;
                    answer=now;
                } else if (sum==total) {
                    answer=now;
                    break;
                } else {
                    end=now;
                }
            }
        }


        System.out.println(answer);
    }
}
