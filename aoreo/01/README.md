# [백준 - G5] 13023.ABCDE
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(n^3)$

## :round_pushpin: **Logic**
1. ArrayList 배열을 이용해 친구관계(양방향으로) 저장
2. answer가 1이 될 때까지만 depth 1의 dfs 함수 호출
3. 각 요소의 친구관계를 탐색하며 방문하지 않은 경우에만 재귀함수 호출
4. 모든 친구관계를 확인 후에는 방문 해제 처리

## :black_nib: **Review**
- 간만에 dfs 문제 푸니까 낯설다잉 .. 널포인터에러 오랜만이라 꽤나 멈칫

## 📡 Link
https://www.acmicpc.net/problem/13023
