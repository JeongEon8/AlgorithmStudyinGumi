# [백준] 25757. 임스와 함께하는 미니게임
 
## ⏰  **time**
20분  

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
- 이름 입력받아 Set에 추가한다.
```java
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            set.add(name); // 중복된 이름은 자동으로 제거됨
        }
```

- 이름의 수를 (게임에 필요한 인원 - 1)로 나눈다. 


## :black_nib: **Review**
- 처음에는 if(list.contains ~..)를 써서 중복을 배제하고자 했는데, 시간 초과가 나서 문제 의도가 그것이 아니란 걸 알았다.
- 그래서 Set 사용...  

## 📡**Link**
- https://www.acmicpc.net/problem/25757 
