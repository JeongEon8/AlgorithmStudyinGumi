# [PGS - Lv2] 03_타겟 넘버

## ⏰**time**

20분

## :pushpin: **Algorithm**

* 완전 탐색
* 비트마스킹
* 부분집합
* DFS/BFS 대체 가능

## ⏲️**Time Complexity**

$O(N \times 2^N)$
숫자 `N`개에 대해 각각 `+` 또는 `-`를 선택할 수 있으므로 전체 경우의 수는 $2^N$개이다.
각 경우마다 `N`개의 숫자를 순회하며 합을 계산하므로 전체 시간 복잡도는 $O(N \times 2^N)$이다.

## :round_pushpin: **Logic**

1. 각 숫자는 `+` 또는 `-` 두 가지 방식으로 사용할 수 있다.

   따라서 `numbers`의 길이를 `n`이라고 하면, 가능한 부호 조합의 개수는 `2^n`개이다.

2. 모든 부호 조합을 비트마스크로 표현한다.

   ```java
   for (int i = 0; i < (1 << n); i++) {
       int sum = 0;
   }
   ```

3. `i`의 각 비트는 `numbers[j]`에 붙일 부호를 의미한다.

   * `j`번째 비트가 `1`이면 `+numbers[j]`
   * `j`번째 비트가 `0`이면 `-numbers[j]`

   ```java
   for (int j = 0; j < n; j++) {
       sum += (i & (1 << j)) > 0 ? numbers[j] : -numbers[j];
   }
   ```

4. 하나의 부호 조합에 대한 합 `sum`이 `target`과 같다면, 가능한 방법의 수를 1 증가시킨다.

   ```java
   if (sum == target)
       answer++;
   ```

5. 모든 경우의 수를 확인한 뒤 `answer`를 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

* 보통 DFS로 많이 푸는 문제지만, 각 숫자의 부호 선택을 비트로 표현하면 비트마스킹으로도 깔끔하게 풀 수 있었다.
* 숫자마다 `+` 또는 `-` 두 가지 선택지가 있으므로 전체 경우의 수가 $2^N$이라는 점을 먼저 파악하는 것이 핵심이었다.
* `1 << n`으로 전체 조합 수를 만들고, 각 비트를 확인해 부호를 결정하는 방식이 직관적이었다.
* 문제 제한에서 `numbers`의 길이가 크지 않기 때문에 완전 탐색으로 충분히 해결 가능했다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/43165](https://school.programmers.co.kr/learn/courses/30/lessons/43165)
