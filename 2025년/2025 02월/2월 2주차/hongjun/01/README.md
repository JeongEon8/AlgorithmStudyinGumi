# [백준 - S4] 1835. 카드

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현, 덱

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 문제에 나온 과정을 반대로 적용한다.
```python
for i in range(n, 0, -1):
    q.appendleft(i)
    for j in range(cnt):
        tmp = q.pop()
        q.appendleft(tmp)
    cnt -= 1
```
- 덱을 사용해서 앞에 숫자를 넣고 n번 반복해서 뒤에있는 숫자를 앞으로 보낸다.

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1835
