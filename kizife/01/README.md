# [백준] 11931. 수 정렬하기 4


## ⏰ **time**
5분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
ArrayList에 수를 담고, Collections.sort의 reverse로... 내림차순 정렬하려고 했는데 시간 초과 남 <br/>
그냥 배열 선언하고 Arrays.sort로 오름차순 정렬해서 반대로 출력
```java
        Arrays.sort(arr); 
        for (int i = n - 1; i >= 0; i--) {
            bw.write(arr[i] + "\n");
        }
```


## :black_nib: **Review**
저는 양심이 없습니다!

## 📡**Link**
https://www.acmicpc.net/problem/11931 
