# [백준] 2741. N 찍기
 
## ⏰  **time**
5분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
로직이라고 할 것도 없이 너무 당연한 코드인데 처음에는 왜 틀린 코드를 썼는지 모르겠다...

## :black_nib: **Review**
- 참고로 처음 썼던 코드는 아래와 같다. 
아래와 같이 쓰면 숫자가 아니라 합을 출력하게 되는 거겠지...
새벽 두 시에 풀어서 제정신이 아니었나 보다...

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = 0;
        
        for(int i=1; i<=x; i++) {
            result += i;
        }
        System.out.println(result);
        
    }
}
