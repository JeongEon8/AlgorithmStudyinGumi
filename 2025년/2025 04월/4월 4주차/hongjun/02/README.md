# [백준 - S5] 2635. 수 이어가기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 브루트포스

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 다음 원소랑 다다음 원소의 차가 0 이상일 때만 판단하면 된다.
- 그 숫자들을 모아서 답으로 출력하면 된다.
```python
    while 1:
        next = li[idx - 1] - li[idx]
        if next < 0:
            break
        li.append(next)
        idx += 1
    if len(max) < len(li):
        max = li
```

## :black_nib: **Review**  

## 📡**Link**

https://www.acmicpc.net/problem/2635
