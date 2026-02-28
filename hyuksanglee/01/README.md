# [백준 - G3] 2503. 숫자 야구

## ⏰ **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 123 ~ 987까지 만들 수 있는 숫자들을 큐에 담아 준다.
```java
static void dfs(int depth,String total) {
		if(depth == 3) {
			que.add(total);
			return;
		}
		
		for(int i = 1; i<=9; i++) {
			if(!check[i]) {
				check[i] = true;
				dfs(depth + 1, total + i);
				check[i] = false;
			}
		}	
	}
```

2. 2번째 줄부터 받는 값이랑 비교해서 스트라이크랑 볼의 개수가 같은거만 필터링해준다.

```java
static int[] find(String aw, String st) {
		int[] result = new int[2];
		
		int B = 0;
		int S = 0;
		for(int i = 0 ; i<3; i++) {
			char a = aw.charAt(i);
			for(int j =0; j<3; j++) {
				char s = st.charAt(j);
				if(a == s ) {
					if(i == j) {
						S++;
					}else {
						B++;
					}
				}
			}
		}
		
		result[0] = S;
		result[1] =B;
		
		return result;
	}
```
3. 이걸 반복하고 마지막에 남아 있는 개수를 출력해준다.
   를 구한다.





## :black_nib: Review
- 야구보러 가고 싶다

## 📡**Link**

- [https://www.acmicpc.net/problem/2503](https://www.acmicpc.net/problem/2503)
