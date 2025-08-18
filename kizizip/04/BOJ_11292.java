import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            double maxh = -1;
            ArrayList<String> names = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next();
                double h = sc.nextDouble();

                if (h > maxh) {
                    maxh = h;
                    names.clear();
                    names.add(name);
                } else if (h == maxh) {
                    names.add(name);
                }
            }

            for (String s : names) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
