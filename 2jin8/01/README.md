# [백준- G4] 16234. 인구 이동
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
완탐 + BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 인구 이동은 최대 2000일, N = 50 ⇒ 완탐 가능
- 각 배열을 시작점으로 해서 연합 찾기
  - 연합 다 찾으면 인구 수 조정하기
```java
// 연합 찾기
static boolean findUnion(int x, int y) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{x, y});
    visited[x][y] = true;
    boolean isMove = false;

    ArrayList<int[]> unionList = new ArrayList<>();
    int totalPeople = 0;
    while (!queue.isEmpty()) {
        int[] now = queue.poll();
        unionList.add(now);
        totalPeople += arr[now[0]][now[1]];

        for (int i = 0; i < 4; i++) {
            int nx = now[0] + dx[i];
            int ny = now[1] + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }

            // 현재 칸과의 인구 차이 비교하기
            int diff = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]);
            if (diff >= L && diff <= R) { // 인구 차이가 L명 이상, R명 이하라면 국경선 열기
                isMove = true;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
    // 인구 이동
    movePeople(unionList, totalPeople);
    return isMove;
}

// 인구 이동
public static void movePeople(ArrayList<int[]> unionList, int totalPeople) {
    int newPeople = totalPeople / unionList.size();
    for (int[] union : unionList) {
        newArr[union[0]][union[1]] = newPeople;
    }
}
```

## :black_nib: **Review**
완탐 느낌이라 나름 괜찮았던 문제

## 📡**Link**
- https://www.acmicpc.net/problem/16234
