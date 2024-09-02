import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int min = Integer.MAX_VALUE;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (min > current) {
                min = current;
            }
            if (diff < current - min) {
                diff = current - min;
            }
            sb.append(diff + " ");
        }
        System.out.print(sb.toString());

    }

}