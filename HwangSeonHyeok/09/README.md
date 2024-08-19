# [백준 - g1] 1194. 달이 차오른다, 가자.

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 비트마스킹

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

백준 1600번과 비슷하나 열쇠의 유무 조합 64가지에 대한 visited를 체크해야한다.  
유무 2가지 경우에 대한 체크이므로 비트마스킹을 사용하여 열쇠 추가, 유무 체크를하였다.

```cpp
while (!q.isEmpty()) {
            Minsik current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && maze[nextY][nextX] != '#') {
                    if (maze[nextY][nextX] >= 'a' && maze[nextY][nextX] <= 'f') {
                        int key = current.key | (1 << (maze[nextY][nextX] - 'a'));
                        if (!visited[nextY][nextX][key]) {
                            q.add(new Minsik(nextX, nextY, key, current.step + 1));
                            visited[nextY][nextX][key] = true;
                        }
                    } else if (maze[nextY][nextX] >= 'A' && maze[nextY][nextX] <= 'F') {
                        int hasKey = current.key & (1 << (maze[nextY][nextX] - 'A'));
                        if (!visited[nextY][nextX][current.key] && hasKey != 0) {
                            q.add(new Minsik(nextX, nextY, current.key, current.step + 1));
                            visited[nextY][nextX][current.key] = true;
                        }

                    } else if (maze[nextY][nextX] == '1') {
                        ans = current.step + 1;
                        q.clear();
                        break;
                    } else {
                        if (!visited[nextY][nextX][current.key]) {
                            q.add(new Minsik(nextX, nextY, current.key, current.step + 1));
                            visited[nextY][nextX][current.key] = true;
                        }

                    }

                }
            }
        }

```

## :black_nib: **Review**

- 열쇠의 유무 경우의 수가 2^6 = 64개이므로 많은 경우를 체크해야하므로 비트 마스킹을 써야했다.
- 비트 마스킹은 개념만 알고 별로 사용해본 적 없어서 어느정도 찾아보며 풀었다.

## 📡**Link**

- https://www.acmicpc.net/problem/1194
