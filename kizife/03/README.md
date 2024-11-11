# [SWEA] 14362. 무한로봇 


## ⏰ **time**
60분 

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
요점은 '명령어를 반복하여 원점으로 돌아올 수 있는가'이다.
원점으로 돌아올 수 있다면, 갈 수 있는 지점은 한정되어 있다는 뜻이고, 거기서 최대값을 갱신하면 된다.
돌아올 수 없다면 최대값은 특정할 수 없다.

```java
for (int i = 0; i < 4; i++) {
                 for (char command : line.toCharArray()) {
                     if (command == 'L') {
                         direction = (direction + 1) % 4;
                     } else if (command == 'R') {
                         direction = (direction + 3) % 4; 
                     } else if (command == 'S') {
                         x += dx[direction];
                         y += dy[direction];
                     }
                     int distance = x*x +  y*y;
                     max = Math.max(max, distance); //최대값 갱신
                 }
                  
                 if(x==0 && y==0 && direction ==0) { //초기 설정과 동일하게 복귀하면 끝 
                     finished=true;
                     break;
                 } else finished=false;
            }
```
finished에 true, false를 부여해서 유한한지 여부 확인.
true라면 max값 출력 

## :black_nib: **Review**
풀어놓고도 왜 for문에서 굳이 4번을 반복해야 하는지 헷갈린다. (정답은? 동서남북 네 방향으로 움직이는 경우의 수가 있기 때문에... 이렇게 네 방향만 검토해 주면 웬만큼 확인 가능하므로.)

## 📡**Link**
https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AYCne646vKQDFARx&solveclubId=AZMJoLj6vMwDFAQN&problemBoxTitle=Club+Problem+box+01&problemBoxCnt=0&probBoxId=AZMJoLj6vM0DFAQN
