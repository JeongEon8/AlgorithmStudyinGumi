# [PGS - Lv2] 03_H-Index

## ⏰**time**

14분

## :pushpin: **Algorithm**

* 정렬
* 구현

## ⏲️**Time Complexity**

$O(N \log N)$
`citations` 배열을 정렬하는 데 $O(N \log N)$이 걸리고, 이후 한 번 순회하므로 전체 시간 복잡도는 $O(N \log N)$이다.

## :round_pushpin: **Logic**

1. H-Index는 `h번 이상 인용된 논문이 h편 이상`이 되는 `h`의 최댓값이다.

2. 인용 횟수를 오름차순으로 정렬한다.

   ```java
   Arrays.sort(citations);
   ```

3. 정렬된 배열에서 인덱스 `i`를 기준으로 생각하면, `i`번째 논문부터 마지막 논문까지는 총 `n - i`편이다.

   따라서 현재 위치에서 가능한 H-Index 후보는 `n - i`가 된다.

   ```java
   int h = n - i;
   ```

4. 오름차순 정렬 상태에서 `citations[i] >= h`라면, `i`번째 논문부터 끝까지의 모든 논문은 최소 `h`번 이상 인용된 논문이다.

   즉, `h번 이상 인용된 논문이 h편 이상`이라는 조건을 만족한다.

   ```java
   for (int i = 0; i < n; i++) {
       int h = n - i;

       if (citations[i] >= h) {
           return h;
       }
   }
   ```

5. 앞에서부터 확인할수록 `h = n - i` 값이 크기 때문에, 처음 조건을 만족하는 `h`가 곧 최댓값이다.

6. 조건을 만족하는 값이 없다면 `0`을 반환한다.

   ```java
   return 0;
   ```

## :black_nib: **Review**

* 오름차순 정렬 후 `i`번째 위치에서 남은 논문 수를 `h`로 두면, `h번 이상 인용된 논문이 h편 이상`인지 간단하게 확인할 수 있었다.
* `citations[i] >= n - i`를 만족하는 첫 번째 지점이 가장 큰 H-Index가 된다는 점이 핵심이었다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/42747](https://school.programmers.co.kr/learn/courses/30/lessons/42747)
