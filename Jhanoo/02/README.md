# [PGS - Lv2] 02_[PCCP 기출문제] 2번 퍼즐 게임 챌린지

## ⏰**time**

25분

## :pushpin: **Algorithm**

- Binary Search
- 이분 탐색
- 구현

## ⏲️**Time Complexity**

$O(N \log M)$

`N`은 퍼즐의 개수이고, `M`은 `diffs`의 최댓값이다.

하나의 `level`에 대해 모든 퍼즐의 소요 시간을 계산하려면 `diffs`와 `times`를 한 번 순회해야 하므로 $O(N)$이 걸린다.

가능한 숙련도 범위 `[1, max(diffs)]`에서 이분 탐색을 수행하므로 숙련도 후보를 확인하는 횟수는 $O(\log M)$이다.

따라서 전체 시간 복잡도는

```text
O(N log M)
```

이다.

## :round_pushpin: **Logic**

1. 숙련도 `level`이 높아질수록 퍼즐을 틀리는 횟수가 감소하므로 전체 소요 시간도 감소한다.

   즉 다음과 같은 단조성이 존재한다.

   ```text
   level 증가
       ↓
   실패 횟수 감소
       ↓
   총 소요 시간 감소
   ```

   따라서 `limit` 이내로 모든 퍼즐을 해결할 수 있는 **최소 숙련도**를 이분 탐색으로 찾을 수 있다.

2. 숙련도의 최소값은 `1`, 최대값은 가장 높은 퍼즐 난이도로 설정한다.

   ```java
   int left = 1;
   int right = Arrays.stream(diffs).max().getAsInt();
   int answer = right;
   ```

   가장 높은 난이도 이상의 숙련도라면 모든 퍼즐을 한 번에 풀 수 있으므로 그보다 큰 숙련도를 탐색할 필요가 없다.

3. 현재 탐색 범위의 중간 숙련도 `mid`를 구한다.

   ```java
   int mid = (left + right) / 2;
   ```

4. `getTime()`을 이용해 숙련도가 `mid`일 때 모든 퍼즐을 해결하는 데 필요한 총 시간을 계산한다.

   ```java
   long time = getTime(diffs, times, mid);
   ```

5. 현재 숙련도가 퍼즐의 난이도 이상이라면 실패하지 않고 한 번에 해결한다.

   ```java
   if (diffs[i] <= level) {
       total += times[i];
   }
   ```

6. 현재 숙련도가 퍼즐 난이도보다 낮다면 실패 횟수는 다음과 같다.

   ```java
   int fail = diffs[i] - level;
   ```

   한 번 실패할 때마다 현재 퍼즐과 이전 퍼즐을 다시 풀어야 하므로 실패 1회당 소요 시간은

   ```text
   times[i - 1] + times[i]
   ```

   이다.

   여기에 마지막으로 현재 퍼즐을 성공하는 시간이 추가된다.

   ```java
   total += (long) (times[i - 1] + times[i]) * fail + times[i];
   ```

7. `mid` 숙련도로 계산한 시간이 `limit` 이하라면 현재 숙련도로 해결이 가능하다.

   ```java
   if (time <= limit) {
       answer = mid;
       right = mid - 1;
   }
   ```

   하지만 문제에서 요구하는 것은 가능한 숙련도 중 **최솟값**이므로 더 낮은 숙련도에서도 가능한지 왼쪽 범위를 계속 탐색한다.

8. 반대로 총 시간이 `limit`을 초과한다면 현재 숙련도가 부족한 것이므로 숙련도를 높여야 한다.

   ```java
   else {
       left = mid + 1;
   }
   ```

9. 이분 탐색이 종료될 때까지 가능한 가장 작은 숙련도를 `answer`에 갱신하고 최종적으로 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

- 처음에는 숙련도를 `1`부터 하나씩 증가시키면서 모든 퍼즐의 시간을 계산하는 방식으로 구현했다.
- 하지만 숙련도 후보마다 전체 퍼즐을 다시 순회하기 때문에 일부 테스트 케이스에서 시간 초과가 발생했다.
- 숙련도가 높아질수록 실패 횟수와 전체 소요 시간이 줄어드는 단조성이 있다는 것을 이용해 이분 탐색으로 변경했다.
- `time <= limit`인 숙련도를 찾는 것만으로 끝나는 것이 아니라, 그중 최소 숙련도를 구해야 하므로 가능한 경우에도 `right = mid - 1`로 더 작은 값을 탐색해야 했다.
- 각 숙련도에서 총 시간을 계산하는 데 $O(N)$, 숙련도 탐색에 $O(\log M)$이 걸리므로 전체 시간 복잡도를 $O(N \log M)$으로 줄일 수 있었다.
- 총 소요 시간은 값이 커질 수 있으므로 `long`으로 계산해야 했다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/340212
