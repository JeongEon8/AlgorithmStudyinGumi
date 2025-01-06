# [SWEA - D6] 1267. 작업 순서

## ⏰  **time**
20분

## :pushpin: **Algorithm**
위상정렬


## :round_pushpin: **Logic**
1. 위상정렬 후 출력
```
  for (int i = 0; i <= n; i++) {
            before[i] = 0;
        }
        vector<int> next[n + 1];
        for (int i = 0; i < m; i++) {
            cin >> a >> b;
            next[a].push_back(b);
            before[b]++;
        }
```

## :black_nib: **Review**
- 



## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18TrIqIwUCFAZN
