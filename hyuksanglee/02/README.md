
# [백준- G5] 2143. 두 배열의 합
## ⏰  **time**
60분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N*K)$

## :round_pushpin: **Logic**

- a와 b의 누적합을 하나씩 더해서 T가 되는 개수를 출력해주면 된다.
  	- a의 누적합을 hashMap에 값과 개수를 저장한다. ( 중복된 값을 계산하는 시간을 아끼기 위해)
  	- T에서 b의 누적합 뺀 값이 hashMap에 있는지 찾아서 개수를 더해준다.

```java
	for(int n =0; n<N; n++) {
			int sum = 0;
			for(int m = n; m<N; m++) {
				sum+=A[m];
				sumA.put(sum, sumA.getOrDefault(sum, 0)+1);
			}
		}
		
		N = Integer.parseInt(in.readLine());
		
		input = in.readLine().split(" ");
		int[] B = new int[N];
		for(int n=0; n<N; n++) {
			B[n] = Integer.parseInt(input[n]);
		}
		
		long count =0;
		for(int n =0; n<N; n++) {
			int sum =0;
			for(int m = n; m<N; m++) {
				sum+= B[m];
				int t = T-sum;
				count += sumA.getOrDefault(t, 0);
			}
			
		}
```

## :black_nib: **Review**
- 처음에 해쉬맵을 안쓰고 배열에 다담았다가 시간 초과가 뜨더라구요


## 📡**Link**
- https://www.acmicpc.net/problem/2143

