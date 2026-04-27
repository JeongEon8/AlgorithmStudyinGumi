# [프로그래머스 - Lv2] 최댓값과 최솟값

## ⏰**time**

8분

## :pushpin: **Algorithm**

- 문자열 파싱
- 구현
- 정렬

## ⏲️**Time Complexity**

$O(K \log K)$  
(\(K\): 공백으로 분리된 정수 개수)

## :round_pushpin: **Logic**

1. 문자열 `s`를 공백 기준으로 나눠 정수 배열로 변환합니다.

```java
int[] nums = Arrays.stream(s.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
```

2. 정수 배열을 정렬한 뒤, 첫 원소(최솟값)와 마지막 원소(최댓값)를 `"min max"` 형태로 반환합니다.

```java
Arrays.sort(nums);
return nums[0] + " " + nums[nums.length - 1];
```

## :black_nib: **Review**

-

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12939
