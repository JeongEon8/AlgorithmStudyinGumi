# [프로그래머스 - Lv2]PCCP_2번. 석유 시추

## ⏰  **time**
50분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(C × R)$

## :round_pushpin: **Logic**
1. 땅을 하나씩 탐색 
    - 기름을 만날때까지 탐색하고 기름이면 bfs로 개수를 세어준다.
    - bfs로 탐색할때 가로해당하는 번호 저장
        - 4번에서 기름을 만나서 bfs탐색을 할때 가로에 해당하는 번호를 저장하면 4,5,6이 저장됨
        - bfs로 갯수를 4,5,6 인덱스 배열에 더해준다.
        - [0, 0, 0, 7, 7, 7, 7 0]
2. 마지막에 배열에서 가장 큰값 출력
    - [8, 8, 8, 7, 7, 7, 9, 2]
    - 여기서 가장 큰값 9를 출력해준다.
```java
for(int c = 0; c<C; c++){
            for(int r = 0; r<R; r++){
                if(land[c][r] ==1 && check[c][r] == false){
                    check[c][r] = true;
                    Queue<Info>que = new ArrayDeque<Info>();
                    Info info = new Info(c, r);
                    que.add(info);
                    
                    int count =0;
                    type ++;
                    
                    find[r] = type;
                    
                    while(!que.isEmpty()){
                        Info newInfo = que.poll();
                        count++;
                        int nc = newInfo.c;
                        int nr = newInfo.r;
                        for(int d = 0; d<4; d++){
                            int cc = nc + dc[d];
                            int cr = nr + dr[d];
                            if(cc<0 || cc>=C || cr<0 || cr>=R){
                                continue;
                            }
                            
                            if(land[cc][cr] == 1 && check[cc][cr] ==false){
                                check[cc][cr] = true;
                                info = new Info(cc,cr);
                                que.add(info);
                                find[cr] = type;
                            }
                        }
                    }
                    
                    for(int i =0; i<R; i++){
                        if(find[i] == type){
                            save[i] += count;
                            if(max< save[i]){
                                max= save[i];
                            }
                        }
                    }
                }
            }
        }
```



## :black_nib: **Review**
- 프로그래머스로 하니깐 디버깅이 없으니 너무 어려워요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/250136
