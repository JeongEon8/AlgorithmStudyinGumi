# [백준 - S5] 34704. 크기가 4인 박스

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 구현
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
박스의 수를 최소화 하려면 4를 가능한한 꽉 채우는게 좋다.  
정렬을하고 가장 큰 물건을 담고 남은 공간들을 작은 물건들로 빈공간을 채우는 식으로 진행하면 박스의 수를 최소화 할 수 있다.
```java
Arrays.sort(arr);
int ans = 0;
int left = 0;
int right = n - 1;
while (left <= right) {
    int remain = 4 - arr[right];
    right--;
    ans++;
    while (left <= right && arr[left] <= remain) {
        remain -= arr[left];
        left++;
    }
}
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/34704