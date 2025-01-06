# [소프티어 - Lv2] 9657. 나무공격
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 공격 1 과 공격 2 배열을 일차원 배열로 입력 받는다.
2. 숲 배열은 2차원 배열이다. 숲 배열을 세로방향으로 탐색한다.
3. 만약 공격 배열이 1이면서 숲배열도 1이면 둘다 0으로 바꾼다.
4. 모든 공격 후 숲배열을 탐색해 숲파괴자의 개수를 센다.
```cpp
    for(int i = 0; i < m; i++){
        for(int j = L1-1; j < R1; j++){
            if(attack1[j] == 1 && arr[j][i] == 1){
                arr[j][i] = 0;
                attack1[j] = 0;
            }
        }

        for(int j = L2 - 1; j < R2; j++){
            if(attack2[j] == 1 && arr[j][i] == 1){
                arr[j][i] = 0;
                attack2[j] = 0;
            }
        }
    }

```

## :black_nib: **Review**
- 
## 📡 Link
https://softeer.ai/practice/9657
