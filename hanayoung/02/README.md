# [백준 - G1] 13459. 구슬 탈출

## ⏰  **time**
240분 그 이상..?

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O((N×M)²)$

## :round_pushpin: **Logic**
1. 구슬들의 좌표와 이동 횟수 저장할 class 생성
```java
    static class Bead {

        Point blue;
        Point red;
        int depth;

        public Bead(Point blue, Point red, int depth) {
            this.blue = blue;
            this.red = red;
            this.depth = depth;
        }
    }
```
2. depth가 10이상이면 break(탈출 불가 경우)
3. while문을 각각 구슬에 대해서 돌며, 이동할 수 있는 만큼 이동
4. 만약 벽이면 한 칸 이전으로 복귀하고 break
5. 구멍이면 그냥 탈출
6. 구멍으로 탈출한 경우, 파란 구슬이면 answer = 0, 빨간 구슬이면 answer = 1로 업데이트
7. 좌표를 비교해서 같은 경우 cnt로 비교해서 이동거리가 더 먼 것을 한 칸 전으로 복귀
8. 방문처리 후, 큐에 추가
```java
        while (q.size() > 0) {
            Bead b = q.poll();
            if (b.depth >= 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int redCnt = 0, blueCnt = 0;
                int redNx = b.red.x;
                int redNy = b.red.y;
                int blueNx = b.blue.x;
                int blueNy = b.blue.y;

                while (true) {
                    if (maps[redNx][redNy] == 'O') {
                        break;
                    } else if (maps[redNx][redNy] == '#') {
                        redNx -= dx[i];
                        redNy -= dy[i];
                        break;
                    } else {
                        redCnt++;
                        redNx += dx[i];
                        redNy += dy[i];
                    }
                }
                while (true) {
                    if (maps[blueNx][blueNy] == 'O') {
                        break;
                    } else if (maps[blueNx][blueNy] == '#') {
                        blueNx -= dx[i];
                        blueNy -= dy[i];
                        break;
                    } else {
                        blueCnt++;
                        blueNx += dx[i];
                        blueNy += dy[i];
                    }
                }

                if (maps[blueNx][blueNy] == 'O') {
                    answer = 0;
                } else if (maps[redNx][redNy] == 'O') {
                    answer = 1;
                    q.clear();
                    break;
                } else {
                    if (blueNx == redNx && blueNy == redNy) {
                        if (blueCnt > redCnt) {
                            blueNx -= dx[i];
                            blueNy -= dy[i];
                        } else {
                            redNx -= dx[i];
                            redNy -= dy[i];
                        }
                    }
                    if (visited[blueNx][blueNy][redNx][redNy] == false) {
                        visited[blueNx][blueNy][redNx][redNy] = true;
                        q.add(new Bead(new Point(blueNx, blueNy), new Point(redNx, redNy), b.depth + 1));
                    }
                }

            }
        }
```



## :black_nib: **Review**
- 왕왕왕 어려운 문제 너무 복잡해

## 📡**Link**
- https://www.acmicpc.net/problem/13459
