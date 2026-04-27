import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] surveys = new int[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            surveys[i] = Integer.parseInt(line.replace(".", ""));
        }

        for (int i = 1; i <= 1000; i++) {
            boolean allPossible = true;

            for (int target : surveys) {
                boolean match = false;
                
                int low = 0;
                int high = i * 10;
                
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int val = (mid * 1000) / i;
                    
                    if (val == target) {
                        match = true;
                        break;
                    } else if (val < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                if (!match) {
                    allPossible = false;
                    break;
                }
            }

            if (allPossible) {
                System.out.println(i);
                return;
            }
        }
    }
}