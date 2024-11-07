package dlatl;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int five = 0;
        int three = 0;
        int result = Integer.MAX_VALUE; 

        five = n / 5;
        while (five >= 0) {
            int num = n - (five * 5);

            if (num % 3 == 0) { 
                three = num / 3;
                result = five + three; 
                break;
            }

            five--; // 5kg 봉지 개수를 하나 줄여서 다시 시도...
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
}
