# [백준 - S3] 2579. 계단 오르기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- DP

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 2번 계단 -> 1,2
- 3번 계단을 밟는 경우 -> 1,3 / 2,3 중 최대값
- 4번 계단 -> 1,2,4 / 1,3,4 / 2,4 중 최대값
- 5번 계단 -> 1,2,4,5 / 1,3,5 / 2,3,5 중 최대값
- 점화식으로 정리하면
- score[N] = score[N-2] + stair[N]
- score[N] = score[N-3] + stair[N-1] + stair[N]

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2579