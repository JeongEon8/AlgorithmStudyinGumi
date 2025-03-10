# [백준 - S5] 2563. 색종이
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
- 100*100 2차원 배열을 모두 0으로 초기화한다.
- 좌표 2개를 받아서 10을 더한 죄표를 1로 바꾼다.
- 1의 개수를 출력한다.
```python
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            paper[x+i][y+j] = 1
re=0
for i in paper:
    re += sum(i)
```

## :black_nib: **Review**


## 📡 Link
https://www.acmicpc.net/problem/2563
