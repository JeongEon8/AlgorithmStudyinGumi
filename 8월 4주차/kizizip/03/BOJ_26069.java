import java.util.HashSet;
import java.util.Scanner;

public class BOJ_26069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashSet<String> list = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            String a = line[0];
            String b = line[1];

            if (a.equals("ChongChong") || b.equals("ChongChong")) {
                list.add(a);
                list.add(b);
            }

            if (list.contains(a) || list.contains(b)) {
                list.add(a);
                list.add(b);
            }

        }

        System.out.println(list.size());
    }
}
