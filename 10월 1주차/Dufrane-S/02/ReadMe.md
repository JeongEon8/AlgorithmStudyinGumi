# [SWEA - D4] 1227. 미로2
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. bfs로 연결확인하기 
   ```cpp
		  while (!q.empty()) {
            int nowy = q.front().first;
            int nowx = q.front().second;
            q.pop();
            for (int k = 0; k < 4; k++) {
                int ny = nowy + dy[k];
                int nx = nowx + dx[k];
                if (ny <= 0 || nx < 0 || ny == 100 || nx == 100 || box[ny][nx] == 1)continue;
                if (box[ny][nx] == 3) {
                    flag=true;
                    break;
                }
                box[ny][nx]=1;
                q.push({ny,nx});
            }
        }
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
