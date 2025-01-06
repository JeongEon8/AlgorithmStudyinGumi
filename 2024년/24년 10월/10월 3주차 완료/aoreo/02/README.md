# [백준 - 골드 4] 14500.테트로미노
 
## ⏰  **time**
5시간

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 매 칸을 시작점으로 4칸씩 점유하며 모든 칸들의 점수 저장하기
2. dfs를 통해 칸 점유하기
3. ㅗ, ㅏ, ㅜ, ㅓ는 이동하는 방식으로는 구할 수 없으므로 따로 나눠서 구하기
4. 매마다 가능한 max값 저장하기

## :black_nib: **Review**
- dfs를 이용해서 구하고 또 ㅗ, ㅏ, ㅜ, ㅓ를 따로 해도 시간이 안 터지나? 했는데 안 터졌다 따봉

## 📡 Link
https://www.acmicpc.net/problem/14500
