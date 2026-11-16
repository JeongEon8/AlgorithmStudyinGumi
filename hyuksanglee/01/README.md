# [PGS - Lv2] 01_[PCCP 기출문제] 3번 충돌위험 찾기

## ⏰**time**

- 1시간 

## :pushpin: **Algorithm**

- 큐

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 가야하는 지점(route)에서 하나씩 꺼내서 좌표를 찾고 이동좌표를 큐에 담는다
2. 각각의 지점에서 출바하는 것을 큐에 담은 다음 하나씩 꺼내서 같은 지점이 있으면 카운터 해준다.
3. 카운트 해준 값을 출력
   ```
   static Queue<int[]> find(int[] route) {
           Queue<int[]> queue = new LinkedList<>();
   
           int pre = route[0] - 1;
   
           int pr = points[pre][0];
           int pc = points[pre][1];
   
           queue.offer(new int[]{pr, pc});
   
           for (int i = 1; i < route.length; i++) {
               int next = route[i] - 1;
   
               int nr = points[next][0];
               int nc = points[next][1];
   
               while (pr != nr) {
                   pr += (pr < nr) ? 1 : -1;
                   queue.offer(new int[]{pr, pc});
               }
   
               while (pc != nc) {
                   pc += (pc < nc) ? 1 : -1;
                   queue.offer(new int[]{pr, pc});
               }
           }
   
          
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/340211
