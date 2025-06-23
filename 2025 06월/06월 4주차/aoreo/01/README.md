# [백준 - S3] 11659.구간 합 구하기4

## ⏰  **time**
10분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 현재까지의 누적합을 배열에 저장
2. 시작지점부터 끝나는 지점까지의 합을 구하기 위해, 끝나는 지점까지의 누적합에서 시작지점-1까지의 누적합을 빼고 바로 출력
```java
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(start == 0) System.out.println(sum[end]);
            else System.out.println(sum[end] - sum[start-1]);
        }
```

## :black_nib: **Review**
- 누적합이지만 간단한 누적합

## 📡 Link
https://www.acmicpc.net/problem/11659
