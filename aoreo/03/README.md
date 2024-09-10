# [백준 - 골드 5] 15686.치킨 배달
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
조합, bfs

## ⏲️**Time Complexity**
$O(2^N*(N^2))$

## :round_pushpin: **Logic**
1. 남겨둘 치킨집의 수와 현재 치킨집의 수를 비교한다.
2. 현재 치킨집의 수가 더 클 경우, 폐업할 치킨집을 고르기 위해 조합을 이용한다
3. 치킨 거리를 구하기 위해, 집 개수만큼 반복하며, 집 지점을 큐에 넣고, 사방향으로 이동하며 가까운 치킨 집을 찾는다.
4. 폐업할 치킨집을 고르기 위해, 치킨 거리를 answer로 관리한다.


## :black_nib: **Review**
- 조합과 bfs를 같이 써야한다는 생각을 처음에 잘 못해서 어떻게 가야하지??? 라는 고민이 컸다.. 그래서 오래 걸렸던 문제😔😔

## 📡 Link
[https://www.acmicpc.net/problem/15686](https://www.acmicpc.net/problem/15686)
