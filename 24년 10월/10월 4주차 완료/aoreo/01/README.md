# [백준 - 골드 4] 17281.⚾
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
시뮬레이션

## ⏲️**Time Complexity**
$O(N*8!)$

## :round_pushpin: **Logic**
1. 야구선수들의 순서를 순열을 이용해서 뽑기
2. 9번까지의 순서를 다 정하면, 게임 시작
3. 크기 3의 boolean 배열로 1루, 2루, 3루에 사람이 있는지를 나타냄
4. out이 3이 될 경우 round를 1 증가시키고, out을 0으로 변경 후, 모든 base를 false로 변경
5. 매 게임마다 나올 선수의 순서 번호를 1씩 증가시킴
6. 게임이 끝났을 때(round가 N에 도달했을 때)의 점수와 현재 최댓값을 비교하여 최댓값 설정

## :black_nib: **Review**
- 새로운 이닝이 시작할 때 모든 base를 비워야했는데 그걸 빼먹어서 값이 조금씩 달랐다..
- 1초라서 이걸 순열을 써도 되나? 했지만 됐다

## 📡 Link
https://www.acmicpc.net/problem/17281
