# [백준] 11047. 동전 0


## ⏰ **time**
5분

## :pushpin: **Algorithm**
그리디 알고리즘

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
coins에 동전을 담는데 작은 순부터 담겼으니까... 큰 순으로 검토하면서<br>
현재 확인하는 동전이 k보다 작거나 같으면 그 동전을 얼마나 쓸 거인지 count하고 `k/coins[i]` <br>
그 동전 소진한 만큼 k에서 빼준다 `k %= coins[i]`


## :black_nib: **Review**
히히쉽다

## 📡**Link**
https://www.acmicpc.net/problem/11047
