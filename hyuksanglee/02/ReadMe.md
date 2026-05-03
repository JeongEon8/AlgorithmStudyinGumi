# [프로그래머스 - Lv2] 석유시추
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(N x M)$

## :round_pushpin: **Logic**
1. for 문으로 기름이 있을때 동안 탐색을 하고 기름을 찾아준다.
2. 찾은 곳에서 bfs를 탐색해서 기름의 개수와 세로 인덱스를 저장한다.
3. bfs 끝나면 세로 인덱스를 개수 만큼 더해준다.
   - 기름을 팔때 세로로 파기때문에 세로에서 얻을수 있는 기름을알아내기 위해
4, 최댓값을 출력
```java
		public Set<Integer> find(int x, int y, int[][] land) {
        Set<Integer> set = new HashSet<>();
        Queue<Info> que = new ArrayDeque<>();
        
        que.add(new Info(x, y));
        count = 1;
        set.add(x);

        while (!que.isEmpty()) {
            Info data = que.poll();
            for (int d = 0; d < 4; d++) {
                int nx = data.x + dx[d];
                int ny = data.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= land[0].length || ny >= land.length) {
                    continue;
                }

                if (land[ny][nx] == 1 && !check[ny][nx]) {
                    check[ny][nx] = true;
                    set.add(nx);
                    count++; 
                    que.add(new Info(nx, ny));
                }
            }
        }
        return set;
    }
```

## :black_nib: **Review**

  ## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/250136

  

