# [프로그래머스 - Lv2] 리코쳇 로봇

## ⏰  **time**
70분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(log n)$

## :round_pushpin: **Logic**
1. bfs를 사용해서 탐색할고 방문처리는 3차원 배열을 사용해서 해당칸에 어느방향으로 방문을 했는지 체크를 할거 같다.
2. R 위치를 si, sj 에 담는다.
3. 큐에 si,sj, count를 담아주고 하나씩 뽑아서 주변 탐색(상, 하, 좌,우) 
4. 주변탐색후 길이 있으면 벽을 만날때까지나 끝에 도착할때 까지 직선으로 이동한다. 이동후에는 방문여부를 방향에 맞게 설정해준다.
- [0,6] →[0,5] 로 이동하면 [0][5][좌] 를 방문 체크를 해준다. 
```java
  while(!que.isEmpty()){
            info = que.poll();
            int ni = info.i;
            int nj = info.j;
            int ncount = info.count;
            for(int d =0; d<4; d++){
                int ci = ni+di[d];
                int cj = nj+dj[d];
                if(ci<0 || ci>=board.length || cj<0 || cj>=board[0].length()){
                    continue;
                }
                if(check[ci][cj][d]==false){
                    while(true){
                    if(ci<0 || ci>=board.length || cj<0 || cj>=board[0].length()){
                            break;
                        }
                        if(map[ci][cj]=='D'){
                            break;
                        }
                        
                        check[ci][cj][d]=true;
                        ci = ci+di[d];
                        cj = cj+dj[d];
                    }
                    ci = ci-di[d];
                    cj = cj - dj[d];
                    
                    if (ci == ni && cj == nj) continue;
                    check[ci][cj][d] = true;
                    if(map[ci][cj]=='G'){
                        return ncount+1;
                    }
                    Info ninfo= new Info(ci,cj,ncount+1);
                    que.add(ninfo);
                }
            }
            
        }
        
        int answer = -1;
        return answer;
```


## :black_nib: **Review**

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/169199
