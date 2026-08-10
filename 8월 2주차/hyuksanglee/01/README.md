# [PGS - Lv2] 01_할인 행사

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 큐
- 맵

## ⏲️**Time Complexity**

$O(N*M)$

## :round_pushpin: **Logic**

1. 제품명과 개수를 map에 넣어주고 10개를 미리 뽑아서 할인된 제품개수를 체크를 해준다.
2. 그 뒤로는 가장 먼저 산거 순으로 하나씩 뽑고 하나를 넣어주는 원도우 슬라이싱 방식을 이용하여 할인 제품의 개수를 계산해준다.
3. 할인 제품의 개수를 계산할때 다 할인이 되었으면 결과 개수를 올려준다.
4. 마지막으로 결과를 반환
   ```
    for(int i = 0; i<10; i++){
            String prd = discount[i];
            que.add(prd);
            if (map.containsKey(prd)) {
                int nextCount = map.get(prd) - 1;
                map.put(prd, nextCount);
                
                if (nextCount >= 0) {
                    total -= 1;
                }
            }
        }
        if (total == 0) {
                answer++;
            }
        
        for(int i = 10; i<discount.length; i++){
            
            String bfPrd = que.poll();
            if (map.containsKey(bfPrd)) {
                int nextCount = map.get(bfPrd) + 1;
                map.put(bfPrd, nextCount);

                if (nextCount > 0) {
                    total += 1;
                }
            }
            
            String prd = discount[i];
            que.add(prd);
            if (map.containsKey(prd)) {
                int nextCount = map.get(prd) - 1;
                map.put(prd, nextCount);
                

                if (nextCount >= 0) {
                    total -= 1;
                }
            }
            if (total == 0) {
                answer++;
            }
        }
        
        return answer;
   ```

## :black_nib: **Review**


## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/131127
