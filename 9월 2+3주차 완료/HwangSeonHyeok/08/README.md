# [백준 - s4] 23305. 수강변경

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘

## :round_pushpin: **Logic**

수요-공급으로 수요가 공급보다 많은 만큼 수강하지 못하는 학생들이다.

```java
for(int i = 0; i<n; i++) {
	has[Integer.parseInt(split[i])]++;
}
split = in.readLine().split(" ");
for(int i = 0; i<n; i++) {
	want[Integer.parseInt(split[i])]++;
}
int ans = 0;
for(int i =0; i<1000001;i++) {
	ans += Math.max(want[i]-has[i],0);
}
```

## :black_nib: **Review**

처음엔 해시맵으로 0이되는 경우를 찾으려 했는데 테스트 케이스에 해시충돌로 시간초과가 발생하는 경우가 있는것 같다.

## 📡**Link**

https://www.acmicpc.net/problem/23305
