# [백준 - G3] 17471. 게리맨더링
 
## ⏰  **time**
1시간 20분

## :pushpin: **Algorithm**
구현

## :round_pushpin: **Logic**
- N이 최대 10이므로, 조합을 이용해서 선거구를 나누는 모든 경우의 수를 만들기
- 선거구를 나눈 후, 해당 선거구에 포함된 지역들이 연결되어 있는지 확인하기
- 각 선거구의 지역들이 모두 연결되었다면 최소 인구 차이를 갱신하기 
```java
static boolean checkConnection(ArrayList<Integer> group) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(group.get(0));
    boolean[] visited = new boolean[N + 1];
    visited[group.get(0)] = true;

    int connectionArea = 0;
    while (!queue.isEmpty()) {
        int now = queue.poll();
        connectionArea++;

        for (int i = 0; i < graph[now].size(); i++) {
            int next = graph[now].get(i);
            if (group.contains(next) && !visited[next]) {
                queue.offer(next);
                visited[next] = true;
            }
        }
    }
    // 연결된 지역의 수와 선거구에 포함된 지역의 수가 다르면 불가능한 방법
    if (connectionArea != group.size()) return false;
    return true;
}
```

## :black_nib: **Review**
처음에 단순하게 연결 여부를 확인했더니, 2%에서 바로 틀렸었다.. 그래서 BFS 탐색을 이용해서 연결을 확인하는 방식으로 고쳤다. <br/>
처음부터 반례를 잘 생각하고 개발하는 습관을 가지자..!

## 📡**Link**
- [백준 17471_게리멘더링](https://www.acmicpc.net/problem/17471)
