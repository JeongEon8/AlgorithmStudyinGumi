import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = list.size() - 1;
        int answer = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (start != end) {
            int sum = list.get(start) + list.get(end);
            if (answer > Math.abs(sum)) {
                answer = Math.abs(sum);
                a = list.get(start);
                b = list.get(end);
            }
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else if (sum == 0) {
                break;
            }
        }
        sb.append(a + " " + b);
        System.out.println(sb);

    }
}
