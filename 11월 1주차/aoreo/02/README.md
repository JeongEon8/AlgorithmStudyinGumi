# [백준 - 골드 4] 1062. 가르침
 
## ⏰  **time**
4시간

## :pushpin: **Algorithm**
구현, 조합

## ⏲️**Time Complexity**
$O(N×L)$

## :round_pushpin: **Logic**
1. a, n, t, i, c를 제외하고 가르칠 단어 고르기
2. 가르칠 단어는 존재하는 단어들을 set하여 그 중에서 고르기
3. 가르칠 단어를 K-5개만큼 뽑음
4. 뽑은 알파벳들로, 현재 있는 단어들을 제거했을 때 다 제거되면 읽을 수 있는 것

## :black_nib: **Review**
- 처음에는 26개 중 a, n, t, i, c를 제외한 21개의 알파벳 중 가르칠 단어 K-5를 골라서 시간복잡도로 팡 터져버렸다 😥😥😥

## 📡 Link
https://www.acmicpc.net/problem/1062
