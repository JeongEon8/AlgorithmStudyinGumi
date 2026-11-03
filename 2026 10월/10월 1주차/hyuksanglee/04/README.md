# [PGS - Lv2] 04_배달

## ⏰**time**

- 30 분

## :pushpin: **Algorithm**

- 다익스트라

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 1마을 부터 연결 된곳을 조사를 하고 그 뒤에 연결된 마을까 거리 계산을 해서 경유해서 가는게 더 가까우면 갱신을 시켜준다.
   ```
   while(!pq.isEmpty()){
              int[] Qdata = pq.poll();
              int num = Qdata[0];
              int price = Qdata[1];
              
              if(dst[num] < price){
                  continue;
              }
              
              for(Info info :list[num]){
                  int head = info.head;
                  int tail = info.tail;
                  int movePrice = info.price;
                  int total = price + movePrice;
                  
                  if(dst[tail] > total){
                      dst[tail] = total;
                      pq.add(new int[]{tail, total});
                  }
              }
          }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12978
