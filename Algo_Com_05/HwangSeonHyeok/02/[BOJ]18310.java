import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] split = in.readLine().split(" ");

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(houses);
        if (n % 2 == 0) {
            System.out.println(houses[n / 2 - 1]);
        } else {
            System.out.println(houses[n / 2]);
        }
    }

}