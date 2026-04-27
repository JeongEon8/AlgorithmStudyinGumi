# [백준 - 실버 3] 3273. 두 수의 합

## ⏰**time**

30분

## :pushpin: **Algorithm**

투 포인터

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**

1. 배열을 정렬한 후 양 끝에 포인터를 둔다.
2. 두 값의 합을 비교하며 포인터를 이동시킨다.
   - 값을 찾으면 정답 처리후 양쪽 포인터를 모두 이동시킨다.
   - 값이 작으면, 합을 늘려야 하기 때문에 `start++`
   - 값이 크면, 합을 줄여야 하기 때문에 `end--`

```java
Arrays.sort(nums);
int ans = 0;
int start = 0, end = n - 1;
while (start < end) {

    if (nums[start] + nums[end] == x) {
        ans++;
        start++;
        end--;
    } else if (nums[start] + nums[end] > x) {
        end--;
    } else {
        start++;
    }
}

System.out.println(ans);
```

## :black_nib: **Review**

## 📡 Link

<https://www.acmicpc.net/problem/3273>
