# [PGS - Lv2] 03_연속 부분 수열 합의 개수

## ⏰**time**

미기재

## :pushpin: **Algorithm**

* 완전 탐색
* HashSet
* 원형 배열

## ⏲️**Time Complexity**

$O(N^3)$
시작 위치 `N`개, 부분 수열 길이 `N`개, 각 구간 합 계산에 최대 `N`번 순회하므로 시간 복잡도는 $O(N^3)$이다.

## :round_pushpin: **Logic**

1. 서로 다른 연속 부분 수열의 합 개수를 구해야 하므로, 중복을 자동으로 제거할 수 있는 `HashSet`을 사용한다.

   ```java
   HashSet<Integer> s = new HashSet<>();
   ```

2. 수열은 원형으로 이어져 있으므로, 인덱스가 배열의 끝을 넘어가면 다시 처음으로 돌아오도록 `% n` 연산을 사용한다.

   ```java
   elements[(i + j) % n]
   ```

3. 모든 시작 위치 `i`를 기준으로, 길이 `1`부터 `n`까지의 연속 부분 수열 합을 계산한다.

   ```java
   int n = elements.length;
   for (int i = 0; i < n; i++) {
       for (int len = 1; len <= n; len++) {
           int sum = 0;
           for (int j = 0; j < len; j++) {
               sum += elements[(i + j) % n];
           }

           s.add(sum);
       }
   }
   ```

4. 같은 합이 여러 번 나와도 `HashSet`에는 한 번만 저장되므로, 모든 경우를 탐색한 뒤 `s.size()`가 서로 다른 부분 수열 합의 개수가 된다.

   ```java
   return s.size();
   ```

## :black_nib: **Review**

* 원형 수열이기 때문에 인덱스를 직접 늘리기보다는 `% n`을 사용해 간단하게 순환 구조를 처리했다.
* 가능한 모든 시작 위치와 길이를 확인하고, 합의 중복 제거는 `HashSet`에 맡겨서 구현 자체는 직관적이었다.
* 현재 코드는 구간 합을 매번 새로 계산하므로 $O(N^3)$이지만, 누적합이나 길이를 늘려가며 이전 합에 다음 원소를 더하는 방식으로 개선하면 $O(N^2)$까지 줄일 수 있다.

## 📡 Link

[https://school.programmers.co.kr/learn/courses/30/lessons/131701](https://school.programmers.co.kr/learn/courses/30/lessons/131701)
