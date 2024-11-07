# [백준 - S5] 2828. 사과 담기 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 바구니의 크기에 맞게 바구니의 시작, 끝 인덱스를 잡는다.
- 과일이 떨어지는 위치를 입력받아서 해당 위치가 바구니 범위 안에 있으면 넘어감.
- 바구니 범위 밖에 있으면 2가지 경우다.
  - 바구니 오른쪽이면 st, en을 +1해서 옮긴다
  - 왼쪽이면 st, en을 -1해서 옮긴다
- 옮기고 나서 바구니 안에 과일이 위치하면 다음으로 넘어간다

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2828
