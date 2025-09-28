import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10728 {
    static int T, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            n = Integer.parseInt(br.readLine());

            int maxLen = 0;
            List<Integer> result = new ArrayList<>();

            int totalSubsets = 1 << n;

            for (int i = 1; i < totalSubsets; i++) {
                List<Integer> subset = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(j + 1);
                    }
                }

                if (check(subset)) {
                    if (subset.size() > maxLen) {
                        maxLen = subset.size();
                        result = new ArrayList<>(subset);
                    }
                }
            }

            System.out.println(result.size());
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean check(List<Integer> subset) {
        int size = subset.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if ((subset.get(i) ^ subset.get(j) ^ subset.get(k)) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
