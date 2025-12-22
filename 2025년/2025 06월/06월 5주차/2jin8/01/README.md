# [백준- G4] 2110. 공유기 설치
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
- 가장 인접한 두 공유기 사이의 최대 거리를 이분 탐색으로 구하기
- 설치 가능한 공유기의 수가 C보다 작으면 설치 간격 좁히기
  - `right = mid - 1`
- 그렇지 않으면 거리 기록 & 설치 간격 넓히기
  - `left = mid + 1`
```java
static int getMaxDistanceBetweenHouse() {
    int left = 1, right = houses[N - 1] - houses[0]; // 공유기 사이 거리는 최소 1

    int maxDistance = 0;
    while (left <= right) {
        int mid = (left + right) / 2;
        // 설치하는 공유기 수 구하기
        // 설치 가능한 공유기 수가 C보다 적은 경우, 설치 간격 좁히기
        if (getInstallCount(mid) < C) {
            right = mid - 1;
        } else { // 설치 간격 넓히기
            maxDistance = mid;
            left = mid + 1;
        }
    }
    return maxDistance;
}

static int getInstallCount(int distance) {
    // 우선 첫 번째 집에 무조건 설치
    int prevHouse = houses[0], count = 1;
    for (int i = 1; i < N; i++) {
        // 집 사이의 거리가 distance 이상이여야 공유기 설치 가능
        if (houses[i] - prevHouse >= distance) {
            count++;
            prevHouse = houses[i];
        }
    }
    return count;
}
```

## :black_nib: **Review**
이분탐색 까먹어서 다시 풀어봤다. 전에 풀었던건데도 헷갈림.. 진짜 다 까먹었다..

## 📡**Link**
- https://www.acmicpc.net/problem/2110
