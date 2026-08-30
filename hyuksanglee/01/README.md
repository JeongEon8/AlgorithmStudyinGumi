# [PGS - Lv2] 01_힌트 스테이지

## ⏰**time**

- 1시간 40분

## :pushpin: **Algorithm**

- 조합

## ⏲️**Time Complexity**

$O(2^N * M)$

## :round_pushpin: **Logic**

1. 힌트 결제 여부를 조합으로 구한다
- 3개의 스테이지이면 안사거나 1, 1 2, 1 2 3, 2, 2 3, 3 이렇게 나온다
- 조합을 리스트에 넣을때 마다 각힌트 스테이지맞게 개수를 더해준다.( 계산하기 편하게 하기위해)
2. 조합에 해당 되는 값을 구한다. 먼저 힌트 결제 비용을 계산 해주고 조합에서 구한 힌트 개수에 맞게 계산을 해준다.
3. 그리고 원래 가격과 비교를 해서 최소값이면 가격을 갱신해준다.( 다음에 비교할떄는 변경된 값이랑 비교)
   
조합 구하는 함수
  ```
   public void combo(int start, int n, List<Integer> cur){
        
        
        if (!cur.isEmpty()) {

            int tmp = 0;

            for (int idx : cur) {
                tmp += hint[idx][0];
            }

            for (int i = 0; i < cost.length; i++) {

                int useHint = Math.min(
                    sale[i + 1],
                    cost[i].length - 1
                );

                tmp += cost[i][useHint];
            }

            if (total > tmp) {
                total = tmp;
            }
        }
        
        for (int i = start; i < n; i++){
            cur.add(i);
            int[] data = hint[i];
            for(int j = 1; j<data.length; j++){
                sale[data[j]] += 1;
            }
            
            combo(i+1, n, cur);
            
           for(int j = 1; j<data.length; j++){
                sale[data[j]] -= 1;
            }
            
            cur.remove(cur.size() -1);
        }
    }
   ```



## :black_nib: **Review**

- 카카오 어려워요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/468377?language=java
