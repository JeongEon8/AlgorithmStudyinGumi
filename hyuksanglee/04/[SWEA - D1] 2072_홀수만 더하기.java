import java.util.Scanner;
 
//2072. 홀수만 더하기
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();    // 반복 횟수
        for(int i=0; i<T; i++) {
            int sum = 0;
            for(int j=0; j<10; j++) {    // 10개의 수 입력 
                int num = sc.nextInt();
                if(num%2 != 0)
                    sum = sum + num;
            }
            System.out.println("#"+(i+1)+" "+sum);
            sum = 0;
        }
    }
}
