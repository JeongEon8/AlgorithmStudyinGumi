import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> times = new ArrayList<>();

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times.add(Integer.parseInt(line[i]));
        }
        Collections.sort(times);

        int result = 0;
        for (int i = n; i >= 1; i--) {
            result += times.get(n-i) * i;
        }

        System.out.println(result);

    }
}
