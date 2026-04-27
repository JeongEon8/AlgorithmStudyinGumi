# [PGS - Lv2] 리코쳇 로봇 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- BFS

## ⏲️**Time Complexity**

$O(N * M)$

## :round_pushpin: **Logic**

출발지에서 목표지를 가는 최단 경로 도착할 때 이동횟수를 구하는 문제였다. BFS로 목적지를 최단 경로 도착할 때 이동횟수 구했다.

```java
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if(board[row].charAt(col) == 'G'){
                    return count;
                }

                for(int i = 0; i < 4; i++){
                    int newRow = row;
                    int newCol = col;
                    while(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M ){
                        if(board[newRow].charAt(newCol) == 'D'){
                            break;
                        }
                        newRow += directions[i][0];
                        newCol += directions[i][1];
                    }
                    newRow -= directions[i][0];
                    newCol -= directions[i][1];

                    if(!visited[newRow][newCol]){
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            count++;
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/169199
