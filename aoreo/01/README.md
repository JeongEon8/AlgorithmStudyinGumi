# [백준 - 실버 4] 10610. 30
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 30의 배수인지 여부 판단위해, 각 자리 숫자의 합이 3으로 나누어지는지와 0을 포함하고 있는지 확인.
```java
for (char digit : digits) {
  sum += digit - '0';
  if (digit == '0') hasZero = true;
}
```
2. 저장해둔 각 자릿수 배열을 정렬하여 문자열로 붙이고, 역순으로 출력
```java
Arrays.sort(digits);
StringBuilder sb = new StringBuilder(new String(digits));
System.out.println(sb.reverse());
```

## :black_nib: **Review**
- 생각보다 숫자가 엄청엄청 컸다 죽는 줄 알았네

## 📡 Link
https://www.acmicpc.net/problem/10610
