# [백준 - G1] 27163. 벚꽃 내리는 시대에 결투를

## ⏰ **time**

80분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 배낭 문제

## ⏲️**Time Complexity**

$O(NL)$

## :round_pushpin: **Logic**

class엔 오라공격인지 여부, 이전에 어디에서 왔는지, 현제까지 받은 오라데미지 합을 저장한다.

```java
static class Aura {
	int value, parent;
	boolean isAuraD;

	public Aura(int aura, int parent, boolean isAuraD) {
		this.value = aura;
		this.parent = parent;
		this.isAuraD = isAuraD;
	}



}
```

dp[공격횟수N][최대라이프L]로 설정한다.  
냅색처럼 오라데미지로 받을수 있는 경우와 라이프 데미지를 받는 경우를 이전 n이 null이 아닌경우에서 연산한다.

```java
	if (x != -1) {
			if(y==-1) {
				dp[0][0] = new Aura(Math.min(x,a), -1, true);
			}else if(x <= a){
				dp[0][0] = new Aura(x, -1, true);
			}
		}
		if (y != -1 && y < l) {
			dp[0][y] = new Aura(0, -1, false);
		}
		for (int i = 1; i < n; i++) {
			split = in.readLine().split(" ");
			x = Integer.parseInt(split[0]);
			y = Integer.parseInt(split[1]);
			for (int j = 0; j < l; j++) {
				// 라이프로 데미지 받는 경우
				if (y != -1 && j >= y && dp[i - 1][j - y] != null) {
					if (dp[i][j] == null) {
						dp[i][j] = new Aura(dp[i - 1][j - y].value, j - y, false);
					} else if (dp[i - 1][j - y].value < dp[i][j].value) {
						dp[i][j] = new Aura(dp[i - 1][j - y].value, j - y, false);
					}
				}
				// 오라로 받는 경우
				if (x != -1 && dp[i - 1][j] != null) {
					if (dp[i][j] == null) {
						if(y==-1) {
							dp[i][j] = new Aura(Math.min(dp[i - 1][j].value + x,a), j, true);
						}else if(dp[i - 1][j].value + x <= a){
							dp[i][j] = new Aura(dp[i - 1][j].value + x, j, true);
						}
					} else if (dp[i - 1][j].value + x < dp[i][j].value) {
						dp[i][j] = new Aura(dp[i - 1][j].value + x, j, true);
					}
				}

			}
		}

```

마지막엔 오라데미지인지 라이프데미지인지를 역산한다.

```java
	static String makeAns(int n, Aura a) {
		String ans = a.isAuraD ? "A" : "L";
		if (a.parent == -1) {
			return ans;
		}
		return makeAns(n - 1, dp[n - 1][a.parent]) + ans;
	}
```

## :black_nib: **Review**

처음엔 과정을 역연산하지않고 객체에 String을 저장해서 시간이 터졌다. 이런경우는 시간 n이 더들더라도 역연산하자.

공격 「
$X$/
$-$」를 받은 경우, 무조건 오라에
$X$ 데미지를 받습니다. 공격을 받았을 때 오라가
$0$ 미만이 될 경우,
$0$으로 회복됩니다.

이 게임을 실제로 꽤 했는데도 위 조건을 깜빡해 꽤 막혔었다.  
더 깔끔하게 풀 방법도 있을거같다..

## 📡**Link**

https://www.acmicpc.net/problem/27163
