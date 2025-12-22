# [백준- S2] 16401. 과자 나눠주기
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 나눠줄 수 있는 과자의 최대 길이
  - M명보다 많이 나눠줄 수 있다면 기록 & 과자 길이 늘리기
    - `left = mid + 1`
  - 적게 나눠줄 수 있다면 과자 길이 줄이기
    - `right = mid - 1`
```java
static int separateSnack() {
    int ans = 0;
    int left = 1, right = 1_000_000_000;
    while (left <= right) {
        int mid = (left + right) / 2; // 과자의 길이
        if (isSeparate(mid)) { // M명보다 많이 나눠줄 수 있는 경우 => 기록 & 길이 늘리기
            ans = mid;
            left = mid + 1;
        } else { // M명보다 적게 나눠줄 수 있는 경우 => 길이 줄이기
            right = mid - 1;
        }
    }
    return ans;
}

// 막대 과자는 여러 조각으로 나눠질 수 있음 => 10 -> 5, 5 (O)
// 과자를 하나로 합칠 수는 없음 => 5 + 5 -> 10 (X)
static boolean isSeparate(int length) {
    int total = 0;
    for (int i = 0; i < N; i++) {
        total += snacks[i] / length;
        if (total >= M) return true;
    }
    return false;
}
```

## :black_nib: **Review**
문장 하나를 잘못 이해해서 삽질했다. 잠 올 때는 풀지말자,,

## 📡**Link**
- https://www.acmicpc.net/problem/16401
