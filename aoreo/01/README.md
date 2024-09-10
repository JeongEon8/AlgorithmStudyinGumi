# [백준 - 실버 1] 14889.스타트와 링크
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
조합

## ⏲️**Time Complexity**
$O(2^N*(N*2))$

## :round_pushpin: **Logic**
1. N/2명을 조합으로 뽑음
2. 다 뽑을 때마다, 뽑힌 팀원들의 시너지 점수를 더한다
3. 뽑히지 않은 사람들을 구하기 위해, 모든 사람들을 ArrayList에 넣고, 뽑힌 쪽에 포함되는 인원들을 제거한다
4. 안 뽑힌 사람들을 탐색하며, 팀원들의 시너지 점수를 더한다
5. 두 합계 점수의 차를 구하여 가장 큰 값을 반환한다


## :black_nib: **Review**
- 뽑히지 않은 사람들을 어떻게 구하지?가 고민부분이었다. 뭔가 더 깔끔하게 뽑아내는 방법이 있었을까?

## 📡 Link
[https://www.acmicpc.net/problem/14500](https://www.acmicpc.net/problem/14889)
