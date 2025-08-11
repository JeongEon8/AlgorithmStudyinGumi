# [백준 - S3] 1735. 분수 합

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 유클리드 호제법

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
2개의 분수를 더한 값의 분자, 분모를 계산한다.
그리고 분자와 분모의 최대공약수로 두 수를 나눠주면 기약분수가 된다.
유클리드 호제법 gcd 함수로 최대공약수를 구한다.

```python
B = b1*b2
A = a1*b2 + a2*b1

def gcd(x, y):
    while y:
        x, y = y, x%y
    return x

gcd = gcd(A, B)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1735
