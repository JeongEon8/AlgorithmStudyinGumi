# [백준 - 골드 3] 1600. 말이 되고픈 원숭이

## ⏰  **time**

1시간

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
1. bfs로 가능한 길 탐색
2. 원래 원숭이가 움직일 수 있는 길인 4방향을 탐색
3. 능력을 다 사용하지 않았다면 8방향으로도 탐색 추가
4. 마지막 지점에 도착할 경우, 능력을 쓴 횟수를 인덱스로 갖는 값 반환

## :black_nib: **Review**
최적화하고 싶었는데 그게 틀리는 길이었다..
 
## 📡 **URL**
[https://www.acmicpc.net/problem/1922](https://www.acmicpc.net/problem/1600)
