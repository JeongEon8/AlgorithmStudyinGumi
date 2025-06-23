# [백준 - S2] 18353. 병사 배치하기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 가장 긴 증가하는 부분 수열 문제
- 이진탐색

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
리스트에 자신보다 큰 가장 마지막 인덱스의 다음에 자신을 배치하는 식으로 가장 긴 감소하는 부분 수열을 구한다.  
인덱스를 찾는데 이진탐색을 사용.
```java
List<Integer> dp = new ArrayList<>();
dp.add(MAX_POWER);
for (int i = 0; i < n; i++) {
    int power = Integer.parseInt(split[i]);
    if (power < dp.get(dp.size() - 1)) {
        dp.add(power);
    } else {
        int left = 0;
        int right = dp.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp.get(mid) <= power) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        dp.set(left, power);
    }
}
```  
## :black_nib: **Review**
$O(N^2)$로도 풀리는 문제

## 📡**Link**
https://www.acmicpc.net/problem/18353
