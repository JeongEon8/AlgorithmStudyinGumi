# [백준 - S1] 14562. 태권왕

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
자신의 점수가 2배가 되지만 상대도 3점을 얻는 발차기A와 자신만 1점을 얻는 발차기B를 bfs로 탐색해서 같아지는 순간의 진행 횟수를 구한다.
```java
for (int i = 0; i < n; i++) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int s = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    Queue<Score> que = new ArrayDeque<Score>();
    que.add(new Score(0, s, t));
    while (!que.isEmpty()) {
        Score current = que.poll();
        if (current.s == current.t) {
            sb.append(current.step).append('\n');
            break;
        }
        if (current.s * 2 <= current.t + 3) {
            que.add(new Score(current.step + 1, current.s * 2, current.t + 3));
        }
        que.add(new Score(current.step + 1, current.s + 1, current.t));
    }
}
```  
## :black_nib: **Review** 
문제 이름은 태권왕인데 직선좌표 술래잡기 문제..
## 📡**Link**
https://www.acmicpc.net/problem/14562