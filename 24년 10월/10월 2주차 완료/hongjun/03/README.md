# [백준 G5] 2096. 내려가기

## ⏰ **소요 시간**

50분

## :pushpin: **Algorithm**

DP, 슬라이딩 윈도우

## ⏲️**Time Complexity (시간 복잡도)**

$O(N*N)$

## :round_pushpin: **Logic**
1. 1차원 배열로 DP를 하기 위해서 N번 째 줄에서 두 수의 합을 저장하는 테이블 하나
2. 최대값, 최소값을 임시로 계산하여 저장할 배열 하나를 만든다.

## :black_nib: **Review**
처음에 2차원 배열 DP로 풀었는데 메모리 초과가 나서 1차원으로 풀어야되는 것을 깨달았다..

## 📡 Link

https://www.acmicpc.net/problem/2096