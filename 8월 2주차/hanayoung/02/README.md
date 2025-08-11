# [백준 - G4] 2110.공유기 설치

## ⏰  **time**
60분

## :pushpin: **Algorithm**
이분탐색

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 이분탐색 활용 위해서 배열 정렬
```java
Arrays.sort(homes);
```
2. count는 설치한 공유기 개수, last는 마지막 설치한 집 의미, mid(거리)보다 먼 경우, count 1 증가시키고 last 값 업데이트
3. count가 C보다 크거나 같은 경우는, 가능한 경우이나 더 멀어질 수도 있으므로 left 값 업데이트, 아닌 경우는 불가능하므로 right 값 업데이트
```java
        while(left <= right) {
            int mid = (left+right)/2;
            
            int count = 1, last = homes[0];

            for(int i = 0; i < N; i++) {
                if(homes[i] - last >= mid) {
                    count++;
                    last = homes[i];
                }
            }

            if(count >= C) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
```

## :black_nib: **Review**
이분탐색 어렵당... 정복하기 목표!

## 📡**Link**
- https://www.acmicpc.net/problem/2110
