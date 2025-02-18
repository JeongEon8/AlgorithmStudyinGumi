import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int addCount = 0; //추가해야 할 물병의 개수

        while (Integer.bitCount(n) > k) {
            //Integer.bitCount(n)란?? 2진수에서 1의 개수를 반환함
            n++;
            addCount++;
        }

        System.out.println(addCount);
    }
}
