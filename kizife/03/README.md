# [백준] 2212. 센서 


## ⏰ **time**
60분

## :pushpin: **Algorithm**
그리디 알고리즘, 정렬

## ⏲️**Time Complexity**
O(n log n)

## :round_pushpin: **Logic**
1. 센서를 list에 담아 번호순? 위치순?으로 정렬 <br/>
2. 각 센서간 거리를 계산 <br/>
3. 센서를 k개의 덩어리로 나누면 되는 문제인데, 위에서 도출한 거리 중 내림차순 상위 k-1개를 빼고 남은 거리를 합하면 되는 문제.
```java
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list); //오름차순 정렬

        ArrayList<Integer> dis = new ArrayList<>(); //각 센서간 거리계산
        for (int i = 1; i < n; i++) {
            dis.add(list.get(i) - list.get(i-1));
        }

        Collections.sort(dis, Collections.reverseOrder()); //거리 내림차순 정렬

        int answer = 0;
        for (int i = k-1; i < dis.size(); i++) {
            answer += dis.get(i);
        }
```


## :black_nib: **Review**
너무 어렵지는 않은 문제 

## 📡**Link**
https://www.acmicpc.net/problem/2212 
