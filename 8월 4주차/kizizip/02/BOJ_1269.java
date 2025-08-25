import java.util.HashSet;
import java.util.Scanner;

public class BOJ_1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        HashSet<Integer> nums = new HashSet<>();

        for (int i = 0; i < a + b; i++) {
            nums.add(sc.nextInt());
        }

        System.out.println(2*nums.size() - a - b);
    }
}
