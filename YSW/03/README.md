# [PGS - Lv2] 혼자서 하는 틱택토 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

O가 선공 이기 때문에 O가 X의 개수보다 작으면 안되고, O의 개수가 X보다 2개 이상 많으면 안되는 경우, O가 이겼을 때 O의 개수가 X보다 1개 더 많지 않은 경우, X가 이겼을때 O와 X의 개수가 같지 않은 경우를 비정상적인 상황이라고 판단하고 이런 예외에 속하지 않는 경우는 정상적인 상황이라고 판단해서 문제를 풀었다.

```java
        for(String s : board){
            for(int i = 0; i < 3; i++){
                if(s.charAt(i) == 'O'){
                    oCount++;
                }else if(s.charAt(i) == 'X'){
                    xCount++;
                }
            }
        }

        if(oCount > xCount + 1 || oCount < xCount || (oCount != xCount + 1 && isBingo(board, 'O')) || (oCount != xCount && isBingo(board, 'X'))){
            return 0;
        }

        return 1;
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/160585
