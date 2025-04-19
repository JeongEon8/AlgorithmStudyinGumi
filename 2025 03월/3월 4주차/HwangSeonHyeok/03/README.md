# [백준 - S2] 2885. 초콜릿 식사

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 비트마스킹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**  
초콜릿의 최소 크기는 상근이가 원하는 크기보다 큰 2의 제곱수 중 가장 작은 수이다.  
상근이가 원하는 초콜릿의 크기는 이진수로 표현할 수 있고 쪼게는 경우 이진수의 가장 오른쪽1의 수까지 쪼게서 만들어야하므로 가장 오른쪽 1의 인덱스만큼 쪼게면 상근이가 원하는 수를 만들 수 있다.
```java
int n = Integer.parseInt(in.readLine());
String binary = Integer.toBinaryString(n);
int chocolate = (int) Math.pow(2, binary.length());
int cnt = 0;
if (chocolate / n == 2) {
	chocolate /= 2;
} else {
	for (int i = binary.length(); i >= 0; i--) {
		if (binary.charAt(i - 1) == '1') {
			cnt += i;
			break;
		}
	}
}
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/2885
