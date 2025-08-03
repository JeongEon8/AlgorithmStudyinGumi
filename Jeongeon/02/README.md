# [백준 - 실버 3] 2075. N번째 큰 수

## ⏰  **time**
15분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 항상 높은 수가 맨 앞에 있겠지!
2. 개수가 넘어가면 버려!
```cpp
    for (int i = 0; i < n * n; i++) {
        cin >> temp;
        pq.push(temp);
        if (pq.size() > n) {
            pq.pop();
        }
    }
    cout << pq.top();
```

## :black_nib: **Review**
- 우선순위 큐는 최고야!
  
## 📡 Link
https://www.acmicpc.net/problem/2075
