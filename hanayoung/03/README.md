# [백준 - G3] 15684. 사다리 조

## ⏰  **time**
2일..?

## :pushpin: **Algorithm**
백트래킹

## ⏲️**Time Complexity**
$O(((N-1)*H)^3*N*H)$

## :round_pushpin: **Logic**
1. 가능한 경우의 수를 모두 candidates에 담음. 이미 있는 건 삭
```java
        for (int i = 1; i < H+1; i++) {
            for (int j = 1; j < N; j++) {
                candidates.add(new Point(i, j));
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a][b] = true;
            candidates.remove(new Point(a, b));
        }
```
2. 3개까지 추가할 수 있으므로 크기 3의 배열 생성
3. answer이 -1이 아닌데(이미 할당됨) depth가 answer보다 크거나 같으면 return
4. depth가 maxK와 같으면 이동해보고 확인. 반환값이 false이면 불가능한 것이므로 return
5. answer가 -1이 아니면 더 작은 값으로 answer 업데이트, 아니라면 answer = depth로 업데이트 후 return
```java
        if (answer == 0) {
            return;
        }
        if(answer != -1 && depth >= answer) return;

        if (depth == maxK) {
            if(check(current, candidates, maps, H, N) == false) return;
            if(answer != -1) {
                answer = Math.min(answer, depth);
            } else {
                answer = depth;
            }
            return;
        }
```
6. candidates.size()만큼 탐색하며, y좌표 1작은 곳과 1 큰 곳  방문여부 확인, 방문했으면 return
7. current[depth] 에 i를 할당. 방문처리, maps에도 처리하고 재귀함수 호출.
```java
        for (int i = r; i < candidates.size(); i++) {
            Point candidate = candidates.get(i);
            if((candidate.y - 1 >= 0 && visited[candidate.x][candidate.y - 1]) || (candidate.y + 1 < N+1 && visited[candidate.x][candidate.y + 1])) continue;
            current[depth] = i;
            visited[candidate.x][candidate.y] = true;
            maps[candidate.x][candidate.y] = true;
            recur(depth + 1, i + 1, current, visited, N, H, maxK, maps, candidates);
            current[depth] = -1;
            visited[candidate.x][candidate.y] = false;
            maps[candidate.x][candidate.y] = false;
        }
```
8. 1부터 N까지 탐색하며 이동하는 길에 maps가 true이며 무조건 이동하고 마지막에 curN이 i와 다르면 return false, 아니라면 끝까지 진행 후 return true; 
```java
    public static boolean check(int[] current, List<Point> candidates, boolean[][] maps, int H, int N) {
        for (int i = 1; i < N + 1; i++) {
            int curH = 1;
            int curN = i;
            while (curH <= H) {
                if (curN < N && maps[curH][curN] == true) {
                    // 이동하는 걸 마주치면 무조건 이동해야 함
                    curN += 1;
                    
                } else if (curN > 1 && maps[curH][curN - 1] == true) {
                    curN -= 1;
                }
                curH++;
            }
            if (curN != i) {
                return false;
            }
        }

        return true;
    }
```


## :black_nib: **Review**
- 생각하고 정리하는 게 너무 어려웠고,.. 시간초과의 늪에서 겨우 빠져나옴.. 어떻게 추려낼지 고민해봐야했던 문제

## 📡**Link**
- https://www.acmicpc.net/problem/15684
