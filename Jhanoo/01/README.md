# [PGS - Lv2] 01_멀리 뛰기

## ⏰**time**

17분

## :pushpin: **Algorithm**

* Dynamic Programming
* 피보나치 수열

## ⏲️**Time Complexity**

$O(N)$
`1`부터 `n`까지의 경우의 수를 한 번씩 계산하므로 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. 한 번에 `1칸` 또는 `2칸`을 뛸 수 있으므로, `n`칸에 도달하는 방법은 다음 두 경우로 나눌 수 있다.

   * `n - 1`칸까지 온 뒤 `1칸` 뛰는 경우
   * `n - 2`칸까지 온 뒤 `2칸` 뛰는 경우

2. 따라서 `n`칸까지 가는 경우의 수는 다음 점화식으로 표현된다.

   ```java
   fibo[i] = fibo[i - 1] + fibo[i - 2];
   ```

3. 문제에서 경우의 수를 `1234567`로 나눈 나머지를 반환하라고 했으므로, 매 계산마다 MOD 연산을 적용한다.

   ```java
   static final int MOD = 1234567;

   for (int i = 3; i <= n; i++) {
       fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
   }
   ```

4. 초기값은 다음과 같이 설정한다.

   * `fibo[1] = 1`

     * `1`
   * `fibo[2] = 2`

     * `1 + 1`
     * `2`

   ```java
   fibo[1] = 1;
   fibo[2] = 2;
   ```

5. 최종적으로 `fibo[n]`을 반환한다.

## :black_nib: **Review**

* 처음에는 조합 관점에서 접근했지만, 경우의 수를 나열해보니 결국 `이전 칸에서 1칸 이동`하거나 `전전 칸에서 2칸 이동`하는 구조였다.
* 이를 점화식으로 정리하니 피보나치 수열 형태가 되었고, DP로 간단하게 해결할 수 있었다.
* 경우의 수가 커질 수 있으므로 매번 MOD 연산을 적용하는 것이 중요했다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/12914](https://school.programmers.co.kr/learn/courses/30/lessons/12914)
