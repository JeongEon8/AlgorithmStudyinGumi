# [백준 - S5] 1436. 영화감독 숌

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 브루트포스

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 입력한 수에서 -1을 한 값을 '666' 앞에 붙여주면 된다.

```python
n = int(input())
first = 666
while 1:
    if '666' in str(first):
        n -= 1
        if n == 0:
            break
    first += 1
print(first)
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/1436
