# [PGS - Lv2] 무인도 여행 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- BFS

## ⏲️**Time Complexity**

$O(N * M)$

## :round_pushpin: **Logic**

BFS로 해당 무인도의 식량을 구해서 최대 머물 수 있는 일수를 list에 저장해서 답을 구했다.

```java
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] || maps[i].charAt(j) == 'X') continue;

                queue.add(new int[] {i, j});
                visited[i][j] = true;
                int food = maps[i].charAt(j) - '0';
                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];

                    for(int k = 0; k < 4; k++){
                        int newRow = row + directions[k][0];
                        int newCol = col + directions[k][1];

                        if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && !visited[newRow][newCol] && maps[newRow].charAt(newCol) != 'X'){
                            food += maps[newRow].charAt(newCol) - '0';
                            queue.add(new int[] {newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }

                list.add(food);
            }
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/154540
