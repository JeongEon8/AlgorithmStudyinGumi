# [PGS - Lv2] 02_숫자의 표현

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1.1 ~n 까지 더해주면서 총 합이 n 보다 크면 작아질때까지 1부터 하나씩 증가하면서 빼준다.
2. 총합이 n이랑 같으면 answer 개수를 늘려준다.
   ```
   for(int i = 1; i<=n; i++){
            total+= i;
            while(total>n){
                total -= index;
                index++;
            }
            if(total ==n){
                answer++;
            }
        }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12924
