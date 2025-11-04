# [백준 - S5] 10709. 기상캐스터
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
- 초기에는 모두 구름이 뜨지 않았다고 가정한 배열을 만든다
- 구름이 있으면 0으로 바꿔준다.
- 임시값 변수를 선언하고 다음 구름으로 갈 때는 0으로 초기화한다.
- 이 전의 값이 0, -1이 아니면 임시값을 넣어준다.
- 다음에 구름이 있는 곳은 다시 리셋되니까 임시값 +1을 하고 구름 배열에 tmp값을 넣어준다.


## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/10709
