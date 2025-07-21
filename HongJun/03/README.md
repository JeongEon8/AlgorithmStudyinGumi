# [백준 - S5] 1676. 팩토리얼 0의 개수

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
N 팩토리얼 숫자를 구하고 이걸 string으로 변환한다.
그리고 반복문으로 string의 마지막부터 조회를 해서 '0'인 경우 count + 1을 한다.
그리고 0이 아닌 순간 break하고 count를 출력한다.
```python
n = int(input())
fac = 1
for i in range(1, n+1):
    fac *= i
s = str(fac)

res = 0
for i in s[::-1]:
    if i == '0':
        res += 1
    else:
        break
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1676
