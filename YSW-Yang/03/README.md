# [PGS - Lv2] 03_[1차] 캐시

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- Queue
- Set

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

   ```java
        if(cacheSize == 0){
            return cities.length * 5;
        }

        for(String city : cities){
            city = city.toLowerCase();
            
            if(cacheTable.contains(city)){
                queue.remove(city);
                queue.add(city);
                
                answer++;
            }else{
                if(queue.size() == cacheSize){
                    cacheTable.remove(queue.poll());
                }
                cacheTable.add(city);
                queue.add(city);
                
                answer += 5;
            }
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17680
