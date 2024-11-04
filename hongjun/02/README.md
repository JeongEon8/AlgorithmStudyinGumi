# [백준 - S3] 3273. 두 수의 합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 투포인터
- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 오름차순으로 입력받은 수열을 정렬한다.
- 맨 앞과 맨 뒤에 포인터 2개를 잡는다.
- 각 포인터에 위치한 값의 합이 x와 같으면 st + 1, en - 1을 한다.
- 합이 더 작은 경우에는 st + 1
- 더 큰 경우에는 en - 1을 해서 x와 같은지 체크한다.
- 합이 x와 같은 경우의 수 출력

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/3273
