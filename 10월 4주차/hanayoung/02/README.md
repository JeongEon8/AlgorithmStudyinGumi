# [백준 - G5] 2230. 수 고르

## ⏰  **time**
90분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. arr에 숫자들 담고 정렬
```java
for(int i = 0; i < N; i++) { 
	arr[i] = Integer.parseInt(st.nextToken()); 
}
Arrays.sort(arr);
```
2. start를 N-1까지 탐색, arr[end] - arr[start]가 M보다 작고 end가 N-1보다 작고 eend가 start보다 크거나 같을 때까지 end를 오른쪽으로 옮기고, diff값 업데이트
3. diff가 M과 같으면 answer를 M으로 업데이트하고 탈출
4. diff가 M보다 크면 answer과 M을 비교해서 더 작은 값으로 업데이트
```java
        int start = 0, end = 0;
        int answer = arr[N-1] - arr[0];

        for(start = 0; start < N; start++) {
            int diff = arr[end] - arr[start];
            while(end >= start && end < N-1 && diff < M) {
                end++;
                diff = arr[end] - arr[start];
            }
            if(diff == M) {
                answer = M;
                break;
            } else if(diff > M) {
                answer = Math.min(answer, diff);
            }
        }
```


## :black_nib: **Review**
- 투 포인터랑 친해지기 ! 같은 지점에서 출발하는 건 낯설다 잉

## 📡**Link**
- https://www.acmicpc.net/problem/2230
