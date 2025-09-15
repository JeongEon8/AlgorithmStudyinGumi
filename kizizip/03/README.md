# [프로그래머스 - 2] n^2 배열 자르기 


## ⏰ **time**
20분

## :pushpin: **Algorithm**
구현, 수학적 규칙 활용 

## ⏲️**Time Complexity**
O(R)

## :round_pushpin: **Logic**
1. 출력 크기 = right - left + 1 만큼 배열(answer) 생성
2. left부터 right까지 순회하면서 각 인덱스를 2차원 배열(row, col)로 변환
- row = i / n
- col = i % n
3. 각 위치의 값 = max(row, col) + 1
4. answer 배열에 순서대로 저장
5. answer 반환


## :black_nib: **Review** 
낫밷

## 📡**Link**
