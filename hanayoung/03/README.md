# [백준 - G5] 2470.두 용액

## ⏰  **time**
30분

## :pushpin: **Algorithm**
이진탐색

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 두 용액을 더하며 0과 가까운 합 찾기
2. 합계의 절댓값이 answer보다 더 작다면 answer을 업데이트하고, lowerBound도 left로, upperBound로 right로 업데이트
3. 합계가 0보다 작다면 left를 오른쪽으로, 합계가 0보다 크다면 right를 왼쪽으로, 0이라면 종료
```java
        int left = 0, right = N - 1;
        int lowerBound = 0, upperBound = N-1;
        int answer = arr[lowerBound] + arr[upperBound];

        while (left < right) {
            int cal = arr[left] + arr[right];

            if (Math.abs(cal) < Math.abs(answer)) {
                answer = cal;
                lowerBound = left;
                upperBound = right;
            }

            if (cal < 0) {
                left++;
            } else if (cal == 0) {
                break;
            } else {
                right--;
            }
        }
```

## :black_nib: **Review**
- 전에 푼 문제랑 비슷했는데 아직 이진 탐색이 완전 착 붙진 않아서 몇 번 틀려버리기..


## 📡**Link**
- https://www.acmicpc.net/problem/2470
