import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String nowWord = st.nextToken();
            int nowValue = Integer.parseInt(st.nextToken());
            words.add(nowWord);
            values.add(nowValue);
        }
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N;
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int now = 0;
            int answer = 0;
            while (start < end) {
                now = (start + end) / 2;
                if (value <= values.get(now)) {
                    end = now;
                    answer = now;
                } else {
                    start = now+1;
                }
            }
            sb.append(words.get(answer));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
