# [백준 - S4] 1120. 문자열

## ⏰ **time**

30분

## :pushpin: **Algorithm**
브루트포스, 문자열


## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. A문자열과 B문자열의 길이가 같으면 바로 비교해서 같은 자리에 다른 알파벳 수를 찾는다.
2. B문자열이 더 긴 경우 A문자열의 길이 만큼 B에서 나올 수 있는 연속된 문자열의 모든 경우의 수를 반복문으로 구해서 탐색한다.
3. 그거랑 A문자열이랑 자리 비교해서 가장 작은 값을 찾으면 된다.


## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1120