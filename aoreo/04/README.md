# [백준 - S5] 9037.The candy war

## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 시뮬레이션

## ⏲️**Time Complexity**
$O(n^2)$

## :round_pushpin: **Logic**
1. 아이들이 갖고 있는 사탕 개수를 담는 candies 배열 생성
2. 반띵하는 임시 배열 halfCandies 배열 생성
3. candies 각 값이 홀수일 경우 1 더하고, 나눈 값을 halfCandies에 할당
4. 이전 인덱스의 candies의 값과 현재 인덱스의 candies의 값이 동일하지 않다면 allSame 값 false 할당
5. allSame이 true라면 바로 break, 아니라면 사탕 옆 친구한테 나눠주기 로직 수행
```java
               for (int i = 0; i < N; i++) {
                   if(i == 0) candies[i] = halfCandies[0]+halfCandies[N-1];
                   else candies[i] = halfCandies[i-1] + halfCandies[i];
               }
```
6. 한 턴 돌았으므로 answer 1씩 증가


## :black_nib: **Review**
- 복잡한가했지만 시키는대로만 하면 되는 문제
  
## 📡 Link
https://www.acmicpc.net/problem/9037
