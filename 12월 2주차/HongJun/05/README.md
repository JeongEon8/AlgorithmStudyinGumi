# [백준 - S2] 30804. 과일 탕후루

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 브루트포스, 두포인터

## ⏲️**Time Complexity**

$O(N*N)$

## :round_pushpin: **Logic**

- 과일 두 종류 이하로 만들어진 탕후루 중에서 가장 많은 과일인 것의 과일 개수 구하기
- 포인터 두개를 시작점으로 놓고 이동하면서, 과일의 종류가 다르면 종류 카운트에 +1한다.
- 종류가 2가 넘어가면 시작점에서 이동시켜서 종류가 2가지가 될때까지 이동한다.
- 각 경우에 left, right 값의 차이 중 가장 큰 값을 출력

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/30804