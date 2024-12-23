# [백준 - 골드 4] 7662. 이중 우선순위 큐
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
맵, 우선순위 큐

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 최댓값 우선순위 큐와 최소값 우선순위 큐를 만든다.
2. I일때는 무조건 두 큐에 넣는다.
3. D -1이면 최소값 큐를 지우고, D 1이면 최댓값 우선순위 큐를 지운다.
```cpp
while (T--) {
    while (!min_pq.empty()) {
        min_pq.pop();
    }
    while (!max_pq.empty()) {
        max_pq.pop();
    }
    cnt.clear();

    cin >> k;
    for (int i = 0; i < k; i++) {
        cin >> cmd >> n;

        if (cmd == 'I') {
            insert(n);
        }
        else {
            if (n == 1) {
                deleteMax();
            }
            else {
                deleteMin();
            }
            cleanPq();
        }
    }
```

## :black_nib: **Review**
- 처음에 그냥 deque로 했다가 시간초과 났다.

## 📡 Link
https://www.acmicpc.net/problem/7662
