# [백준 - S2] 4948. 베르트랑 공준

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
n의 입력이 123,456 이기 때문에 2부터 2n까지 소수를 구하는 함수를 실행한다.
2부터 N^0.5의 범위에서 나눴을 때 나머지가 0이면 멈추고 count + 1을 한다. 이건 소수가 아닌 경우.
이 과정이 끝나고 count가 0이면 n은 소수이다.
```python
def sosu(n):
    count = 0
    if n == 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            count += 1
            break
    if count == 0:
        num.append(n)
        return
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/4948
