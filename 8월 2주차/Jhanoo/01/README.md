# [PGS - Lv2] 01_줄 서는 방법

## ⏰**time**

54분

## :pushpin: **Algorithm**

- Factorial
- 순열
- Greedy
- ArrayList

## ⏲️**Time Complexity**

$O(N^2)$

팩토리얼 배열을 만드는 데 $O(N)$이 걸린다.

이후 각 자리마다 현재 남아 있는 숫자 중 `index`번째 값을 선택하기 위해 `ArrayList.remove(index)`를 수행한다.

```java
answer[idx] = numbers.remove(index);
```

`ArrayList`의 중간 원소를 삭제하면 뒤의 원소들을 한 칸씩 이동해야 하므로 한 번의 삭제가 최악의 경우 $O(N)$이다.

이를 최대 $N$번 수행하므로 전체 시간 복잡도는 $O(N^2)$이다.

## :round_pushpin: **Logic**

1. `n`명이 줄을 서는 전체 경우의 수는 `n!`개이다.

   따라서 각 순열을 팩토리얼 단위의 구간으로 나눠 생각할 수 있다.

   예를 들어 `n = 5`라면 첫 번째 숫자 하나를 고정했을 때 뒤쪽 숫자의 경우의 수는 `4!`개이다.

   ```text
   첫 번째가 1인 경우 → 4!개
   첫 번째가 2인 경우 → 4!개
   첫 번째가 3인 경우 → 4!개
   ...
   ```

2. 각 자리에서 사용할 팩토리얼 값을 빠르게 구하기 위해 미리 팩토리얼 배열을 만든다.

   ```java
   long[] facto = new long[n + 1];
   facto[0] = 1;
   facto[1] = 1;
   
   for (int num = 2; num <= n; num++) {
       facto[num] = facto[num - 1] * num;
   }
   ```

3. 아직 사용하지 않은 숫자를 관리하기 위해 `1`부터 `n`까지 `ArrayList`에 저장한다.

   ```java
   List<Integer> numbers = new ArrayList<>();
   
   for (int i = 1; i <= n; i++) {
       numbers.add(i);
   }
   ```

4. 문제의 `k`는 1번째 순열부터 시작하는 1-based 값이다.

   팩토리얼을 이용해 인덱스를 계산하려면 0-based로 바꿔야 하므로 `1`을 뺀다.

   ```java
   k--;
   ```

5. 첫 번째 자리부터 차례대로 어떤 숫자가 들어갈지 결정한다.

   현재 자리 뒤에 남는 숫자가 `n - 1 - idx`개라면, 현재 숫자 하나를 고정했을 때 만들 수 있는 순열의 개수는 다음과 같다.

   ```java
   long factorial = facto[n - 1 - idx];
   ```

6. `k / factorial`을 계산하면 현재 남은 숫자 중 몇 번째 숫자를 선택해야 하는지 알 수 있다.

   ```java
   int index = (int) (k / factorial);
   ```

   예를 들어 현재 남은 숫자가 다음과 같고,

   ```text
   [2, 3, 4, 5]
   ```

   `index = 2`라면 세 번째 숫자인 `4`를 선택한다.

7. 현재 숫자를 선택한 뒤에는 해당 구간 안에서 몇 번째 순열인지 다시 계산해야 한다.

   따라서 `k`를 현재 팩토리얼로 나눈 나머지로 갱신한다.

   ```java
   k %= factorial;
   ```

8. 선택한 숫자는 다시 사용할 수 없으므로 `numbers`에서 제거하면서 정답 배열에 저장한다.

   ```java
   answer[idx] = numbers.remove(index);
   ```

9. 이 과정을 모든 자리에 대해 반복한다.

   ```java
   for (int idx = 0; idx < n; idx++) {
       long factorial = facto[n - 1 - idx];
   
       int index = (int) (k / factorial);
       k %= factorial;
   
       answer[idx] = numbers.remove(index);
   }
   ```

10. 완성된 순열을 반환한다.

```java
return answer;
```

## :black_nib: **Review**

- 처음에는 `k`를 팩토리얼의 합 형태로 분해해서 각 계수를 구하는 방식으로 접근했다.
- 각 계수는 현재 남아 있는 숫자 중 몇 번째 숫자를 선택할지를 의미한다는 점이 핵심이었다.
- `k`가 1-based이므로 먼저 `k--`를 해서 0-based로 바꾸면 각 자리의 선택 인덱스를 `k / factorial`로 바로 구할 수 있었다.
- 숫자 하나를 선택하면 이후에는 그 숫자를 사용할 수 없기 때문에 남은 숫자 목록에서 제거하면서 진행했다.
- 팩토리얼을 이용하면 모든 순열을 직접 생성하지 않고도 원하는 `k`번째 순열만 바로 찾을 수 있었다.
- `ArrayList.remove(index)`가 중간 삭제 시 $O(N)$이므로 전체 시간 복잡도는 $O(N^2)$이다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12936
