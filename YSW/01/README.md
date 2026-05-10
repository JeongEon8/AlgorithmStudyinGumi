# [PGS - Lv2] 최댓값과 최솟값 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

최솟값과 최댓값을 출력하는 구현 문제였다.

```java
        String[] sArr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < sArr.length; i++){
            int n = Integer.parseInt(sArr[i]);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        answer += min + " " + max;
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/12939
