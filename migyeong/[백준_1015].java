import java.util.*;

public class Main {
    public static void b1015(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            arr[i][0] = A[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] P = new int[n];
        for (int i = 0; i < n; i++) {
            P[arr[i][1]] = i; 
        }

        for (int i = 0; i < n; i++) {
            System.out.print(P[i] + " ");
        }
    }
}
