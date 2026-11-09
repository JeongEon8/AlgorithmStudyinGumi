# [PGS - Lv2] 01_전력망을 둘로 나누기

## ⏰**time**
30분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. DFS를 이용해서 2번째 노드부터, 3번 노드와 이어져있는 노드는 count를 올리고 다른 노드에 도착하면 재귀호출
   ```cpp
   int DFS(int togo, int now, int count)
   {
       for(int i = 0; i < m[now].size(); i++)
       {
           if(m[now][i] != togo)
           {
               count = DFS(now, m[now][i], count + 1);
           }
       }
       return count;
   }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 lv2 전력망을 둘로 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/86971)
