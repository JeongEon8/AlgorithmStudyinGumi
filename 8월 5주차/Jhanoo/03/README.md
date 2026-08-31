# [PGS - Lv2] 03_비밀 코드 해독

## ⏰**time**

25분

## :pushpin: **Algorithm**

- 완전탐색
- 조합
- DFS
- 백트래킹

## ⏲️**Time Complexity**

$O\left(\binom{N}{5} \times Q \times 25\right)$

`N`은 선택 가능한 숫자의 최댓값이고, `Q`는 질의의 개수이다.

비밀 코드는 `1 ~ N` 중 서로 다른 숫자 5개로 이루어지므로 가능한 후보 개수는

```text id="j9w51m"
N개 중 5개를 고르는 조합
= C(N, 5)
```

개이다.

각 후보마다 모든 질의를 확인하고, 하나의 질의에 대해 후보 숫자 5개와 질의 숫자 5개를 비교한다.

따라서 하나의 후보를 검증하는 데

```text id="84z5nc"
O(Q × 5 × 5)
```

가 걸린다.

전체 시간 복잡도는

```text id="yy3lmh"
O(C(N, 5) × Q × 25)
```

이다.

`25`는 상수이므로 간단히 표현하면

```text id="ew7b16"
O(C(N, 5) × Q)
```

로 볼 수도 있다.

## :round_pushpin: **Logic**

1. 비밀 코드는 `1 ~ n` 사이의 서로 다른 숫자 5개로 이루어진다.

   따라서 가능한 모든 비밀 코드 후보를 조합으로 생성한다.

   ```java
   dfs(new int[5], 1, 0);
   ```

2. DFS에서 `start`는 다음에 선택할 수 있는 최소 숫자이고, `depth`는 현재까지 선택한 숫자의 개수이다.

   ```java
   public void dfs(int[] selected, int start, int depth) {
       ...
   }
   ```

3. 현재 위치에 숫자를 하나 선택하고 다음 숫자는 반드시 더 큰 숫자부터 선택한다.

   ```java
   for (int num = start; num <= N; num++) {
       selected[depth] = num;
       dfs(selected, num + 1, depth + 1);
   }
   ```

   `num + 1`부터 탐색하기 때문에 같은 숫자를 중복 선택하지 않으며, 순서가 다른 동일한 조합도 생성하지 않는다.

   예를 들어

   ```text id="958wyw"
   [1, 2, 3, 4, 5]
   ```

   와

   ```
   [5, 4, 3, 2, 1]
   ```

   를 서로 다른 후보로 만들지 않는다.

4. 숫자 5개를 모두 선택하면 하나의 비밀 코드 후보가 완성된다.

   ```java
   if (depth == 5) {
       if (isValid(selected))
           answer++;
   
       return;
   }
   ```

5. 완성된 후보가 모든 질의 조건을 만족하는지 `isValid()`로 검사한다.

   ```java
   public boolean isValid(int[] selected) {
       ...
   }
   ```

6. 각 질의 `Q[i]`에 대해 후보 코드와 몇 개의 숫자가 일치하는지 계산한다.

   ```java
   int match = 0;
   
   for (int x : selected) {
       for (int y : Q[i]) {
           if (x == y) {
               match++;
               break;
           }
       }
   }
   ```

7. 계산한 일치 개수가 문제에서 주어진 `ANS[i]`와 다르면 현재 후보는 비밀 코드가 될 수 없다.

   ```java
   if (match != ANS[i]) {
       return false;
   }
   ```

   하나의 조건이라도 만족하지 못하면 이후 질의를 확인할 필요가 없으므로 즉시 `false`를 반환한다.

8. 모든 질의의 일치 개수 조건을 만족하면 유효한 비밀 코드 후보이다.

   ```java
   return true;
   ```

9. 유효한 후보가 발견될 때마다 정답 개수를 증가시킨다.

   ```java
   if (isValid(selected))
       answer++;
   ```

10. 가능한 모든 5개 조합을 확인한 뒤 유효한 비밀 코드의 개수를 반환한다.

   ```java
return answer;
   ```

## :black_nib: **Review**

- 처음에는 일치 개수가 가장 많은 질의를 기준으로 후보를 줄인 뒤 탐색하는 방법을 생각했다.
- 하지만 `1 ~ n`에서 5개를 선택하는 전체 후보 수가 충분히 작기 때문에 모든 조합을 생성해서 직접 검증하는 방식이 더 단순했다.
- 순열이 아니라 조합을 만들어야 하므로 다음 숫자를 `num + 1`부터 탐색해서 중복된 후보가 생성되지 않도록 했다.
- 후보 하나를 만든 뒤 모든 질의와 비교하여 일치 개수가 정확히 `ans[i]`와 같은지를 확인했다.
- 하나의 질의라도 조건을 만족하지 않으면 바로 `false`를 반환해서 불필요한 검사를 줄였다.
- 이 문제는 복잡하게 조건을 추론하기보다 전체 후보 공간이 작은지를 먼저 확인하고 완전탐색 가능 여부를 판단하는 것이 중요했다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/388352
