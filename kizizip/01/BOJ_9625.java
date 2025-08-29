import java.util.Scanner;

public class BOJ_9625 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int[] arr = new int[47];
        arr[0] = 1;
        arr[1] = 0;
        for (int i = 2; i < 47; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[k] + " " + arr[k+1]);
    }
}
