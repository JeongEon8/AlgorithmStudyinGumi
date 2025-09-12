
# [백준- G5] 2230. 수 고르기
## ⏰  **time**
60분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**

- 투포인터를 사용하기 위해서는 입력 받은 값을 정렬시켜야한다.
- A는 처음부터 끝까지 비교하고 B는 0부터 증가시킨다.
- B-A를 했을때 M보다 크면 해당 값을 저장하고 A를 증가시키고
- 작을경우 B를 증가시킨다
- 저장된 값들 중에서 최솟값을 출력해준다.

```java
	Arrays.sort(arr);
		
		int index = 0;
		int result = Integer.MAX_VALUE;
		int type = 0;
		
		for(int n = 0; n<N; n++) {
			while(arr[index]-arr[n]<M) {
				index++;
				if(index>N-1) {
					type = 1;
					break;
				}
			}
			if(type==1) {
				break;
			}
			if(arr[index]-arr[n]<result) {
				result = arr[index]-arr[n];
			}
		}
```

## :black_nib: **Review**
- 처음에는 한쪽은 앞에서 한쪽은 뒤에서 가는거를 생각하고 풀었는데 안풀리더라구요


## 📡**Link**
- https://www.acmicpc.net/problem/2230

