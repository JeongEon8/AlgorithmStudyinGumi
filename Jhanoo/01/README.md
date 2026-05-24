# [PGS - Lv2] 01_n^2 배열 자르기

## ⏰**time**

26분

## :pushpin: **Algorithm**

* 수학
* 구현
* 인덱스 변환

## ⏲️**Time Complexity**

$O(R - L + 1)$
`left`부터 `right`까지 필요한 구간만 직접 계산하므로 시간 복잡도는 $O(R - L + 1)$이다.

## :round_pushpin: **Logic**

1. 문제의 `n x n` 배열을 실제로 만들면 최대 크기가 매우 커질 수 있으므로, 전체 배열을 생성하지 않고 필요한 구간만 계산한다.

2. `n x n` 배열을 1차원 배열로 펼쳤을 때, 1차원 인덱스 `i`는 다음과 같이 2차원 좌표로 변환할 수 있다.

   * 행: `i / n`
   * 열: `i % n`

   ```java
   long r = i / n;
   long c = i % n;
   ```

3. 문제에서 생성되는 2차원 배열의 각 위치 `(r, c)` 값은 `r`과 `c` 중 더 큰 값에 `1`을 더한 값이다.

   예를 들어 `n = 3`일 때 배열은 다음과 같다.

   ```text
   1 2 3
   2 2 3
   3 3 3
   ```

   즉, `(r, c)`의 값은 다음과 같이 구할 수 있다.

   ```java
   answer[idx++] = (int) Math.max(c, r) + 1;
   ```

4. `left`부터 `right`까지 순회하며 각 인덱스에 해당하는 값을 계산하고, 정답 배열에 순서대로 저장한다.

   ```java
   int size = (int) (right - left) + 1;
   int[] answer = new int[size];
   int idx = 0;

   for (long i = left; i <= right; i++) {
       long r = i / n;
       long c = i % n;

       answer[idx++] = (int) Math.max(c, r) + 1;
   }
   ```

5. 최종적으로 `answer`를 반환한다.

## :black_nib: **Review**

* 처음에는 `n x n` 배열을 직접 만들어야 하는 문제처럼 보였지만, 제한을 보면 전체 배열을 생성하면 메모리 측면에서 불가능하다는 점을 알 수 있었다.
* 1차원 인덱스를 행과 열로 변환한 뒤, 해당 위치의 값이 `max(행, 열) + 1`이라는 규칙을 찾는 것이 핵심이었다.
* 필요한 구간만 계산하므로 메모리 사용량을 정답 배열 크기만큼으로 줄일 수 있었다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/87390](https://school.programmers.co.kr/learn/courses/30/lessons/87390)
