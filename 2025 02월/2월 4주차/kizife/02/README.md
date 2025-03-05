# [백준] 1920. 수 찾기


## ⏰ **time**
20분

## :pushpin: **Algorithm**
자료 구조, 정렬, 이분 탐색, 해시 

## ⏲️**Time Complexity**
O(n+m)

## :round_pushpin: **Logic**
불필요한 요소를 줄이기 위해 일단 n개 숫자 받을 때 hashset에 받아줌 <br/>
이후 m개 숫자 받을 때마다 이 set에 있는지 없는지 검사해서 바로 출력 
```java
HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            if (set.contains(sc.nextInt())) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
```


## :black_nib: **Review**
알고리즘 초초초초보 시절 시간 초과로 고통받았던 문제입니다 

## 📡**Link**
https://www.acmicpc.net/problem/1920
