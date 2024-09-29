# [SWEA - D5] 1259. 금속 막대

## ⏰  **time**
30분

## :pushpin: **Algorithm**
백트래킹


## :round_pushpin: **Logic**
1. 연결가능한 나사가 있을 때마다 분기
```
 void dfs(int depth) {
    if (complete)return;
    if (depth == v.size()) {
        for (auto i: result) {
            cout << i.first << ' ' << i.second << ' ';
        }
        cout << '\n';
        complete = true;
        return;
    }
    for (int i = 0; i < n; i++) {
        if (result.empty()) {
            result.push_back(v[i]);
            done[i] = true;
            dfs(depth + 1);
            done[i] = false;
            result.pop_back();
        }else if(!done[i]){
            if(v[i].first==result.back().second){
                done[i]=true;
                result.push_back(v[i]);
                dfs(depth+1);
                done[i]=false;
                result.pop_back();
            }else if(v[i].second==result.front().first){
                done[i]=true;
                result.push_front(v[i]);
                dfs(depth+1);
                done[i]=false;
                result.pop_front();
            }
        }
    }
}
```

## :black_nib: **Review**
- 



## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18NaZqIt8CFAZN
