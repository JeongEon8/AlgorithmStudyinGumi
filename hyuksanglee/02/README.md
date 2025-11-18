# [프로그래머스 - Lv2] 서버 증설 횟수

## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 큐

## ⏲️**Time Complexity**
$O(len + answer)$

## :round_pushpin: **Logic**
1. players을 m으로 나누기 - m 마다 서버가 증설 되야 하므로 
    - [0, 2, 3, 3, 1, 2, 0, …] ⇒ [0,0,1,1,0,0,…]
2. 서버 증설이 필요하면 현재 시간과 k를 더해서 큐에 담아 준다.
    - 2번째 인덱스 부터 2 + k  값을 큐에 담아 준다.
3. 서버 증설 개수랑 큐에 개수랑 비교 해서 작으면 추가해준다.
4. 큐에 첫번째 값이랑 비교해서 현재시간 보다 작으면 pop해준다.
```java
for(int i = 0; i<len; i++){
            players[i] /=m;
        }
        
        Queue<Integer> que = new ArrayDeque<Integer>();
        
        for(int i = 0 ; i<len; i++){
            
            if(que.size()>0){
                while(!que.isEmpty() && que.peek()<=i){
                    que.poll();
                }
            }
            
            if(players[i]>que.size()){
                int need = players[i] - que.size();
                for(int j = 0; j<need; j++){
                   answer++;
                    que.add(i+k); 
                }
                
            }
            
        }
```



## :black_nib: **Review**
- 만료된 서버 삭제와 서버 추가 하는 부분 순서 바꿔서 처음에 틀렸어요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/389479
