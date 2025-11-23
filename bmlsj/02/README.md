
# [백준 - S4] 1120. 문자열 

## ⏰  **time**
60분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

A의 원래 문자들은 B의 연속된 일부 구간과만 비교된다.
A를 B의 모든 가능한 위치에 겹쳐본 뒤
겹치는 구간에서 서로 다른 문자 차이를 계산하고 그중 최소값을 선택하면 된다.


```java
class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		String A = split[0];
		String B = split[1];

		int aLen = A.length();
		int bLen = B.length();

		int minDiff = Integer.MAX_VALUE;
		for (int start = 0; start <= bLen - aLen; start++) {
			int diff = 0;
			for (int i = 0; i < aLen; i++) {
				if (A.charAt(i) != B.charAt(start + i))
					diff++;
			}
			minDiff = Math.min(minDiff, diff);
		}

		System.out.println(minDiff);
	}
}
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/1120

