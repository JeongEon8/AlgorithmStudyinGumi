# [PGS - Lv2] 02_모음 사전

## ⏰**time**
10분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N!)$

## :round_pushpin: **Logic**
1. AEIOU 순회하면서 DFS
   ```cpp
void dfs(string word) {
     cnt++;
    
    if (word == target) {
        answer = cnt;
        return;
    }
    
    if (word.length() >= 5) return;
    
    for (int i=0; i<5; i++) {
        dfs(word + aeiou[i]);
    }
}
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/84512
