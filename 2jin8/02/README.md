# [백준- S3] 11441. 합 구하기
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- arr[i]: 0 ~ i번째까지 수의 누적합
- a에서 b까지의 합: `arr[b] - arr[a - 1]`
```java
StringTokenizer st = new StringTokenizer(br.readLine());
for (int i = 1; i <= N; i++) {
    arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());
}

StringBuilder sb = new StringBuilder();
M = Integer.parseInt(br.readLine());
for (int i = 0; i < M; i++) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    sb.append(arr[b] - arr[a - 1]).append("\n");
}
System.out.println(sb);
```

## :black_nib: **Review**
저번 코테에 나왔던 문제랑 비슷했다.

## 📡**Link**
- 
