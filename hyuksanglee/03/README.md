# [프로그래머스 - lv2] 혼자서 하는 틱택토

## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. O와 X 개수를 세서 O<X 이면 0 반환
2. O 빙고 일때 X 수가 같으면 0반환
3. X 빙고 일때 O =! 같지 않을경우 0반환
      
```java
	static boolean bfs(int i, int j, char c){
        for(int d= 0; d<4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            
            if(ni <0 || ni>=3 || nj < 0 || nj>=3){
                continue;
            }
            
            if(map[ni][nj] == c){
                ni += di[d];
                nj += dj[d];
                if(ni <0 || ni>=3 || nj < 0 || nj>=3){
                    continue;
                }
                if(map[ni][nj] == c){
                    return true;
                }
                
            }
        }
        return false;
    }
```





## :black_nib: **Review**
- 반례 한개 더 있더라구요 0개수랑 x개수 차이가 1개 나야하더라구요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/160585
