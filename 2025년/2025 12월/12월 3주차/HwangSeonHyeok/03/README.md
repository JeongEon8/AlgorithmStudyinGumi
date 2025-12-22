# [백준 - S5] 6108. The Perfect Cow

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 정렬


## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
각 행마다 입력을 받아 정렬을 하고 가운데 값들만 모아서 다시 정렬한다.
```java
int mid = n / 2;
int[] candidate = new int[n];
for (int i = 0; i < n; i++) {
    int[] cows = new int[n];
    StringTokenizer st = new StringTokenizer(in.readLine());
    for (int j = 0; j < n; j++) {
        cows[j] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(cows);
    candidate[i] = cows[mid];
}
Arrays.sort(candidate);
System.out.println(candidate[mid]);
```  


## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/6108