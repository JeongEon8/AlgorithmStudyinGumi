# [PGS - Lv2] 02_연속된 부분 수열의 합

## ⏰**time**

22분

## :pushpin: **Algorithm**

* Two Pointer
* Sliding Window
* 누적합

## ⏲️**Time Complexity**

$O(N)$
`N`은 `sequence` 배열의 길이이다.

`left`와 `right` 포인터는 각각 배열의 처음부터 끝까지 최대 한 번씩만 이동한다.
따라서 전체 시간 복잡도는 $O(N)$이다.

## :round_pushpin: **Logic**

1. `sequence`의 모든 원소가 양수이므로, 현재 구간의 합과 `k`의 크기를 비교해 포인터 이동 방향을 결정할 수 있다.

   * 구간 합이 `k`보다 작으면 오른쪽 범위를 늘린다.
   * 구간 합이 `k`보다 크면 왼쪽 범위를 줄인다.
   * 구간 합이 `k`와 같으면 정답 후보로 확인한다.

2. `left`와 `right`를 모두 `0`으로 시작하고, 첫 번째 원소를 현재 구간 합으로 설정한다.

   ```java
   int left = 0;
   int right = 0;
   int sum = sequence[0];
   ```

3. 초기 정답은 수열 전체 구간으로 설정한다.

   ```java
   int n = sequence.length - 1;
   int[] answer = {0, n};
   ```

4. 현재 구간 합이 `k`보다 작다면 더 큰 합이 필요하므로 `right`를 한 칸 이동하고 새 원소를 더한다.

   ```java
   if (sum < k) {
       if (right == n) break;

       sum += sequence[++right];
   }
   ```

5. 현재 구간 합이 `k`보다 크다면 합을 줄여야 하므로 `left`가 가리키는 값을 빼고 `left`를 한 칸 이동한다.

   ```java
   else if (sum > k) {
       sum -= sequence[left++];
   }
   ```

6. 현재 구간 합이 `k`와 같다면 현재 구간 길이와 기존 정답 구간 길이를 비교한다.

   더 짧은 구간이면 정답을 갱신한다.

   ```java
   else {
       int len = answer[1] - answer[0] + 1;
       int curLen = right - left + 1;

       if (curLen < len) {
           answer[0] = left;
           answer[1] = right;
       }
   }
   ```

7. 합이 `k`와 같더라도 다음 후보를 찾기 위해 구간을 이동해야 한다.

   현재 코드에서는 오른쪽에 원소가 남아 있으면 `right`를 늘리고, 오른쪽 끝에 도달했다면 `left`를 줄인다.

   ```java
   if (right == n) {
       sum -= sequence[left++];
   } else {
       sum += sequence[++right];
   }
   ```

8. 같은 길이의 후보가 여러 개라면 시작 인덱스가 작은 구간을 반환해야 한다.

   현재 코드는 왼쪽에서 오른쪽 방향으로 탐색하고, 더 짧은 경우에만 정답을 갱신한다.

   따라서 같은 길이의 구간이 나중에 발견되더라도 기존의 더 작은 시작 인덱스가 유지된다.

9. 모든 가능한 구간을 확인한 뒤 정답 구간을 반환한다.

   ```java
   return answer;
   ```

## :black_nib: **Review**

* 수열의 모든 원소가 양수이므로 구간 합이 작으면 오른쪽을 늘리고, 크면 왼쪽을 줄이는 투 포인터 풀이가 가능했다.
* 각 포인터가 배열을 최대 한 번씩만 이동하므로 $O(N)$에 해결할 수 있었다.
* 합이 `k`인 구간을 찾았을 때 가장 짧은 구간만 갱신하고, 같은 길이에서는 기존 정답을 유지하면 시작 인덱스가 작은 구간을 선택할 수 있었다.
* `right`가 배열 끝에 도달한 상태에서도 합이 `k`인 다음 후보를 찾기 위해 `left`를 이동해야 한다는 점이 중요했다.
* 투 포인터는 원소가 모두 양수일 때 구간 합의 증가와 감소 방향이 보장되기 때문에 사용할 수 있다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/178870
