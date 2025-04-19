import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt(); 
            int m = sc.nextInt(); 

            for (int i = 0; i < m; i++) {
                sc.nextInt(); // a
                sc.nextInt(); // b
            }

            sb.append((n - 1)).append("\n");
        }

        System.out.print(sb);
    }
}
