# [백준- S2] 2805.나무 자르기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
이분 탐색

## ⏲️**Time Complexity**
$O(N log H)$

## :round_pushpin: **Logic**
1. 모든 나무들을 탐색하며 자른 길이가 0 보다 클 경우 sum에 더하기
2. sum이 잘라야 하는 M보다 작은 경우, right를 mid-1로 업데이트
3. M보다 크거나 같을 경우, left를 mid+1로 업데이트, answer이 mid보다 작으면 더 적게 자를 수 있는 경우이므로 answer 업데이트
```java
        while(left<=right) {
            int mid = (left+right)/2;

            long sum = 0;
            for(int ele: trees) {
                if(ele - mid > 0) sum += ele-mid;
            }

            if(sum < M) {
                right = mid -1;
            } else {
                if(answer < mid) answer = mid;
                left = mid + 1;
            }
        }
```

## :black_nib: **Review**
- sum을 그냥 냅다 +=ele-mid했더니 음수도 더해버리는 대참사 발생


## 📡**Link**
- https://www.acmicpc.net/problem/1504
