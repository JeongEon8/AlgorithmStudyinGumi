# [PGS - LV2] 49994. 방문길이

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 그래프

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
방문기록을 하면서 새로 방문할때마다 visited를 체크하고 카운팅을한다.  
방문을 체크할땐 양방향다 체크한다.
```java
 boolean[][][] visited = new boolean[11][11][4];
int currentX = 5;;
int currentY = 5;
for(char dir: dirs.toCharArray()){
    int nextX = currentX;
    int nextY = currentY;
    int d = 0;
    if(dir == 'U'){
        d = 0;
        nextY++;
    }else if(dir == 'D'){
        d = 2;
        nextY--;
    }else if(dir == 'R'){
        d = 1;
        nextX++;
    }else{
        d = 3;
        nextX--;
    }
    if(nextX < 0||nextX>10||nextY<0||nextY>10)continue;
    if(!visited[currentX][currentY][d]){
        visited[currentX][currentY][d] = true;
        visited[nextX][nextY][(d+2)%4] = true;
        answer++;
    }
    currentX = nextX;
    currentY = nextY;
}
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/49994