# [SWEA - D3] 01_의석이의 세로로 말해요

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(1)$ 

## :round_pushpin: **Logic**

1. [i][j]로 넣어둔 값을 [j][i] 순대로 출력하며, 빈칸인 경우('\0')이 아닌 경우에만 출력함
   ```
  for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(words[j][i] != '\0') std::cout << words[j][i];
            }
        }
   ```

## :black_nib: **Review**

- 시간복잡도걸리나? 했는데 아닌 문제 개꿀!
