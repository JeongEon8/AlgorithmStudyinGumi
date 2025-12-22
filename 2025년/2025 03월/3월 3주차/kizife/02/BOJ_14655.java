import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = Math.abs(arr1[i]) + Math.abs(arr2[i]);
            sum += a;
        }

        System.out.println(sum);

    }
}
