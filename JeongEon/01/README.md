# [백준 - 골드 4] 20040. 사이클 게임
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
유니온-파인드

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 부모가 동일한지 확인한다
   ```cpp
     int find(int u) {
         if (parent[u] == u) return u;
         else return parent[u] = find(parent[u]);
     }
     
     bool union_node(int u, int v){
         u = find(u);
         v = find(v);
     
         // 부모노드가 같으면 사이클이 생기므로 true 반환
         if (u == v) return true;
         else // 노드 결합
         {
             parent[u] = v;
             return false;
         }
     }
   ```

## :black_nib: **Review**
- 사이클은 유니온 파인드....

## 📡 Link
https://www.acmicpc.net/problem/20040
