
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // tc 수

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine()); // 의상 수

            HashMap<String, Integer> clothes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] split = br.readLine().split(" ");

                clothes.put(split[1], clothes.getOrDefault(split[1], 0) + 1);

            }

            int ans = 1;
            for (int cnt : clothes.values()) {
                ans *= (cnt + 1);
            }
            System.out.println(ans - 1);
        }

    }

}
