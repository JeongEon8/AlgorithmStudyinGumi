# [PGS - Lv2] 02_[1차] 프렌즈4블록

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O((N*M)^2)$

## :round_pushpin: **Logic**

1. 제거 가능한 2×2 블록을 찾는다.
바로 삭제하지 않고 copyBoard에 표시해 둔다. 여러 2×2 블록이 겹칠 수 있으므로, 탐색 중에 바로 삭제하면 다른 블록 판정에 영향을 줄 수 있기 때문이다. 제거할 블록이 하나라도 발견되면 isFound를 true로 설정하여 다음 과정을 수행한다.
   ```java
        while(isFound){
            isFound = false;
            int[][] copyBoard = new int[N][M];
            for(int i = 0; i < N - 1; i++){
                for(int j = 0; j < M - 1; j++){
                    if(charBoard[i][j] != '.' && (charBoard[i][j] == charBoard[i + 1][j] && charBoard[i][j] == charBoard[i][j + 1] && charBoard[i][j] == charBoard[i + 1][j + 1])){
                        copyBoard[i][j] = 1;
                        copyBoard[i + 1][j] = 1;
                        copyBoard[i][j + 1] = 1;
                        copyBoard[i + 1][j + 1] = 1;
                        isFound = true;
                    }
                }
            }
   ```

2. copyBoard에 표시된 위치를 실제 보드(charBoard)에서 제거한다.
   ```java
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copyBoard[i][j] == 1){
                        charBoard[i][j] = '.';
                    }
                }
            }
   ```

3. 블록이 제거된 후 빈 공간(.)이 생기므로, 각 열을 아래에서 위로 확인하며 블록을 떨어뜨린다. 현재 위치의 블록이 아래로 이동할 수 있는 경우 빈 공간이 없을 때까지 계속 내려준다.
   ```java
            for(int j = 0; j < M; j++){
                for(int i = N - 3; i >= 0; i--){
                    if(charBoard[i][j] == '.'){
                        continue;
                    }
                    
                    for(int k = i + 1; k < N; k++){
                        if(charBoard[k][j] == '.'){
                            charBoard[k][j] = charBoard[k - 1][j];
                            charBoard[k - 1][j] = '.';
                        }
                    }
                }
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17679
