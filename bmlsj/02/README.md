
# [백준- G5] 13549. 숨바꼭질3
## ⏰  **time**
60분

## :pushpin: **Algorithm**
Deque

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- 순간이동은 시간 소모가 0초이므로, 덱의 앞쪽에 넣어 즉시 탐색
- `+1`, `-1` 이동은 시간 1초 소모, 덱 뒤쪽에 넣어 나중에 탐색
- 방문 배열로 중복 탐색 방지

```java
static int bfs() {
    	
    Deque<int[]> dq = new ArrayDeque<>();
    dq.add(new int[]{N, 0});
    visited[N] = true;
        
    while (!dq.isEmpty()) {
        	
        int[] cur = dq.pollFirst();
        int x = cur[0];
        int time = cur[1];
            
        if (x == K) return time;
            
        // 순간이동
        int nx = x * 2;
        if (nx <= 200000 && !visited[nx]) {
            visited[nx] = true;
            dq.addFirst(new int[]{nx, time});
        }
            
        // -1, +1 이동
        for (int dir : new int[]{-1, 1}) {
            nx = x + dir;
            if (nx >= 0 && nx <= 200000 && !visited[nx]) {
                visited[nx] = true;
                dq.addLast(new int[]{nx, time + 1});
            }
        }
    }
    return -1;
}
```

## :black_nib: **Review**
Deque... Deque...

## 📡**Link**
- https://www.acmicpc.net/problem/13549

