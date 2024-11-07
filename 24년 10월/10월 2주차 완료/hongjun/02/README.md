# [백준 G4] 1715. 카드 정렬하기

## ⏰ **소요 시간**
30분

## :pushpin: **Algorithm**
우선순위 큐, 그리디

## ⏲️**Time Complexity (시간 복잡도)**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 숫자열에서 가장 작은 두 수의 합을 지속적으로 더해야한다.
2. 우선순위 큐에서 heappop을 사용해서 현재 가장 작은 두 수를 뽑아서 더한다.
3. 더한 수를 결과값에 넣고 우선순위큐에 push한다.
4. 다시 가장 작은 두 수를 뽑아서 이 과정을 반복한다.
5. while문을 써서 배열의 길이가 2개이면 딱 2개를 뽑고 끝날 수 있게 한다.

## :black_nib: **Review**


## 📡 Link

https://www.acmicpc.net/problem/1715
