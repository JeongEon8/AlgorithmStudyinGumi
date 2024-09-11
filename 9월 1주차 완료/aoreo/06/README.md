# [백준 - 골드 5] 17070.파이프 옮기기 1

## ⏰  **time**
2시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 가능한 개수 구하는 문제이므로 dfs 이용
2. 지금 상태가 가로인지 세로인지 대각선인지에 따라 이동방향이 달라지므로, 위치값과 현재 상태를 dfs의 파라미터로 전달한다
3. 대각선으로 이동할 경우, [nx][ny]지점 외에도, [nx-1][ny], [nx][ny-1] 지점도 빈칸인지 확인한다
4. 이동할 수 있다면, 방문처리한 후(true) dfs 함수 호출한다.
5. dfs 함수 호출 후, 다시 방문처리를 한다(false)
6. 도착지에 도달한 경우, answer 값을 1 증가한다.


## :black_nib: **Review**
처음에 문제 이해를 잘못해서 냅다 오른쪽으로 가고, 내려가고, 대각선으로 이동하는 줄 알았는데 아니었다.. 조건 잘 보자....

## 📡 Link
[https://www.acmicpc.net/problem/17070](https://www.acmicpc.net/problem/17070)
