# [SWEA - D3] 01_상호의 배틀필드

## ⏰**time**

20분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 초기값 세팅. cur은 현재 포차의 위치, dir은 포차가 향하는 방향
   ```
            char[][] maps = new char[H][W];
            Point cur = new Point();
            char dir = 'v';
   ```
2. 전차가 있는 위치를 발견하면 cur에 저장하고 해당 방향을 dir에 저장
 ```
            for(int i = 0; i < H; i++) {
                String str = bf.readLine();
                for(int j = 0; j < W; j++) {
                    maps[i][j] = str.charAt(j);
                    if(maps[i][j] == 'v' || maps[i][j] == '<' || maps[i][j] == '>' || maps[i][j] == '^'){
                        cur = new Point(i, j);
                        dir = maps[i][j];
                    }
                }
            }
```
3. 선택에 따라 dir 변경하고 maps에도 업데이트, 이동할 수 있으면 이동하고 cur도 업데이트
```
if(op == 'U') {
                    dir = '^';
                    maps[cur.x][cur.y] = '^';
                    if(isInMap(cur.x-1, cur.y, H, W) && maps[cur.x-1][cur.y] == '.') {
                        maps[cur.x][cur.y] = '.';
                        cur.x -= 1;
                        maps[cur.x][cur.y] = '^';
                    }
                }
```
4. 'S'일 경우, 이동할 수 없거나 사라질 때까지 포탄 위치 이동
5. 벽돌벽일 경우('*'), maps 업데이트
```
else if(op == 'S') {
                    Point shell = new Point(cur.x, cur.y);
                    Point way = new Point();
                    switch (dir) {
                        case '^':
                            way = new Point(-1,0);
                            break;
                        case 'v':
                            way = new Point(1,0);
                            break;
                        case '<':
                            way = new Point(0,-1);
                            break;
                        case '>':
                            way = new Point(0,1);
                            break;
                    }
                    while (true) { 
                        if((shell.x >= H || shell.x < 0 || shell.y >= W || shell.y < 0 ) || maps[shell.x][shell.y] == '#') {
                            break;
                        }
                        if(maps[shell.x][shell.y] == '*') {
                            maps[shell.x][shell.y] = '.';
                            break;
                        }
                        shell.x += way.x;
                        shell.y += way.y;
                    }
                }
```
## :black_nib: **Review**

- 제한시간이 팍팍하지 않는 구현은 좋아 !

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
