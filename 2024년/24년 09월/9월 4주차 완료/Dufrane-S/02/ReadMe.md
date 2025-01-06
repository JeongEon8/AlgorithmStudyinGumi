# [SWEA - 모의] 1949. 등산로 조성

## ⏰  **time**
60분

## :pushpin: **Algorithm**
백트래킹


## :round_pushpin: **Logic**
1. 깎을 필요가 있을 때 깎아주면서 dfs
```
   if (answer < tmp) {
        answer = tmp;
    }
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny == n || nx == n || done[ny][nx])continue;
        if (copy_box[ny][nx] < copy_box[y][x]) {
            done[ny][nx] = true;
            tmp++;
            dfs(ny, nx);
            tmp--;
            done[ny][nx] = false;
        } else if (!cut && copy_box[ny][nx] - m < copy_box[y][x]) {
            done[ny][nx] = true;
            tmp++;
            cut = true;
            int temp = copy_box[ny][nx];
            copy_box[ny][nx] = copy_box[y][x] - 1;
            dfs(ny, nx);
            copy_box[ny][nx] = temp;
            cut = false;
            tmp--;
            done[ny][nx] = false;
        }
    }
```

## :black_nib: **Review**
- 



## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq
