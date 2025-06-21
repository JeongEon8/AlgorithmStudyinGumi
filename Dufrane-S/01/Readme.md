# [백준- S5] 11723. 집합
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
Set

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- X의 크기가 1~20이기 때문에 배열로 set을 구현
  
```java
 private static void add(boolean[] nums, int num) {
        nums[num - 1] = true;
    }
    private static void remove(boolean[] nums, int num) {
        nums[num - 1] = false;
    }
    private static void check(boolean[] nums, int num) {
        if (nums[num - 1]) {
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }
    private static void toggle(boolean[] nums, int num) {
        nums[num - 1] = !nums[num - 1];
    }
    private static void all(boolean[] nums) {
        Arrays.fill(nums, true);
    }
    private static void empty(boolean[] nums) {
        Arrays.fill(nums, false);
    }
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/11723
