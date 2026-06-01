# [PGS - Lv2] JadenCase 문자열 만들기 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

```java
        String[] arr = s.split("");

        boolean isFirst = true;
        for(String word : arr){
            sb.append(isFirst ? word.toUpperCase() : word);

            isFirst = word.equals(" ") ? true : false;
        }
```

## :black_nib: **Review**

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/12951
