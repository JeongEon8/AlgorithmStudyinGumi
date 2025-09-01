# [백준 - S2] 1182. 부분수열의 합 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 백트래킹

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**

부분수열 알고리즘을 사용해서 풀었다. subSet(arr, result, index + 1) 부분이 현재 요소을 포함하지 않을 경우이고, result.add(arr[index]) 부분이 현재 요소를 포함하는 경우 이다.

```java
        if(index == arr.length) {
			int sum = 0;
			if(result.size() == 0) {
				return;
			}

			for (int i = 0; i < result.size(); i++) {
				sum += result.get(i);
			}
			if(sum == S) {
				count++;
			}

			return;
		}

		subSet(arr, result, index + 1);

		result.add(arr[index]);
		subSet(arr, result, index + 1);
		result.remove(result.size() - 1);
```

## :black_nib: **Review**

부분 수열을 알고 있으면 풀 수 있는 문제 같다.

## 📡**Link**

https://www.acmicpc.net/problem/1182
