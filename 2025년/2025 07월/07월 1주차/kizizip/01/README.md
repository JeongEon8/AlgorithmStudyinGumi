# [백준 - S4] 16173. 점프왕 쩰리 (Small)

## ⏰ **time**
25분

## :pushpin: **Algorithm**
그래프 이론, dfs, 백트래킹 

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
1. 목적지 도달시 true 반환하고 종료하는 조건 
```java
        if (map[x][y] == -1) {
            return true;
        }
```

2. `int jump = map[x][y];` 칸에 적힌 수만큼 jump에 저장
3. jump만큼 뛰고 뛰고 뛰어서 목적지에 도달한다면 끝...


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/16173
