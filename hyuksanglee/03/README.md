# [PGS - Lv2] 03_시소 짝꿍

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- 정렬
- 맵

## ⏲️**Time Complexity**

$O(N*N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 계산하기 편하게 하기 위해 정렬을 시켜준다.
   ```
   Arrays.sort(weights);
   ```
2. map 값을 추가해주고 map안에 2배, 3/2배, 3/4배, 1배 값이 있는지 찾아주고 있을경우 +1해준다.
   ```
   
            if (num % 3 == 0 && map.containsKey(num * 2 / 3)) {
                answer += map.get(num * 2 / 3);
            }
            
            if (num % 2 == 0 && map.containsKey(num / 2)) {
                answer += map.get(num / 2);
            }
            
            if (num % 4 == 0 && map.containsKey(num * 3 / 4)) {
                answer += map.get(num * 3 / 4);
            }
   ```

## :black_nib: **Review**



## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/152996
