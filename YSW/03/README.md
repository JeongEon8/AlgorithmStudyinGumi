# [PGS - Lv2] 방문 길이 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

이동했던 경로를 visited에 저장하고 새로운 경로일 경우 answer의 값을 늘려줘서 답을 구했다.

```java
        for(int i = 0; i < dirs.length(); i++){
            int nextRow = row;
            int nextCol = col;
            if(dirs.charAt(i) == 'U'){
                if(row - 1 >= 0){
                    nextRow--;
                }
            }else if(dirs.charAt(i) == 'D'){
                if(row + 1 <= 10){
                    nextRow++;
                }
            }else if(dirs.charAt(i) == 'L'){
                if(col - 1 >= 0){
                    nextCol--;
                }
            }else if(dirs.charAt(i) == 'R'){
                if(col + 1 <= 10){
                    nextCol++;
                }
            }

            if(!visited[row][col][nextRow][nextCol] && !(row == nextRow && col == nextCol)){
                visited[row][col][nextRow][nextCol] = true;
                visited[nextRow][nextCol][row][col] = true;
                answer++;
            }

            row = nextRow;
            col = nextCol;
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/49994
