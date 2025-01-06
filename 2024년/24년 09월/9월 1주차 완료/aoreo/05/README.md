# [백준 - 실버 1] 14888.연산자 끼워넣기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
순열

## ⏲️**Time Complexity**
$O(2^N)$

## :round_pushpin: **Logic**
1. 중복되는 연산자가 있기 때문에, 남아있는 개수가 0 초과일 경우에만 뽑도록 한다.
2. N-1개의 연산자를 뽑고, 해당 연산자들로 순서대로 계산을 한다.
3. 최솟값과 최댓값을 찾는다.


## :black_nib: **Review**
- 중복되는 연산자가 있기때문에 일반적인 순열방식을 쓸 수 없었고.. 뭔가 이 비슷하게 생긴 걸 예전에 확통에서 봤던 거 같은데 기억이 나지 않았고...
- 방법을 처음에 찾을 때 조금 헤맸다

## 📡 Link
[https://www.acmicpc.net/problem/14888](https://www.acmicpc.net/problem/14888)
