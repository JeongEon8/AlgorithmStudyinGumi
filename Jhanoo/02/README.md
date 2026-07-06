# [PGS - Lv2] 02_소수 찾기

## ⏰**time**

32분

## :pushpin: **Algorithm**

* DFS
* 완전 탐색
* 비트마스킹
* 순열
* HashSet
* 소수 판별

## ⏲️**Time Complexity**

$O(N! + K \sqrt{M})$
`N`은 문자열 `numbers`의 길이, `K`는 중복을 제거한 뒤 생성된 숫자의 개수, `M`은 생성된 숫자 중 최댓값이다.

숫자를 만들기 위해 길이 1부터 `N`까지 가능한 순열을 모두 탐색하므로 경우의 수는 다음과 같다.

```text
N + N(N - 1) + N(N - 1)(N - 2) + ... + N!
```

이를 전체적으로 $O(N!)$로 볼 수 있다.

생성된 각 숫자에 대해 최대 제곱근까지 나누어 소수 여부를 확인하므로, 소수 판별에는 $O(K \sqrt{M})$이 걸린다.

## :round_pushpin: **Logic**

1. 종이에 적힌 숫자들을 조합해 만들 수 있는 모든 숫자를 생성해야 한다.

   같은 숫자가 여러 경로에서 만들어질 수 있으므로, 중복을 자동으로 제거할 수 있는 `HashSet`을 사용한다.

   ```java
   static Set<Integer> set = new HashSet<>();
   ```

2. DFS를 이용해 현재까지 만든 숫자 `current`와 사용한 문자 위치를 나타내는 비트마스크 `visited`를 관리한다.

   ```java
   makeNumber(numbers, 0, 0);
   ```

3. 각 문자 위치를 순회하면서 이미 사용한 위치인지 확인한다.

   `visited`의 `i`번째 비트가 `1`이면 이미 사용한 숫자이므로 건너뛴다.

   ```java
   if ((visited & (1 << i)) != 0)
       continue;
   ```

4. 아직 사용하지 않은 숫자를 현재 숫자의 뒤에 붙인다.

   문자열을 이어 붙인 뒤 다시 정수로 변환하는 대신, 다음 식으로 새로운 숫자를 직접 만든다.

   ```java
   int next = current * 10 + (numbers.charAt(i) - '0');
   ```

   예를 들어 현재 숫자가 `17`이고 다음 문자가 `'3'`이라면 다음 숫자는 다음과 같다.

   ```text
   17 * 10 + 3 = 173
   ```

5. 새로 만든 숫자를 `set`에 저장한다.

   앞에 `0`이 붙어 같은 숫자가 만들어지는 경우도 `HashSet`이 중복을 제거한다.

   ```java
   set.add(next);
   ```

6. 현재 사용한 위치의 비트를 켜고 다음 DFS를 호출한다.

   ```java
   makeNumber(numbers, next, visited | (1 << i));
   ```

7. 재귀가 끝나면 `set`에는 만들 수 있는 모든 서로 다른 숫자가 저장된다.

   각 숫자를 순회하면서 소수인지 판별한다.

   ```java
   for (int number : set) {
       if (isPrime(number)) {
           answer++;
       }
   }
   ```

8. `0`, `1`, 음수는 소수가 아니므로 바로 `false`를 반환한다.

   ```java
   if (number < 2) {
       return false;
   }
   ```

9. `2`부터 `number`의 제곱근까지 나누어보면서 약수가 존재하는지 확인한다.

   약수가 하나라도 존재하면 소수가 아니다.

   ```java
   for (int i = 2; i * i <= number; i++) {
       if (number % i == 0) {
           return false;
       }
   }
   ```

10. 끝까지 약수가 발견되지 않았다면 소수이므로 `true`를 반환한다.

```java
return true;
```

## :black_nib: **Review**

* 숫자 카드를 사용해 만들 수 있는 모든 경우를 확인해야 하므로 DFS와 비트마스킹을 활용했다.
* 같은 숫자가 여러 순열에서 만들어질 수 있기 때문에 `HashSet`으로 중복을 제거하는 것이 중요했다.
* 처음에는 문자열을 이어 붙이고 `Integer.parseInt()`로 변환했지만, `current * 10 + digit` 방식으로 숫자를 직접 만들면 문자열 생성과 파싱을 줄일 수 있었다.
* 사용한 문자 위치를 비트마스크로 관리하면 별도의 `boolean[]` 없이 순열을 만들 수 있었다.
* 소수 판별은 제곱근까지만 확인하면 충분하므로 `i * i <= number` 조건을 사용했다.


## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42839
