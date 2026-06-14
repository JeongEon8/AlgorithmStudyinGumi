# [PGS - Lv2] 01_피로도

## ⏰**time**
30분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
1. 탐험하지 않은 던전이고, 해당 던전의 최소 필요 피로도가 k보다 작거나 같으면 던전 탐험
2. DFS 수행이 끝난 던전은 다른 경우에서 재탐험할 수있도록 방문 체크 해제
   ```cpp
    for (int i=0; i<dungeons.size(); i++) {
        if (!visited[i] && dungeons[i][0] <= k) {
            visited[i] = true;
            dfs(cnt + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 Lv2 피로도](https://school.programmers.co.kr/learn/courses/30/lessons/87946)
