# [프로그래머스 - Lv2]PCCP_3번. 충돌위험찾기

## ⏰  **time**
59분

## :pushpin: **Algorithm**
- 시뮬레이션

## ⏲️**Time Complexity**
$O(R)$

## :round_pushpin: **Logic**
1. 로봇에 정보를 담는 클래스 생성
    - 로봇에 현재 위치, 이동해야 할 위치
2. routes 크기 만큼 배열을 생성해서 로봇의 정보클래스를 넣어준다.
    - 예시
    
    | [[3, 2], [6, 4], [4, 7], [1, 4]] | [[4, 2], [1, 3], [2, 4]] | 1 |
    | --- | --- | --- |
    
    첫번째 배열에는 로봇에 현재 위치: {1, 4} , 이동해야 할 위치 : {2}
    
    두번째 배열에는 로봇에 현재 위치: {3, 2} , 이동해야 할 위치 : {3}
    
3. 배열을 하나씩 꺼내서 이동시켜준다. 
4. 곁치는 부분이 있으면 개수를 세어준다.
5. 곁치는 개수 출력
```java
 while (count > 0) {
            check = new int[maxC + 1][maxR + 1];
            
            for (int i = 0; i < infos.length; i++) {
                Info cur = infos[i];
                if (cur.done) continue; 
                
                int rr = cur.r;               
                int rc = cur.c;                
                int ar = cur.arrive[1];         
                int ac = cur.arrive[0];         
                
                if (rr == ar && rc == ac) {
                    count--;
                    
                    if (!cur.que.isEmpty()) {
                        int next = cur.que.poll();
                        cur.arrive[0] = points[next][0]; 
                        cur.arrive[1] = points[next][1]; 
                        
                        ar = cur.arrive[1];
                        ac = cur.arrive[0];
                    } else {
                        cur.done = true;
                        continue; 
                    }
                }
                
                if (rc > ac) {
                    rc--;
                } else if (rc < ac) {
                    rc++;
                } else if (rr > ar) {
                    rr--;
                } else if (rr < ar) {
                    rr++;
                }
                
                cur.r = rr;
                cur.c = rc;
                
                if (!cur.done) { 
                    if (rc >= 0 && rr >= 0 && rc <= maxC && rr <= maxR) {
                        check[rc][rr]++;
                        if (check[rc][rr] == 2) {
                            answer++;
                        }
                    }
                }
            }
        }
```



## :black_nib: **Review**
- 코드가 너무 길거같은데 통과만 하면 되지

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/340211
