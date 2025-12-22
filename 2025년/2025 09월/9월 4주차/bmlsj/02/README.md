# [백준- S5] 1439. 뒤집기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N)$


## :round_pushpin: **Logic**

1. 문자열에서 숫자가 연속된 덩어리(그룹) 로 나누면 된다. 최소 횟수는 그룹 개수 중 더 작은 값
2. 이전 숫자가 무엇인지 구분하기 위해, 처음 문자가 `0`이면 `flag = true`로, `1`이면 `flag = false` 로 초기화
3. 문자열을 한 글자씩 탐색하면서
   - 새로운 1 그룹이 나오면 `oneCnt++`
   - 새로운 0 그룹이 나오면 `zeroCnt++`
4. `0` 그룹과 `1` 그룹 중 더 작은 값을 출력


```java
String s = br.readLine();
char[] slist = s.toCharArray();

int zeroCnt = 0;
int oneCnt = 0;

boolean flag = slist[0] == '1' ? false : true;
for (char str : slist) {
	if (str == '1' && !flag) {
		oneCnt++;
		flag = true;
	} else if (str == '0' && flag) {
		flag = false;
		zeroCnt++;
	}
}

System.out.println(zeroCnt < oneCnt ? zeroCnt : oneCnt);
```


## :black_nib: **Review**
처음에는 접근을 잘못해서 나오는 횟수로 계산했는데, 연속된 수여서 "그룹의 수"를 세야한다.


## 📡**Link**
- https://www.acmicpc.net/problem/1439