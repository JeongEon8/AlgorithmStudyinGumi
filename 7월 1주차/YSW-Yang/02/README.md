# [PGS - Lv2] 02_쿼드압축 후 개수 세기

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 분할정복
- 재귀

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 현재 범위의 모든 값이 같은지 검사한다. 모두 같다면 해당 영역은 더 이상 분할하지 않고, 해당 값(0 또는 1)의 개수를 증가시킨다.
값이 하나라도 다르다면 현재 영역을 가로와 세로를 기준으로 절반씩 나누어 4개의 정사각형 영역으로 분할한다.
분할된 4개의 영역에 대해 같은 과정을 재귀적으로 반복한다.
   ```java
    public void divideAndConquer(int[][] arr, int r, int c, int size){
        if(isSame(arr, r, c, size)){
            answer[arr[r][c]]++;
            return;
        }
        int nextSize = size / 2;
        
        divideAndConquer(arr, r, c, nextSize);
        divideAndConquer(arr, r, c + nextSize, nextSize);
        divideAndConquer(arr, r + nextSize, c, nextSize);
        divideAndConquer(arr, r + nextSize, c + nextSize, nextSize);
    }
    
    public boolean isSame(int[][] arr, int r, int c, int size){
        int baseValue = arr[r][c];
        
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(baseValue != arr[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/68936
