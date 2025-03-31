# [백준 - S5] 16112. 정열적인 정렬

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
Arrays.sort를 사용해서 정렬렬
```java
int[] nums = new int[n];
for (int i = 0; i < n; i++) {
    nums[i] = Integer.parseInt(line[i]);
}

Arrays.sort(nums);
```

## :black_nib: **Review**  
정렬 완료

## 📡**Link**
https://www.acmicpc.net/problem/16212