# [백준 - s3] 17390. 이건 꼭 풀어야 해!

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 정렬
- 누적 합

## :round_pushpin: **Logic**
정렬하고 누적합을 구하고 답변을한다.

```java
Arrays.sort(arr);
for (int i = 1; i <= n; i++) {
	arr[i] += arr[i - 1];
}
for (int i = 0; i < q; i++) {
	split = in.readLine().split(" ");
	sb.append(arr[Integer.parseInt(split[1])] - arr[Integer.parseInt(split[0]) - 1] + "\n");
}

```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/17390
