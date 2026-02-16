# [백준 - S4] 1059. 좋은 구간

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

정수 집합 S가 주어졌을 때, `n`을 포함하는 **좋은 구간 [A, B]**의 개수를 구하는 문제.
좋은 구간이란

- `A < B`, `A ≤ x ≤ B` 를 만족하는 모든 정수 x가 S에 속하지 않아야 함

1. 집합 S를 정렬한다.
2. `n`이 속하는 구간을 찾는다. `[left, right]`
   - 만약 `n`이 첫번째 원소보다 작으면, `left = 1` `right = n`
3. 이중 for문으로 모든 경우의 수 계산

   ```
   A = left+1 ~ right-2
   B = A+1 ~ right-1
   ```

```java
Arrays.sort(nums);

int left = 0, right = 0;
for (int i = 0; i < S - 1; i++) {
    if (n < nums[0]) {
        left = 0;
        right = nums[0];
        break;
    }

    if (nums[i] <= n && nums[i + 1] >= n) {
        left = nums[i];
        right = nums[i + 1];
        break;
    }
}

int ans = 0;
for (int i = left + 1; i < right - 1; i++) {
    for (int j = i + 1; j < right; j++) {
        if (i <= n && n <= j) {
            ans++;
        }
    }
}
```

## :black_nib: Review

수학 공식으로도 풀 수 있을거 같다.

## 📡**Link**

<https://www.acmicpc.net/problem/1059>
