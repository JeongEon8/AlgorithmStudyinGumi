# [백준 - 골드 5] 10026. 적록색약

## ⏰**time**

24분

## :pushpin: **Algorithm**

- BFS / DFS
- 영역 개수 세기

## ⏲️**Time Complexity**

$O(N^2)$  
(\(N \times N\) 격자를 각 칸당 최대 한 번씩만 방문)

## :round_pushpin: **Logic**

1. `N`을 입력받고, 각 줄의 색상 문자열을 배열 `a[]`에 저장합니다.

```java
int N = Integer.parseInt(br.readLine());
String[] a = new String[N];
for (int i = 0; i < N; i++) {
    a[i] = br.readLine();
}
```

2. 정상 시력(`watch(true, ...)`)과 적록색약(`watch(false, ...)`) 두 경우에 대해  
   각각 BFS로 구역(연결 요소)의 개수를 세고, 결과를 `"정상 적록색약"` 형태로 출력합니다.

```java
sb.append(watch(true, a, N)).append(" ").append(watch(false, a, N));
System.out.println(sb);
```

3. `watch` 함수에서는 방문 배열 `visited`와 큐를 사용해, 아직 방문하지 않은 칸에서 BFS를 시작하여 하나의 구역을 확장합니다.  
   적록색약인 경우(`watchGreen == false`)에는 `G`를 `R`로 취급하여 `R`과 `G`를 같은 색으로 본다는 점이 핵심입니다.

```java
public static int watch(boolean watchGreen, String[] a, int N) {
    int[][] visited = new int[N][N];
    Queue<int[]> q = new ArrayDeque<>();
    int cnt = 0;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (visited[i][j] != 0) continue;

            char color = a[i].charAt(j);
            if (!watchGreen && color == 'G') color = 'R';
            visited[i][j] = ++cnt;
            q.offer(new int[]{j, i});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[ny][nx] == 0) {
                        char tmp = a[ny].charAt(nx);
                        if (!watchGreen && tmp == 'G') tmp = 'R';
                        if (tmp == color) {
                            visited[ny][nx] = cnt;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
    return cnt;
}
```

## :black_nib: **Review**

- 방문할 때, 카운트를 세면 편하다.

## 📡 Link

https://www.acmicpc.net/problem/10026
