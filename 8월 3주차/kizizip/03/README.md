# [백준 - S3] 15656. N과 M (7) 


## ⏰ **time**
20분

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n^m)

## :round_pushpin: **Logic**
1. n개의 수 입력 후 오름차순 정렬, m개의 수를 담을 배열(arr) 준비
2. dfs로 깊이 m까지 모든 수열 생성
3. 각 깊이에서 0~n-1까지 반복하며 현재 값(arr[depth]) 저장 후 재귀 호출
4. 중복 허용이므로 visited 배열 필요 없음
5. 수열이 완성되면 sb에 저장 후 출력

## :black_nib: **Review**
n과 m은 끝나지 않는다

## 📡**Link**
https://www.acmicpc.net/problem/15656
