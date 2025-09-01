# [백준 - S5] 11292. 키 큰 사람 


## ⏰ **time**
10분

## :pushpin: **Algorithm**
구현, 정렬 

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
1. 변수 초기화
`maxh` 현재까지 발견한 최대 키
`names` 최대 키를 가진 사람들의 이름 리스트
2. 사람 정보 반복 처리 
- 이름과 키 입력
- 키가 `maxh`보다 크면
    - `maxh` 갱신
    - `names` 리스트 초기화 후 현재 이름 추가
- 키가 `maxh`와 같으면
    - 현재 이름을 `names` 리스트에 추가
3. 출력
- 모든 입력 처리 후 `names` 리스트에 있는 이름 출력

## :black_nib: **Review**
마지막 문제는 실버 5로 날치기..

## 📡**Link**
https://www.acmicpc.net/problem/11292
