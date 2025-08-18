# [백준 - S4] GCD 합


## ⏰ **time**
15분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
- 유클리드 호제법으로 두 수의 최대공약수를 구하고 합을 출력한다.
- 2중 for문으로 모든 쌍의 index번호를 구한다.
```python
    def gcd(a, b):
        if (b == 0):
            return a
        return gcd(b, a%b)

    for i in range(1, n):
        for j in range(i+1, n+1):
            res += gcd(li[j], li[i])

```


## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/9613
