# [백준- G4] 9019. DSLR
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(T)$

## :round_pushpin: **Logic**
- 최소한의 명령어 개수를 구하는 것 → BFS 탐색
- D: 2 * n
- S: n - 1
- L: 1234 → 2341
  - `(number % 1000) * 10 + number / 1000`
- R: 1234 → 4123
  - `(number % 10) * 1000 + number / 10`
```java
static String bfs() {
    Queue<Calc> queue = new ArrayDeque<>();
    queue.offer(new Calc("", A));
    visited[A] = true;

    String cmd = "";
    while (!queue.isEmpty()) {
        Calc now = queue.poll();
        if (now.number == B) {
            cmd = now.cmd;
            break;
        }

        int number = now.number;
        int D = (number * 2) % MAX;
        int S = number == 0 ? 9999 : number - 1;
        int L = (number % 1000) * 10 + number / 1000;
        int R = (number % 10) * 1000 + number / 10;

        if (!visited[D]) {
            queue.offer(new Calc(now.cmd + "D", D));
            visited[D] = true;
        }

        if (!visited[S]) {
            queue.offer(new Calc(now.cmd + "S", S));
            visited[S] = true;
        }

        if (!visited[L]) {
            queue.offer(new Calc(now.cmd + "L", L));
            visited[L] = true;
        }

        if (!visited[R]) {
            queue.offer(new Calc(now.cmd + "R", R));
            visited[R] = true;
        }
    }
    return cmd;
}
```

## :black_nib: **Review**
쓸데없이 복잡하게 생각했다.. 그냥 머리를 썼으면 됐는데

## 📡**Link**
- https://www.acmicpc.net/problem/9019
