# [PGS - Lv2] 02_N개의 최소공배수

## ⏰**time**

13분

## :pushpin: **Algorithm**

* 수학
* 소인수분해
* 최소공배수

## ⏲️**Time Complexity**

$O(N \times M)$
`N`은 배열 `arr`의 길이, `M`은 각 숫자를 소인수분해하기 위해 확인하는 수의 범위이다.
문제 제한에서 `arr`의 원소는 `100` 이하이므로 사실상 상수 범위 내에서 처리된다.

## :round_pushpin: **Logic**

1. 최소공배수는 각 숫자를 소인수분해했을 때, 등장하는 소수별 최대 지수의 곱으로 구할 수 있다.

   예를 들어 `2`, `6`, `8`, `14`가 있을 때,

   * `2 = 2^1`
   * `6 = 2^1 * 3^1`
   * `8 = 2^3`
   * `14 = 2^1 * 7^1`

   따라서 필요한 최대 지수는 `2^3`, `3^1`, `7^1`이므로 최소공배수는 `24 * 7 = 168`이 된다.

2. 각 소수의 최대 지수를 저장하기 위해 `cnt` 배열을 사용한다.

   ```java
   int[] cnt = new int[101];
   ```

3. 배열의 각 숫자 `num`에 대해 `2`부터 나누어보며 소인수분해를 진행한다.

   ```java
   for (int num : arr) {
       for (int i = 2; num > 1; i++) {
           if (num % i != 0) continue;

           int mulCnt = 0;
           while (num % i == 0) {
               num /= i;
               mulCnt++;
           }
           cnt[i] = Math.max(cnt[i], mulCnt);
       }
   }
   ```

4. 특정 소인수 `i`가 현재 숫자에서 몇 번 나누어지는지 `mulCnt`로 계산한다.

   이후 기존에 저장된 지수와 비교하여 더 큰 값을 저장한다.

   ```java
   cnt[i] = Math.max(cnt[i], mulCnt);
   ```

5. 모든 숫자의 소인수분해가 끝나면, 저장된 소인수별 최대 지수만큼 곱해서 최소공배수를 만든다.

   ```java
   int answer = 1;
   for (int i = 2; i < 101; i++) {
       if (cnt[i] == 0) continue;
       answer *= Math.pow(i, cnt[i]);
   }
   ```

6. 최종적으로 계산된 `answer`를 반환한다.

## :black_nib: **Review**

* 처음에는 두 수씩 `gcd`를 구해서 `lcm`을 누적하는 방식도 가능하다고 생각했다.
* 이번 풀이는 각 숫자를 소인수분해한 뒤, 소수별 최대 지수를 관리하는 방식으로 최소공배수의 정의에 가깝게 접근했다.
* 배열 원소의 범위가 작기 때문에 `cnt` 배열을 사용해 간단하게 구현할 수 있었다.
* 다만 일반적인 최소공배수 문제에서는 `gcd`를 이용한 누적 방식이 더 간결하고 범위 확장에도 유리할 수 있다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/12953](https://school.programmers.co.kr/learn/courses/30/lessons/12953)
