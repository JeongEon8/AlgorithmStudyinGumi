import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = 1;
        
        for(int i=1; i<=x; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}
