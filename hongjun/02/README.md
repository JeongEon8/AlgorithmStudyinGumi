# [백준 - S5] 30873. Hanyang Popularity Exceeding Competition

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현, 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- P값과 C값이 한 줄로 입력되고 n번 입력한다
- 인기도가 0부터 시작해서 조건에 맞으면 +1을 해준다
```python
for i in range(n):
    a, b = map(int, input().split())
    P.append(a)
    C.append(b)

x = 0
for i in range(n):
    if abs(P[i] - x) <= C[i]:
        x += 1
```


## :black_nib: **Review**
- pypy로 바꾸고 sys 쓰니까 통과함

## 📡**Link**

https://www.acmicpc.net/problem/30873
