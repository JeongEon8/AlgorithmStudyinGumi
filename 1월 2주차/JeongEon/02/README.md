# [백준 - 실버 2] 11501. 주식

## ⏰ **Time**
11분

## :pushpin: **Algorithm**
그리디

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 주식 가격을 배열에 저장한다.
2. **가장 마지막 날부터 거꾸로 탐색**하면서 현재까지의 최대 주가(`maxx`)를 유지한다.
3. 현재 가격이 `maxx`보다 작으면, 해당 주식은 이후 최대가에 팔 수 있으므로
   `maxx - 현재 가격`을 이익에 더한다.
4. 현재 가격이 `maxx`보다 크면, 해당 값을 새로운 최대 주가로 갱신한다.
5. 모든 날에 대해 위 과정을 반복하면 최대 이익을 구할 수 있다.

```
maxx = -1
result = 0
for i = N-1 down to 0:
    maxx = max(maxx, price[i])
    result += maxx - price[i]
```

## :black_nib: **Review**
- 홍준~~ 주식 천재였구나~~~

## 📡 Link
[https://www.acmicpc.net/problem/11501](https://www.acmicpc.net/problem/11501)
