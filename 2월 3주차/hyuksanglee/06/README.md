# [백준 - S3] 15655. N과 M (6) 

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 숫자를 배열에 담고 작은 순으로 정렬 시켜준다.
- 중복없는 조합으로 출력해준다.
```java
  static void dfs(int i , int de, int[] result) {
		if(de>=M) {
			for(int n : result) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for(int n = i; n<N; n++) {
			if(!check[n]) {
				check[n] = true;
				result[de] = arr[n];
				dfs(n+1, de+1, result);
				check[n] = false;
			}
		}
	}
```



## :black_nib: Review
- 
## 📡**Link**

- [https://www.acmicpc.net/problem/15655](https://www.acmicpc.net/problem/15655)
