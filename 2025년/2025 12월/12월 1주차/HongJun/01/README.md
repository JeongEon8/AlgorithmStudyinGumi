# [백준 - G5] 2343. 기타 레슨 

## ⏰ **time**
30분

## :pushpin: **Algorithm**
- 이분 탐색

## ⏲️**Time Complexity**
$O(logN)$

## :round_pushpin: **Logic**
- start = 강의 길이 리스트의 최댓값, end = 강의 길이 총 합
- 블루레이 크기를 mid로 잡고 start + end의 절반 값으로 초기화
- 레슨 시간의 합을 첫 원소부터 더해서 블루레이의 공간이 남았는지 비교
- 공간이 남았으면 그 원소를 더한다
- 합이 더 커지면 개수 +1을 하고 레슨 합을 초기화한다

- 계산한 개수가 블루레이의 개수보다 작으면 크기를 줄인다
- 반대로 개수가 넘어가면 크기를 늘린다
 
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2343