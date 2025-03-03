# [백준 - 골드 4] 14499.주사위 굴리기
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 주사위 도면형태로 배열 생성. 숫자가 들어가지 않는 공간에는 -1로 설정
2. dices[1][3]은 위아래로 돌릴 때, 양옆으로 돌릴 때 모두 움직이는 영역이므로 따로 값 처리
3. command를 하나씩 받으며 양옆으로 돌릴 경우는 y값이 -1, 1되도록 하고, 위아래로 돌릴 경우는 x값이 -1, 1되도록 함
4. 하나의 command가 끝날 때마다 상단의 위치가 [1][1]이므로, 해당 값 출력

## :black_nib: **Review**
- dices[1][3]이 양옆으로 돌릴 때, 위아래로 돌릴 때 모두 겹친다는 걸 망각하고 처리 안했더니 제대로 안 됐었다 😢😢

## 📡 Link
https://www.acmicpc.net/problem/14499
