
# [백준 - S5] 03_중복 빼고 정렬하기

## ⏰  **time**
10분


## ⏲️**Time Complexity**
$O(NlogN)$

## 풀이 

정렬이 되는 TreeSet에 넣기!

```java
Set<Integer> set = new TreeSet<>();
for(int i = 0; i < N; i++) {
		nums[i] = Integer.parseInt(split[i]);
		set.add(nums[i]);
}
```

## :black_nib: **Review**
짱쉽그나

## 📡**Link**
- https://www.acmicpc.net/problem/10867

