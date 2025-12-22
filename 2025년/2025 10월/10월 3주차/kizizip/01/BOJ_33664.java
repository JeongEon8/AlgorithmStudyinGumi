import java.util.HashMap;
import java.util.Scanner;

public class BOJ_33664 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long b = sc.nextLong();
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Long> items = new HashMap<>();
        for (int i = 0; i < n; i++) {
            items.put(sc.next(), sc.nextLong());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += items.get(sc.next());
            if (sum > b) {
                System.out.println("unacceptable");
                return;
            }
        }

        System.out.println("acceptable");
    }
}
