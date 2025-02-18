# [백준 - 실버 5] 14405. 피카츄
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 초기 문자열의 길이를 저장
2. 전체길이에서 "pi", "ka", "chu" 를 제거하고의 길이를 더한 값과 비교하여 같을 경우 "YES", 아닐 경우 "NO"
```java
        int replaceLen = (originLen - str.replace("pi", "").length()) + (originLen - str.replace("ka", "").length()) + (originLen - str.replace("chu", "").length());
```

## :black_nib: **Review**
- 시간복잡도 지피티한테 물어보다가 얻은 코드인데 이게 훨씬 간단하다잉 담부턴 이거 쓰도록 !
```java
        if (str.matches("^(pi|ka|chu)*$")) System.out.println("YES");
        else System.out.println("NO");
```

## 📡 Link
https://www.acmicpc.net/problem/14405
