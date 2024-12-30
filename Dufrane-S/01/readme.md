# [백준 - 골드 5] 2470. 두 용액
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 먼저 수열을 정렬
2. 이후 시작과 끝값을 합하고 0과 비교해서 시작값을 ++할지 끝값을 --할지 결정
```java
while (start != end) {
            int sum = list.get(start) + list.get(end);
            if (answer > Math.abs(sum)) {
                answer = Math.abs(sum);
                a = list.get(start);
                b = list.get(end);
            }
            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else if (sum == 0) {
                break;
            }
        }
```

## :black_nib: **Review**

## 📡 Link
https://www.acmicpc.net/problem/2470
