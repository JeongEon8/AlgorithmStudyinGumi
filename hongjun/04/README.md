# [백준 - S1] 6588. 골드바흐의 추측
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 에라토스테네스의 체체

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 에라토스테네스의 체를 사용해서 소수인 수만 True로 한다.
2. 가장 작은 소수부터 입력한 숫자에 뺐을 때, 그 숫자도 소수인지 확인한다.
3. 둘 다 소수이면 출력 형식에 맞게 출력한다.
```python
# 에라토스테네스 체로 소수만 True
prime = [True for i in range(MAX + 1)]
for i in range(2, int((MAX) ** 0.5) + 1):
    if prime[i]:
        j = 2
        while i * j <= MAX:
            prime[i * j] = False
            j += 1
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/6588