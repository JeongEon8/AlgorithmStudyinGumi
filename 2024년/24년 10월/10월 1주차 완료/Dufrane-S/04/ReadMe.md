# [백준 - G4] 2636. 치즈
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. bfs로 구멍이 안인지 밖인지 확인
2. 겉부분 치즈 제거 해주기
   ```cpp
		 while (true) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    check(i, j);
                }
            }
        }
        vector<pair<int, int>> new_cheese;
        for (auto i: cheese) {
            if (!checkOut(i.first, i.second)) {
                new_cheese.push_back(i);
            }
        }
        if (!new_cheese.empty()) {
            cheese = new_cheese;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    box[i][j] = 0;
                }
            }
            for (auto i: cheese) {
                box[i.first][i.second] = 1;
            }
        } else {
            count++;
            cout << count<<'\n'<<cheese.size();
            break;
        }
        count++;
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/2636
