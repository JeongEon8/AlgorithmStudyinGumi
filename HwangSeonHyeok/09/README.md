# [백준 - S4] 16471. 작은 수 내기

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

주언이의 카드와 사장님의 카드를 정렬하고 주언이의 가장 작은 카드로 사장님의 카드중 주언이의 카드보다 큰 가장 작은 카드랑 매칭되게하면된다. 이때 N/2+1번 이상 이길 수 있으면 바로 승리한다.

```java
Arrays.sort(mine);
Arrays.sort(master);
int mineIdx = 0;
int masterIdx = 0;
boolean defeat = true;
while (mineIdx < n && masterIdx < n) {
	if (mine[mineIdx] < master[masterIdx++]) {
		mineIdx++;
		if (mineIdx >= master.length / 2 + 1) {
			System.out.println("YES");
			defeat = false;
			break;
		}

	}
}
if (defeat)
	System.out.println("NO");

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16471
