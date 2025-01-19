# [백준 - 실버 5] 9655.돌 게임
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 1개나 3개씩 가져갈 수 있으므로, 우선적으로 3개씩 가져가도록 함.
2. 남은 돌 개수가 3보다 작을 경우는 무조건 1개씩만 가져갈 수 있으므로, if문으로 확인하여 N 감소
   ```java
            if(N < 3) {
                N -= 1;
            }else {
                N -= 3;
            }
```
3. turn이 짝수일 경우 상근이가 이긴 것이고, 홀수면 창영이가 이긴 것으로 answer 반환

## :black_nib: **Review**
- 일단 3으로 먼저 빼봤는데 되네..? 야호

## 📡 Link
https://www.acmicpc.net/problem/9655
