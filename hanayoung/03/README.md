# [백준 - G5] 2467.용액

## ⏰  **time**
30분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 선택할 두 용액 변수 및 합계
```java
        int lowerBound = 0, upperBound = N-1;
        int result = arr[lowerBound] + arr[upperBound];
```
2. 왼쪽 오른쪽 용액의 합계의 절댓값이 result의 절댓값보다 작으면 result, lowerBound, upperBound 업데이트, 합계가 0보다 작으면 left를 오른쪽으로, 합계가 0보다 크면 right를 왼쪽으로 이동
```java
        int left = 0, right = N - 1;

        while(left < right) {
            int cal = arr[left] + arr[right];
            if(Math.abs(result) > Math.abs(cal)) {
                lowerBound = left;
                upperBound = right;
                result = cal;
            }
            if(cal < 0) left++;
            else if(cal > 0) right--;
            else break;
        }
```

## :black_nib: **Review**
이분탐색 어렵당... 정복하기 목표라서 풀었는데 투 포인터가 정석이라는,,,어쩐지 이분탐색으로 풀다가 산으로 가버리기

## 📡**Link**
- https://www.acmicpc.net/problem/2467
