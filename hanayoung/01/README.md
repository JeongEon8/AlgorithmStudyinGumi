# [백준 - S3] 3273. 두 수의 합

## ⏰  **time**
30분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. arr에 숫자들 담고 정렬
```java
for(int i = 0; i < n; i++) { 
	arr[i] = Integer.parseInt(st.nextToken()); 
}
Arrays.sort(arr);
```
2. start가 end보다 작을 때까지 탐색, arr[start]+arr[end]와 x의 크기 비교
3. sum이 더 작을 경우, start를 오른쪽으로 이동, 같을 경우 answer++, start를 오른쪽으로 이동, sum이 더 클 경우, end를 왼쪽으로 이동
```java
        int start = 0, end = n-1;
        int answer = 0;

        while(start < end) {
            int sum = arr[start] + arr[end];
            switch(Integer.compare(sum, x)) {
                case -1:
                    // sum < x
                    start++;
                    break;
                case 0:
                    answer++;
                    start++;
                    break;
                case 1:
                    end--;
                    break;
            }
        }
```


## :black_nib: **Review**
- 투 포인터랑 친해지기 ! Integer.compare 이용해서 switch문 쓰니까 가독성이 나은 거 같기도

## 📡**Link**
- https://www.acmicpc.net/problem/3273
