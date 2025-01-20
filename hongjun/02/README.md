# [백준 - S5] 1996. 지뢰 찾기기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 숫자로 입력된 곳의 좌표들에서 8방향에 해당하는 곳에 숫자를 더해준다.
- 10이 넘는 곳은 M으로 바꾸고 지뢰가 있는 곳 좌표를 *로 바꾼다.
``` pyhon
for y, x in node:
    for i in range(8):
        ny = y + dy[i]
        nx = x + dx[i]
        if 0 <= ny < N and 0 <= nx < N:

            if res[ny][nx] != "*" and isinstance(res[ny][nx], int):
                res[ny][nx] += int(win[y][x])
                if res[ny][nx] >= 10:
                    res[ny][nx] = 'M'
```
- 문자열과 숫자가 혼합되어 있기 때문에 이 부분을 유의해야한다.

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/1996
