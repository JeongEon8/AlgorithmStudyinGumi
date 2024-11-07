# [백준 - S4] 2960. 에라토스테네스의 체

## ⏰ **time**

20분

## :pushpin: **Algorithm**
소수 판정, 에라토스테네스의 체


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 문제 조건에 따라 순서대로 조건을 달아준다.
``` python
# 2부터 N까지
for i in range(2, N + 1):
    # 배수를 모두 지운다
    for j in range(i, N + 1, i):
        # visit가 True이면 False로 바꿔줌
        if visit[j] != False:
            visit[j] = False
            # 지운 횟수 카운트
            cnt += 1
            # k번째이면 출력
            if cnt == K:
                print(j)
                break
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2960