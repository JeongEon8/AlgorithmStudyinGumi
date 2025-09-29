# [백준 - G4] 1806. 부분합

## ⏰  **time**
50분

## :pushpin: **Algorithm**
누적합, 이분 탐색

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 누적합 배열 생성
```java
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            if (i > 0) {
                arr[i] += arr[i - 1];
            }
        }
```
2. 매 idx를 시작점으로 탐색
3. 해당 지점부터 S가 큰 idx를 찾기
4. arr[mid]가 target보다 크거나 같으면 answer 값 업데이트하고 right를 mid-1로 업데이트
5. arr[mid]가 더 작으면 left를 mid+1로 업데이트해서 이분탐색 
```java
        for (int i = 0; i < N; i++) {
            int base = (i == 0 ? 0 : arr[i-1]);
            int target = base + S;
            int left = i;
            int right = N-1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= target) {
                    answer = Math.min(mid - i+1, answer);
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }   
    
```



## :black_nib: **Review**
- 누적합이라며.....왜 이분탐색까지

## 📡**Link**
- https://www.acmicpc.net/problem/1806
