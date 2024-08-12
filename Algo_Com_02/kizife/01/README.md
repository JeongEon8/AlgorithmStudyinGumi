# [백준] 10871. X보다 작은 수
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
596ms

## :round_pushpin: **Logic**
1. N, X를 차례대로 입력받는다.
2. 배열을 선언하고, 이어지는 숫자들을 배열에 입력한다.
3. 배열의 인덱스 0부터 순서대로, X보다 작은 수만을 출력한다.

```java
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int X = sc.nextInt();

      int[] arr = new int[N]; //배열 선언

      for(int i=0; i<N; i++) { //배열 입력
        arr[i] = sc.nextInt();
      }
      
        for(int i=0; i<N; i++) {
          if(arr[i]<X) {
            System.out.print(arr[i] + " ");
          }
        }
      }
  }


```

## :black_nib: **Review**
- 어려운 것은 없었다. 

## 📡**Link**
- https://www.acmicpc.net/problem/10871
