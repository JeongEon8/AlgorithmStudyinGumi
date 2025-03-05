# [백준 - 실버 5] 25206. 너의 평점은
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(L)$

## :round_pushpin: **Logic**
1. switch문을 이용해 각 점수별 과목평점 저장
2. 평점 계산을 위해 grade의 초기값을 -1.0으로 설정하여 P가 아닌 경우만 학점 증가
```java
if(grade >= 0.0) {
  avg += grade * credit;
  subjects += credit;
}
```

## :black_nib: **Review**
- 처음에 봤을 땐 절대오차 써있길래 귀찮은 문젠줄 알았더니 아니었다 따봉
- O(L)은 지피티 말로는 한 줄 입력이 L이고 입력길이에만 비례하는 시간복잡도라함

## 📡 Link
https://www.acmicpc.net/problem/25206
