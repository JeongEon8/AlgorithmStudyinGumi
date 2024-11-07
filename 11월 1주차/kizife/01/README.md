# [백준] 15961. 회전 초밥 
 
## ⏰  **time**
2시간 

## :pushpin: **Algorithm**
두 포인터, 슬라이딩 윈도우 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
초밥 종류, 해당 종류의 개수를 저장할 해시맵 생성.
처음 k개의 초밥에 대한 종류, 개수 확인 
```java
        for (int i = 0; i < k; i++) {
            sushiCount.put(sushi[i], sushiCount.getOrDefault(sushi[i], 0) + 1);
        }
```

현재 종류 개수를 최대값으로 설정 + 쿠폰 초밥이 없으면 +1
```java
        max = sushiCount.size();
        if (!sushiCount.containsKey(c)) {
            max++;
        }
```

이전 초밥 빼고, 새 초밥 추가하면서 최대값 갱신하기...
```java
        for (int i = 1; i < n; i++) {
            int prev = sushi[(i - 1) % n]; // 이전 초밥
            int newSushi = sushi[(i + k - 1) % n]; // 새 초밥 

            // 이전 초밥 제거
            sushiCount.put(prev, sushiCount.get(prev) - 1);
            if (sushiCount.get(prev) == 0) {
                sushiCount.remove(prev);
            }

            // 새로운 초밥
            sushiCount.put(newSushi, sushiCount.getOrDefault(newSushi, 0) + 1);

            // 현재 초밥 종류 수 계산 + 쿠폰초밥 없으면 +1
            int current = sushiCount.size();
            if (!sushiCount.containsKey(c)) {
                current++;
            }

            // 최댓값 갱신 
            max = Math.max(max, current);
        }
```

## :black_nib: **Review**
새 초밥 더하고 앞에 것 빼는 방식은 바로 떠오르지 않았다,,, 

## 📡**Link**
- https://www.acmicpc.net/problem/15961 
