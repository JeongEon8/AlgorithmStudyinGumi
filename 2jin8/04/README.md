# [백준- S1] 2343. 기타 레슨
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 블루레이 크기를 결정하기 위해 이분탐색 사용
- 블루레이 크기 결정 > 사용해야 하는 블루레이 개수에 따라 탐색 범위 좁히기
  - 사용해야 하는 블루레이 개수가 더 많은 경우
    - 블루레이 크기를 늘리기: `left = mid + 1`
  - 블루레이 개수가 적거나 같은 경우
    - 블루레이 크기의 최소를 구해야 하므로 현재 크기 기록
    - 블루레이 크기 줄이기: `right = mid - 1`
```java
private static void getBluRayMinimumSize(int maxLength) {
    // 최대 강의 수: 100,000, 최대 강의 길이: 10,000 => 1,000,000,000
    int ans = -1;
    int left = maxLength, right = 1_000_000_000;
    while (left <= right) {
        int mid = (left + right) / 2; // 블루레이 크기
        // 사용해야 하는 블루레이 개수가 더 많은 경우
        if (bluRayCount(mid) > M) { // 블루레이 크기 늘리기
            left = mid + 1;
        } else { // 블루레이 개수보다 작거나 같은 경우, 블루레이 크기 줄이기
            ans = mid; // 블루레이 크기 최소 구해야 함
            right = mid - 1;
        }
    }
    System.out.println(ans);
}
```

## :black_nib: **Review**
이거 풀기 전에 조금 풀었더니 약간 감 잡은 듯? 그치만 더 많이 풀어봐야지,,

## 📡**Link**
- https://www.acmicpc.net/problem/2343
