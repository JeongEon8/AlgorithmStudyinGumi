# [백준 - S5] 10867. 중복 빼고 정렬하기

## ⏰ **time**

10분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
범위가 -1000~2000이므로 boolean[2001]을 만들고 각각의 값에 +1000한곳에 존재 여부를 기록하고 배열을 처음부터 돌면서 존재하는 숫자를 오름차순으로 출력한다.
```java
for (String num : split) {
	nums[Integer.parseInt(num) + 1000] = true;
}
for (int i = 0; i < 2010; i++) {
	if (nums[i]) {
		sb.append(i - 1000).append(" ");
	}
}
```


## :black_nib: **Review**  
map이랑 정렬하는거보단 boolean에 기록하는게 더 빠른듯
## 📡**Link**
https://www.acmicpc.net/problem/10867