# [PGS - Lv2] 02_예상 대진표

## ⏰**time**

30분

## :pushpin: **Algorithm**

- que

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 토너먼트는 매 라운드마다 두 선수가 대결하고 한 명만 다음 라운드에 진출하는 구조이므로 Queue를 이용해 구현했다.
2. 1번부터 N번까지의 선수를 순서대로 큐에 넣고, 두 명씩 꺼내 대결을 진행한다.
3. 대결하는 두 선수 중 A 또는 B가 포함되어 있다면 해당 선수를 다음 라운드의 임시 큐에 추가한다.
4. 두 선수가 모두 A와 B에 해당한다면 서로 대결하게 된 것이므로 빈 큐를 반환하여 반복문을 종료한다.
5. 두 선수 모두 A와 B가 아니라면 누가 승리해도 결과에 영향을 주지 않으므로 첫 번째 선수를 다음 라운드에 진출시킨다.
6. 각 라운드가 끝날 때마다 라운드 수를 증가시키고, A와 B가 만날 때까지 반복한다
   ```
   static Queue<Integer> find(Queue<Integer> que){
           Queue<Integer> tmp = new ArrayDeque<>();
           while(!que.isEmpty()){
               int n1 = que.poll();
               int n2 = que.poll();
               if(check(n1) && check(n2) ){
                   return new ArrayDeque<>();
               }
               if(check(n1)){
                   tmp.add(n1);
               }else if(check(n2)){
                   tmp.add(n2);
               }else{
                   tmp.add(n1);
               }
           }
           
           return tmp;
           
       }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12985
