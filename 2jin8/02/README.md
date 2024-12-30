# [백준- G5] 2470. 두 용액
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
이분 탐색

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 하나의 용액을 정한 뒤, 그 용액과 혼합할 때 가장 0에 가까워지는 용액을 이분 탐색으로 찾기
- 혼합값이 0이면 바로 리턴
- 혼합값이 음수이면 더 큰 값을 더해야 함 ⇒ 우측으로
  - `left = mid + 1`
- 혼합값이 양수이면 더 작은 값을 더해야 함 ⇒ 좌측으로
  - `right = mid - 1`
```java
static int binarySearch(int start) {
  int left = start + 1, right = N - 1;
  int ans = -1, minDiff = 2_000_000_000;

  while (left <= right) {
    int mid = (left + right) / 2;
    int diff = arr[start] + arr[mid];

    // 합이 0이면 바로 종료
    if (diff == 0)
      return mid;

    // minDiff보다 작은 경우 갱신
    int absDiff = Math.abs(diff);
    if (absDiff < minDiff) {
      minDiff = absDiff;
      ans = mid;
    }

    // 혼합값이 음수면 더 큰 값을 더하도록 => 우측으로
    if (diff < 0) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return ans;
}
```

## :black_nib: **Review**
잔실수를 많이해서 시간이 오래 걸렸던..

## 📡**Link**
- https://www.acmicpc.net/problem/2470
