# [프로그래머스 - lv2] 지게차 크레인

## ⏰  **time**
70분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(q * n * m)$
n = 세로 길이
m = 가로 길이
q = 요청 개수 

## :round_pushpin: **Logic**
1. 문자가 하나일경우 사이드에 있는 해당 문자를 없앤다
    - 가장 밖에 있는 사이드를 for문으로 돌면서 비어있으면 bfs로 탐색해준다.
      
```java
	static void bfs(int i, int j, char find){
        Queue<Info>que = new ArrayDeque<Info>();
        Info info = new Info(i ,j);
        que.add(info);
        
        while(!que.isEmpty()){
            Info infoN = que.poll();
            int ni = infoN.i;
            int nj = infoN.j;
            for(int d = 0; d<4; d++){
                int ci =ni+di[d];
                int cj = nj + dj[d];
                if(ci<0|| ci>=n || cj < 0 || cj>=m){
                    continue;
                }
                if(!check[ci][cj] && arr[ci][cj]==' '){
                    Info infoM = new Info(ci,cj);
                    check[ci][cj] = true;
                    que.add(infoM);
                }else if(arr[ci][cj]== find){
                    check[ci][cj] = true;
                    answer--;
                    arr[ci][cj]=' ';
                }
            }
        }
    }
```

2. 문자가 둘일경우 전체를 돌면서 해당 문자를 없앤다.
3. 남은 문자 개수 출력

```java
	for(int i = 0; i<requests.length; i++){
            char find = requests[i].charAt(0);
            count++;
            if(requests[i].length()>1){
                for( int c = 0; c<n; c++){
                    for(int r = 0; r<m; r++){
                        if(arr[c][r]==find){
                            arr[c][r]=' ';
                            answer--;
                        }
                    }
                }
            }else{
                check = new boolean[n][m];
                
               for(int k=0; k<m; k++){
                   if(arr[0][k] == find){
                       check[0][k] =true;
                        arr[0][k]=' ';
                            answer--;
                   }else if(!check[0][k] && arr[0][k]==' '){
                       bfs(0,k,find);
                   }
                   
                    if(arr[n-1][k] == find){
                       check[n-1][k] =true;
                        arr[n-1][k]=' ';
                            answer--;
                   }else if(!check[n-1][k] && arr[n-1][k]==' '){
                       bfs(n-1,k,find);
                   }
                   
               }
                
                for(int k=0; k<n; k++){
                   if(arr[k][0] == find){
                       check[k][0] =true;
                        arr[k][0]=' ';
                            answer--;
                   }else if(!check[k][0] && arr[k][0]==' '){
                       bfs(k,0,find);
                   }
                   
                    if(arr[k][m-1] == find){
                       check[k][m-1] =true;
                        arr[k][m-1]=' ';
                            answer--;
                   }else if(!check[k][m-1] && arr[k][m-1]==' '){
                       bfs(k,m-1,find);
                   }
                   
               }
            }
        }
```




## :black_nib: **Review**
- 처음에 bfs 코드 짜기 싫어서 전체 for문 돌렸는 데 안되더라구요 꼼수부리다가 시간 더 걸림

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/388353
