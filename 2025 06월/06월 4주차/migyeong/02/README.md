# [백준- G5] 18405. 경쟁적 전염
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity** 
O(N² + S × N²)

## :round_pushpin: **Logic**
- 바이러스 번호 정보를 ArrayList에 담아서 우선순위(낮은 번호) 정렬
- Queue에 정렬한 List 값을 추가
- 바이러스의 상,하,좌,우를 탐색해서 S초 동안 전염되는 바이러스들을 Queue에 추가
- S초가 되면 bfs 탐색 종료
``` java
// 처음 시험관의 바이러스 위치
for (int i = 0; i < N; i++) {
    split = br.readLine().split(" ");
    for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(split[j]);
        if (map[i][j] > 0) {
            // 바이러스 번호, x, y, 시간
            tempList.add(new int[]{map[i][j], i, j, 0});
        }
    }
}

// 바이러스 번호가 작은 것부터 먼저 퍼져야 하므로 정렬
tempList.sort(Comparator.comparingInt(a -> a[0]));
queue.addAll(tempList);
```


## :black_nib: **Review**
코테 공부 레츠고

## 📡**Link**
- https://www.acmicpc.net/problem/18405
