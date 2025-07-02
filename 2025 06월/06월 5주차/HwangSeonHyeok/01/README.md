# [백준 - S1] 16206. 롤케이크

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
10의 배수인 롤케이크를 다 자르면 남은거 없이 자른횟수 +1개의 롤케이크가 나온다.  
즉 10의 배수인 롤케이크중 짧은 롤케이크부터 우선적으로 자르면된다
```java
Arrays.sort(cakes, new Comparator<Integer>() {
	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 % 10 == 0 && o2 % 10 == 0) {
			return o1 - o2;
		}
		if (o1 % 10 == 0) {
			return -1;
		}
		if (o2 % 10 == 0) {
			return 1;
		}
		return o1 - o2;
	}
});
int ans = 0;
for (int cake : cakes) {
	int cutCnt = (cake - 1) / 10;
	if (m >= cutCnt) {
		m -= cutCnt;
		ans += cutCnt;
		if (cake % 10 == 0)
			ans++;
	} else {
		ans += m;
		break;
	}
}
```


## :black_nib: **Review**  
Comparator 싫어요..  
## 📡**Link**
https://www.acmicpc.net/problem/16206
