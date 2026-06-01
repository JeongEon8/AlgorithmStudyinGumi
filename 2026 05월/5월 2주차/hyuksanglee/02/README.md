# [PGS - Lv2] 02_혼자서 하는 틱택토

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

1. O, X 개수를 세고 X가 많거나 1개 이상 차이 나면 잘못된거
2. O 빙고 일때 X는 1개 크면 잘못된거
3. X 빙고 일때 같지 않으면 잘못됨거
4, 둘다 승리 할경우 잘못됨
위 경우일때는 0을 출력 아닐경우 1을 출력
   ```
       boolean bingoO = isWin(board,'O');
        boolean bingoX = isWin(board,'X');
        
        
       if (countO < countX || countO - countX > 1) {
            return 0;
        }
        
         if (bingoO && bingoX) {
            return 0;
        }
        if (bingoO && countO == countX) {
            return 0;
        }
        if (bingoX && countO > countX) {
            return 0;
        }
        
        
        int answer = 1;
        return answer;
    }
    
 
    private boolean isWin(String[] board, char c) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        
 
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        
        return false;
    }
   
   ```

## :black_nib: **Review**


## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/160585
