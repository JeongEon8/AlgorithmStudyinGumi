# [백준 - G5] 1660. 캡틴 이다솜

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 수학

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
각각의 사이즈의 사면체에 필요한 대포알 개수를 미리 구한다. 
사이즈가 121이면 이미 대포알이 302621개이므로 입력 개수인 300000만개를 초과하므로 여기까지만 구했다.

```java
	for(int i = 0; i<=121;i++) {
		tmp+= i*(i+1)/2;
		dp[i] = tmp;
	}

```

구한 사면체의 대포알 수를 이용해서 n개의 대포알을 놓을수 있는 최소 사면체 개수를 dp를 이용해서 구한다.
```java
	for(int i = 2; i<=n;i++) {
			for(int j = 1; j<n;j++) {
				if(dp[j]>i) {
					break;
				}
				ans[i] = Math.min(ans[i],ans[i-dp[j]]+1);
			}
		}

```

## :black_nib: **Review**
처음에 문제를 잘못 이해해서 해맸다.

## 📡**Link**

https://www.acmicpc.net/problem/1660
