# [백준 - S4] 27919. UDPC 파티

## ⏰ **time**

30분

## :pushpin: **Algorithm**
- 문자열
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

U와 C를 같은 것으로 취급하고 D와 P를 똑같이 취급한다.  
UC가 모두 U라고 가정하면 dp의 개수의 절반을 반올림한것보다 클 때 U가 선정될 수 있다.  
DP는 1개라도 있으면 UC가 몇이든 모두 C로 가정할 수 있으므로 DP일 수 있다.

```java
	for(int i = 0; i<V.length();i++) {
		char c = V.charAt(i);
		if(c=='U'||c=='C')
			uc++;
		else if(c=='D'||c=='P') {
			dp++;
		}
	}
	String ans = "";
	if(uc>dp/2+dp%2) {
		ans+="U";
	}
	if(dp>0) {
		ans+="DP";
	}

```

## :black_nib: **Review**
문자열들을 분류해서 카운팅하고 U, D, P가 나올 수 있는 경우를 찾는 문제.

## 📡**Link**

https://www.acmicpc.net/problem/27919
