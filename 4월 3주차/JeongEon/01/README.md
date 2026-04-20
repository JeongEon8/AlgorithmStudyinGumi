# [백준 - 골드 4] 1753. 최단경로

## ⏰ **time**
49분

## :pushpin: **Algorithm**
다익스트라

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위 큐를 이용해 현재 정점과 다음 정점까지의 거리를 계산한다.
```cpp
void fc(int st) {
    memset(dp, INF, sizeof(dp));
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({ 0, st });
    dp[st] = 0;

    while (!pq.empty()) {
        int x = pq.top().second;
        int cost = pq.top().first;
        pq.pop();
        for (int i = 0; i < v[x].size(); i++) {
            int nx = v[x][i].first;
            int ncost = cost + v[x][i].second; 

            if (dp[nx] > ncost) {
                pq.push({ ncost, nx });
                dp[nx] = ncost;
            }
        }
    }
}
```

## :black_nib: **Review**
- 아 왜 안 풀리지 하면서 머리 싸매는건.. 딱 30분까지가 좋은 거 같다..

## 📡 Link
[https://www.acmicpc.net/problem/1753](https://www.acmicpc.net/problem/1753)
