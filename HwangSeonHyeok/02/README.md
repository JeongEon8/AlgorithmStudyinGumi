# [PGS - LV2] 12913. 땅따먹기

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 다이나믹프로그래밍

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
이전 행에서 같은 열이 아닌 곳중 최고 득점을 하고 오면 된다.
```java
for(int[] current : land){
    int[] next = new int[4];
    next[0] = Math.max(prev[1],Math.max(prev[2],prev[3])) + current[0];
    next[1] = Math.max(prev[0],Math.max(prev[2],prev[3])) + current[1];
    next[2] = Math.max(prev[1],Math.max(prev[0],prev[3])) + current[2];
    next[3] = Math.max(prev[1],Math.max(prev[2],prev[0])) + current[3];
    prev = next;
}
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=java