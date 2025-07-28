# [백준] 11399. ATM


## ⏰ **time**
5분

## :pushpin: **Algorithm**
그리디 알고리즘, 정렬 

## ⏲️**Time Complexity**
O(n log n)

## :round_pushpin: **Logic**
그냥 소요시간을 가장 짧은 순으로 정렬하고, <br>
각각의 소요시간에 n-- 해가면서 곱해주고 다 더하면 된다. ㅎ 
```java
        Collections.sort(times);

        int result = 0;
        for (int i = n; i >= 1; i--) {
            result += times.get(n-i) * i;
        }
```

## :black_nib: **Review**
아이쉬워 

## 📡**Link**
https://www.acmicpc.net/problem/11399 
