# [백준 - S5] 1094. 막대기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 수학, 비트마스킹

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 64부터 절반씩 자르니까 1부터 64까지 2의 제곱수들을 배열에 넣는다.
- X가 기존 막대보다 작은 경우에는 절반으로 나눠야되기 떄문에 다음 수로 넘어간다.
- X가 더 크면 리스트에 추가해서 저장한다.
- 리스트의 합이 X보다 크면 안되기 때문에 pop한다.
- x와 리스트의 합이 같으면 정답이다.

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1094
