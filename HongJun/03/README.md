# [백준 - S2] 11501. 주식
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 주가 리스트 중 가장 큰 값의 위치를 파악한다.
- 주가 리스트를 순회하면서 최대값보다 작으면 하나 사는 것으로 count +1을 한다.
- 최대 가격일 경우 다 팔아야 하기 때문에 현재 가격과 최대값의 차를 구하고, count를 0으로 초기화한다.

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/11501