# [PGS - Lv2] 01_귤 고르기

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 맵

## ⏲️**Time Complexity**

$O(N log N)$ 

## :round_pushpin: **Logic**

1. 맵을 사용해서 하나씩 넣고 리스트로 바꿔서 정렬하고 비교
   ```
   for (int num : tangerine) {
               map.put(num, map.getOrDefault(num, 0) + 1);
           }
   
           List<Integer> list = new ArrayList<>(map.values());
   
           list.sort(Comparator.reverseOrder());
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/138476
