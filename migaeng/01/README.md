# [백준 - G4] 17281. ⚾

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 브루트포스
- 백트래킹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
```java

// 선수 순서 정하기 위해 재귀로 모든 경우에 수에 대해 선수를 배치함
static void playerSeq(int num) {
    // 9명 다 채웠으면 종료
    if(num == 10) {
        // 야구 게임 플레이
        int score = play();
        max = Math.max(max, score); // 최대값 갱신신
        
        return;
    }
    
    // 현재 선수를 1번 자리부터 9번 자리까지 넣어보며 재귀 호출
    for(int i=1; i<=9; i++) {
        if(!isPlayerChecked[i]) {
            isPlayerChecked[i] = true;
            
            lineUp[i] = num;
            playerSeq(num + 1);
            
            isPlayerChecked[i] = false;
        }
    }
}

// 선수가 모두 순서대로 배치되었으면 3 아웃이 되기 전까지 이닝을 반복하며 최대 점수를 구함

static int play() {
    int sum = 0;
    
    int idx = 1; // 1번 타자부터 시작
    for(int r=0; r<inning; r++) {
        int inningScore = 0; // 현재 이닝에서 얻는 점수
        out = 0; // 현재 이닝에서 아웃의 수
        boolean[] base = new boolean[4]; // true : 해당 베이스에 선수가 있음, false : 해당 베이스에 선수가 없음
        
        // 3 아웃이 되기 전까지 반복
        while(out < 3) {
            switch(playerStat[r][lineUp[idx]]) {
                // 아웃
                case 0:
                    out++;
                    break;
                // 1루타
                case 1:
                    ...
                    break;
                // 2루타
                case 2:
                    ...
                    break;
                // 3루타	
                case 3:
                    ...
                    break;
                // 홈런	
                case 4:
                    ...
                    break;
            }
            
            // 다음 타자로
            idx++;
            // 만약 10번 타자가 되면 다시 1번 타자로 되돌림
            if(idx >= 10) {
                idx = 1;
            }
        }
        // 해당 이닝에서 얻은 점수를 총 게임 점수에 더해줌
        sum += inningScore;
    }
    // 이번 게임에서 얻은 점수를 반환함
    return sum;
}

```

## :black_nib: **Review**
- 알고리즘 푸는 법을 잊어버렸습니다.. 열심히 할게요..

## 📡**Link**

https://www.acmicpc.net/problem/17281