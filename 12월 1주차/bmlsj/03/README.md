# [백준 - S4] 1235. 학생 번호

## ⏰  **time**

20분

## ⏲️**Time Complexity**

$O(N × K)$

## 풀이

- `k = 1`부터 시작해서 모든 학생 번호의 뒤에서 k자리를 잘라 `HashSet`에 넣는다.
- Set 크기가 학생 수(`N`)과 같으면, 그 `k`가 정답
    아니면 k를 1 증가시켜 반복한다.

```java
int start = 0;
HashSet<Integer> set = new HashSet<Integer>();

while (set.size() != n) {
 ++start;
 set.clear();
 for (int i = 0; i < n; i++) {
  String split = nums[i].substring(nums[i].length() - start);
  set.add(Integer.parseInt(split));
 }
}
```

## :black_nib: **Review**

## 📡**Link**

- <https://www.acmicpc.net/problem/1235>
